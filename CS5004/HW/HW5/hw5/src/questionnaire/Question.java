package questionnaire;

/**
 * The interface Question general.
 */
public interface Question {

  /**
   * Gets prompt.
   *
   * @return the prompt
   */
  String getPrompt();

  /**
   * Is required boolean.
   *
   * @return the boolean
   */
  Boolean isRequired();

  /**
   * Answer.
   *
   * @param answer the answer
   */
  void answer(String answer);

  /**
   * Gets answer.
   *
   * @return the answer
   */
  String getAnswer();

  /**
   * Copy question general.
   *
   * @return the question general
   */
  Question copy();
  
}
