package questionnaire;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * The type Questionnaire.
 */
public class QuestionnaireImpl implements Questionnaire {
  private final Map<String, Question> questionMap;
  private List<Question> questions;

  /**
   * Instantiates a new Questionnaire.
   */
  public QuestionnaireImpl() {
    this.questions = new ArrayList<>();
    this.questionMap = new HashMap<>();
  }

  @Override
  public void addQuestion(String identifier, Question q)
          throws IllegalArgumentException {
    if (identifier == null || identifier.isEmpty()) {
      throw new IllegalArgumentException("Identifier is empty");
    }
    if (q == null) {
      throw new IllegalArgumentException("Question is empty");
    }
    if (questionMap.containsKey(identifier)) {
      throw new IllegalArgumentException("Identifier already exists");
    }
    questions.add(q);
    questionMap.put(identifier, q);
  }

  @Override
  public void removeQuestion(String identifier) {
    if (identifier == null || identifier.isEmpty()) {
      throw new IllegalArgumentException("Identifier is empty");
    }
    if (!questionMap.containsKey(identifier)) {
      throw new NoSuchElementException("This identifier does not exist");
    } else {
      questions.remove(questionMap.get(identifier));
      questionMap.remove(identifier);
    }
  }

  @Override
  public Question getQuestion(int num) {
    if (num < 1 || num > questions.size()) {
      throw new IndexOutOfBoundsException("There is no such question in the list");
    }
    // list starts at 0
    return questions.get(num - 1);
  }

  @Override
  public Question getQuestion(String identifier) {
    if (identifier == null || identifier.isEmpty()) {
      throw new IllegalArgumentException("Identifier is empty");
    }
    if (!questionMap.containsKey(identifier)) {
      throw new NoSuchElementException("This identifier does not exist");
    }
    return questionMap.get(identifier);
  }

  @Override
  public List<Question> getRequiredQuestions() {
    return questions.stream()
            .filter(Question::isRequired)
            .collect(Collectors.toList());
  }

  @Override
  public List<Question> getOptionalQuestions() {
    return questions.stream()
            .filter(q -> !q.isRequired())
            .collect(Collectors.toList());
  }

  @Override
  public boolean isComplete() {
    return questions.stream()
            .filter(Question::isRequired)
            .noneMatch(q -> q.getAnswer().isEmpty());
  }

  @Override
  public List<String> getResponses() {
    return questions.stream()
            .map(Question::getAnswer)
            .collect(Collectors.toList());
  }

  @Override
  public Questionnaire filter(Predicate<Question> pq) {
    if (pq == null) {
      throw new IllegalArgumentException("The predicate is empty or the list is empty");
    }
    List<Question> filteredQuestions = questions.stream()
            .filter(pq)
            .map(Question::copy)
            .collect(Collectors.toList());
    QuestionnaireImpl filteredQuestionnaire = new QuestionnaireImpl();
    for (Question q : filteredQuestions) {
      if (q == null) {
        throw new IllegalArgumentException("The question is empty");
      }
      filteredQuestionnaire.addQuestion(q.getPrompt(), q);
    }
    return filteredQuestionnaire;
  }

  @Override
  public void sort(Comparator<Question> comp) {
    if (comp == null) {
      throw new IllegalArgumentException("Comparator is empty");
    }
    List<Question> sortedQuestions = questions.stream()
            .sorted(comp)
            .collect(Collectors.toList());
    this.questions = sortedQuestions;
  }

  @Override
  public <R> R fold(BiFunction<Question, R, R> bf, R seed) {
    if (bf == null || seed == null) {
      throw new IllegalArgumentException("BiFunction or Question cannot be empty");
    }
    R finalResult = seed;
    for (Question q : questions) {
      finalResult = bf.apply(q, finalResult);
    }
    return finalResult;
  }

  @Override
  public String toString() {
    StringBuilder template = new StringBuilder();
    for (int i = 0; i < questions.size(); i++) {
      Question questionChosen = this.questions.get(i);
      template.append("Question: ")
              .append(questionChosen.getPrompt())
              .append("\n\n")
              .append("Answer: ")
              .append(questionChosen.getAnswer());
      // if not the last question, add a new line
      if (i < this.questions.size() - 1) {
        template.append("\n\n");
      }
    }
    return template.toString();
  }
}