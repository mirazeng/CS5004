package questionnaire;

/**
 * The type Likert.
 */
public class Likert implements Question {

  private final String prompt;
  private final boolean required;
  private String answer;

  /**
   * Instantiates a new Likert.
   *
   * @param prompt   the prompt
   * @param required the required
   */
  public Likert(String prompt, boolean required) {
    this.prompt = prompt;
    this.required = required;
    this.answer = "";
  }

  @Override
  public String getPrompt() {
    return prompt;
  }

  @Override
  public Boolean isRequired() {
    return this.required;
  }

  @Override
  public void answer(String answer) {
    if (answer == null) {
      throw new IllegalArgumentException("There is no answer");
    }
    boolean answerFound = false;
    for (LikertResponseOption option : LikertResponseOption.values()) {
      if (answer.equalsIgnoreCase(option.getText())) {
        this.answer = answer;
        answerFound = true;
        break;
      }
    }
    if (!answerFound) {
      throw new IllegalArgumentException("Invalid Answer");
    }
  }

  @Override
  public String getAnswer() {
    return answer;
  }

  @Override
  public Question copy() {
    Likert copyLikert = new Likert(this.prompt, this.required);
    if (!this.answer.isEmpty()) {
      copyLikert.answer(this.answer);
    }
    return copyLikert;
  }
}