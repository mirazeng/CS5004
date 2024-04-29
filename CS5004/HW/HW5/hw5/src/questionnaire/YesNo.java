package questionnaire;

/**
 * The type Yes no.
 */
public class YesNo implements Question {
  private String prompt;
  private final boolean required;
  private String answer;

  /**
   * Instantiates a new Yes no.
   *
   * @param prompt   the prompt
   * @param required the required
   */
  public YesNo(String prompt, boolean required) {
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
  public String getAnswer() {
    return this.answer;
  }

  @Override
  public Question copy() {
    YesNo copyYesNo = new YesNo(this.prompt, this.required);
    copyYesNo.answer(getAnswer());
    return copyYesNo;
  }

  @Override
  public void answer(String answer) throws IllegalArgumentException {
    if (answer == null) {
      throw new IllegalArgumentException("There is no answer");
    } else if (answer.equalsIgnoreCase("yes")
            || answer.equalsIgnoreCase("no")) {
      this.answer = answer;
    } else {
      throw new IllegalArgumentException("Invalid Answer");
    }
  }
}