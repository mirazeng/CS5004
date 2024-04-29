import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import questionnaire.Likert;
import questionnaire.Question;
import questionnaire.Questionnaire;
import questionnaire.QuestionnaireImpl;
import questionnaire.ShortAnswer;
import questionnaire.YesNo;

/**
 * The type Test questionnaire.
 */
public class TestQuestionnaire {
  private Questionnaire questionnaire;

  /**
   * Sets up.
   */
  @BeforeEach
  public void setUp() {
    questionnaire = new QuestionnaireImpl();
  }

  /**
   * Test add question.
   */
  @Test
  public void testAddQuestion() {
    Question q1 = new Likert("How much do you like this class?", true);
    Question q2 = new ShortAnswer("What is your favorite color?", false);
    Question q3 = new YesNo("Do you like this class?", true);

    questionnaire.addQuestion("q1", q1);
    questionnaire.addQuestion("q2", q2);
    questionnaire.addQuestion("q3", q3);

    // implement getQuestion to check if the questions are added
    assertEquals(q1, questionnaire.getQuestion("q1"));
    assertEquals(q2, questionnaire.getQuestion("q2"));
    assertEquals(q3, questionnaire.getQuestion("q3"));
  }

  /**
   * Test invalid add question.
   */
  @Test
  public void testInvalidAddQuestion() {
    Question q1 = new Likert("How much do you like this class?", true);
    Question q2 = new ShortAnswer("What is your favorite color?", false);
    Question q3 = new YesNo("Do you like this class?", true);

    // addQuestion should throw an exception if the identifier is null or empty
    assertThrows(IllegalArgumentException.class, () -> questionnaire.addQuestion(null, q1));
    assertThrows(IllegalArgumentException.class, () -> questionnaire.addQuestion("", q2));

    // addQuestion should throw an exception if the question is null
    assertThrows(IllegalArgumentException.class, () -> questionnaire.addQuestion("q3", null));

    // addQuestion should throw an exception if the identifier already exists
    Question q4 = new Likert("How much do you like this class?", true);
    questionnaire.addQuestion("q4", q4);
    assertThrows(IllegalArgumentException.class, () -> questionnaire.addQuestion("q4", q4));
  }

  /**
   * Test remove question.
   */
  @Test
  public void testRemoveQuestion() {
    Question q1 = new Likert("How much do you like this class?", true);
    Question q2 = new ShortAnswer("What is your favorite color?", false);
    Question q3 = new YesNo("Do you like this class?", true);

    questionnaire.addQuestion("q1", q1);
    questionnaire.addQuestion("q2", q2);
    questionnaire.addQuestion("q3", q3);

    questionnaire.removeQuestion("q1");
    questionnaire.removeQuestion("q2");
    questionnaire.removeQuestion("q3");

    // the removed method will remove identifiers and questions from the list
    // it should throw an exception if the identifier does not exist
    assertThrows(NoSuchElementException.class, () -> questionnaire.getQuestion("q1"));
    assertThrows(NoSuchElementException.class, () -> questionnaire.getQuestion("q2"));
    assertThrows(NoSuchElementException.class, () -> questionnaire.getQuestion("q3"));
  }

  /**
   * Test invalid remove question.
   */
  @Test
  public void testInvalidRemoveQuestion() {
    Question q1 = new Likert("How much do you like this class?", true);
    Question q2 = new ShortAnswer("What is your favorite color?", false);
    Question q3 = new YesNo("Do you like this class?", true);

    questionnaire.addQuestion("q1", q1);
    questionnaire.addQuestion("q2", q2);
    questionnaire.addQuestion("q3", q3);

    // removeQuestion should throw an exception if the identifier is null or empty
    assertThrows(IllegalArgumentException.class, () -> questionnaire.removeQuestion(null));
    assertThrows(IllegalArgumentException.class, () -> questionnaire.removeQuestion(""));

    // removeQuestion should throw an exception if the identifier does not exist
    assertThrows(NoSuchElementException.class, () -> questionnaire.removeQuestion("q4"));
  }

  /**
   * Test get question.
   */
  @Test
  public void testGetQuestion() {
    Question q1 = new Likert("How much do you like this class?", true);
    Question q2 = new ShortAnswer("What is your favorite color?", false);
    Question q3 = new YesNo("Do you like this class?", true);

    questionnaire.addQuestion("q1", q1);
    questionnaire.addQuestion("q2", q2);
    questionnaire.addQuestion("q3", q3);

    // getQuestion should return the question with the given identifier
    assertEquals(q1, questionnaire.getQuestion("q1"));
    assertEquals(q2, questionnaire.getQuestion("q2"));
    assertEquals(q3, questionnaire.getQuestion("q3"));
  }

  /**
   * Test invalid get question.
   */
  @Test
  public void testInvalidGetQuestion() {
    Question q1 = new Likert("How much do you like this class?", true);
    Question q2 = new ShortAnswer("What is your favorite color?", false);
    Question q3 = new YesNo("Do you like this class?", true);

    questionnaire.addQuestion("q1", q1);
    questionnaire.addQuestion("q2", q2);
    questionnaire.addQuestion("q3", q3);

    // getQuestion should throw an exception if the identifier is null or empty
    assertThrows(IllegalArgumentException.class, () -> questionnaire.getQuestion(null));
    assertThrows(IllegalArgumentException.class, () -> questionnaire.getQuestion(""));

    // getQuestion should throw an exception if the identifier does not exist
    assertThrows(NoSuchElementException.class, () -> questionnaire.getQuestion("q4"));
  }

  /**
   * Test get question num.
   */
  @Test
  public void testGetQuestionNum() {
    Question q1 = new Likert("How much do you like this class?", true);
    Question q2 = new ShortAnswer("What is your favorite color?", false);
    Question q3 = new YesNo("Do you like this class?", true);

    questionnaire.addQuestion("q1", q1);
    questionnaire.addQuestion("q2", q2);
    questionnaire.addQuestion("q3", q3);

    // getQuestion should return the question with the given number
    assertEquals(q1, questionnaire.getQuestion(1));
    assertEquals(q2, questionnaire.getQuestion(2));
    assertEquals(q3, questionnaire.getQuestion(3));
  }

  /**
   * Test invalid get question num.
   */
  @Test
  public void testInvalidGetQuestionNum() {
    Question q1 = new Likert("How much do you like this class?", true);
    Question q2 = new ShortAnswer("What is your favorite color?", false);
    Question q3 = new YesNo("Do you like this class?", true);

    questionnaire.addQuestion("q1", q1);
    questionnaire.addQuestion("q2", q2);
    questionnaire.addQuestion("q3", q3);

    // getQuestion should throw an exception if the number is less than 1
    assertThrows(IndexOutOfBoundsException.class, () -> questionnaire.getQuestion(0));

    // getQuestion should throw an exception if the number is greater than the number of questions
    assertThrows(IndexOutOfBoundsException.class, () -> questionnaire.getQuestion(4));
  }

  /**
   * Test filtered questions.
   */
  @Test
  public void testFilteredQuestions() {
    Question q1 = new Likert("How much do you like this class?", true);
    Question q2 = new ShortAnswer("What is your favorite color?", true);
    Question q3 = new YesNo("Do you like this class?", false);

    questionnaire.addQuestion("q1", q1);
    questionnaire.addQuestion("q2", q2);
    questionnaire.addQuestion("q3", q3);

    Questionnaire filteredQ = questionnaire.filter(Question::isRequired);

    // getRequiredQuestions should return a list of all required questions
    assertEquals(2, filteredQ.getRequiredQuestions().size());
    assertEquals(2, questionnaire.getRequiredQuestions().size());

    // getOptionalQuestions should return a list of all optional questions
    // TODO: WHY 0?
    assertEquals(0, filteredQ.getOptionalQuestions().size());
    assertEquals(1, questionnaire.getOptionalQuestions().size());
  }

  /**
   * Test is complete.
   */
  @Test
  public void testIsComplete() {
    Question q1 = new Likert("How much do you like this class?", true);
    Question q2 = new ShortAnswer("What is your favorite color?", true);
    Question q3 = new YesNo("Do you like this class?", false);

    questionnaire.addQuestion("q1", q1);
    questionnaire.addQuestion("q2", q2);
    questionnaire.addQuestion("q3", q3);

    q1.answer("Strongly Agree");
    q2.answer("Blue");
    q3.answer("Yes");
    assertTrue(questionnaire.isComplete());
  }

  /**
   * Test get responses.
   */
  @Test
  public void testGetResponses() {
    Question q1 = new Likert("How much do you like this class?", true);
    Question q2 = new ShortAnswer("What is your favorite color?", true);
    Question q3 = new YesNo("Do you like this class?", false);

    questionnaire.addQuestion("q1", q1);
    questionnaire.addQuestion("q2", q2);
    questionnaire.addQuestion("q3", q3);

    q1.answer("Strongly Agree");
    q2.answer("Blue");
    q3.answer("Yes");
    assertEquals("Strongly Agree", questionnaire.getResponses().get(0));
    assertEquals("Blue", questionnaire.getResponses().get(1));
    assertEquals("Yes", questionnaire.getResponses().get(2));
  }

  /**
   * Test sort.
   */
  @Test
  public void testSort() {
    Question q1 = new Likert("How much do you like this class?", true);
    Question q2 = new ShortAnswer("What is your favorite color?", true);
    Question q3 = new YesNo("Do you like this class?", false);

    questionnaire.addQuestion("q1", q1);
    questionnaire.addQuestion("q2", q2);
    questionnaire.addQuestion("q3", q3);

    Comparator<Question> comp = (a, b) -> a.getPrompt().compareTo(b.getPrompt());
    questionnaire.sort(comp);

    // sorting questions based on prompt first letter in ascending order (ASCII value)
    assertEquals(q1, questionnaire.getQuestion(2)); // "D"
    assertEquals(q2, questionnaire.getQuestion(3)); // "H"
    assertEquals(q3, questionnaire.getQuestion(1)); // "W"

    // test with null comparator
    assertThrows(IllegalArgumentException.class, () -> questionnaire.sort(null));
  }

  /**
   * Test fold.
   */
  @Test
  public void testFold() {
    Question q1 = new Likert("How do you like it?", true);
    Question q2 = new ShortAnswer("Your favorite color?", true);
    Question q3 = new YesNo("Do you like it?", false);

    questionnaire.addQuestion("q1", q1);
    questionnaire.addQuestion("q2", q2);
    questionnaire.addQuestion("q3", q3);

    BiFunction<Question, String, String> bf = (a, b) -> b
            + a.getPrompt()
            + "\n"
            + a.getAnswer() + "\n";

    // did not add any answers
    assertEquals("""
                    How do you like it?
                                        
                    Your favorite color?
                                    
                    Do you like it?
                                        
                    """,
            questionnaire.fold(bf, ""));
  }

  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    Question q1 = new Likert("How do you like it?", true);
    Question q2 = new ShortAnswer("Your favorite color?", true);
    Question q3 = new YesNo("Do you like it?", false);

    questionnaire.addQuestion("q1", q1);
    questionnaire.addQuestion("q2", q2);
    questionnaire.addQuestion("q3", q3);

    q1.answer("Strongly Agree");
    q2.answer("Blue");
    q3.answer("Yes");

    assertEquals("""
                    Question: How do you like it?

                    Answer: Strongly Agree

                    Question: Your favorite color?

                    Answer: Blue

                    Question: Do you like it?

                    Answer: Yes""",
            questionnaire.toString());
  }
}