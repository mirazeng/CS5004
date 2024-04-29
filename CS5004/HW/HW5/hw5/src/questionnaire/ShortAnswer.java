package questionnaire;

/**
 * The type Short answer.
 */
public class ShortAnswer implements Question {
  private final String prompt;
  private final boolean required;
  private String answer;


  /**
   * Instantiates a new Short answer.
   *
   * @param prompt   the prompt
   * @param required the required
   */
  public ShortAnswer(String prompt, boolean required) {
    this.prompt = prompt;
    this.required = required;
    this.answer = "";
  }

  @Override
  public String getPrompt() {
    return this.prompt;
  }

  @Override
  public Boolean isRequired() {
    return this.required;
  }

  @Override
  public void answer(String answer) throws IllegalArgumentException {
    if (answer == null) {
      throw new IllegalArgumentException("There is no answer");
    } else if (answer.length() > 280) {
      throw new IllegalArgumentException("Answer is too long");
    } else {
      this.answer = answer;
    }
  }

  @Override
  public String getAnswer() {
    return this.answer;
  }

  @Override
  public Question copy() {
    ShortAnswer copyShortAnswer = new ShortAnswer(this.prompt, this.required);
    copyShortAnswer.answer(getAnswer());
    return copyShortAnswer;
  }
}