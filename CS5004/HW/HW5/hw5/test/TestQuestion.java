import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import questionnaire.Likert;
import questionnaire.Question;
import questionnaire.ShortAnswer;
import questionnaire.YesNo;

/**
 * The type Test question.
 */
public class TestQuestion {
  private Question likertQuestion;
  private Question shortAnswerQuestion;
  private Question yesNoQuestion;

  /**
   * Sets up.
   */
  @BeforeEach
  public void setUp() {
    likertQuestion = new Likert("How much do you like this class?", true);
    shortAnswerQuestion = new ShortAnswer("What is your favorite color?", false);
    yesNoQuestion = new YesNo("Do you like this class?", true);
  }

  /**
   * Test good constructor.
   */
  @Test
  public void testGoodConstructor() {
    assertEquals("How much do you like this class?", likertQuestion.getPrompt());
    assertTrue(likertQuestion.isRequired());
    assertEquals("", likertQuestion.getAnswer());

    assertEquals("What is your favorite color?", shortAnswerQuestion.getPrompt());
    assertFalse(shortAnswerQuestion.isRequired());
    assertEquals("", shortAnswerQuestion.getAnswer());

    assertEquals("Do you like this class?", yesNoQuestion.getPrompt());
    assertTrue(yesNoQuestion.isRequired());
    assertEquals("", yesNoQuestion.getAnswer());
  }

  /**
   * Test copy constructor.
   */
  @Test
  public void testCopyConstructor() {
    likertQuestion.answer("Strongly Agree");
    Question likertCopy = likertQuestion.copy();
    assertEquals(likertQuestion.getPrompt(), likertCopy.getPrompt());
    assertEquals(likertQuestion.isRequired(), likertCopy.isRequired());
    assertEquals(likertQuestion.getAnswer(), likertCopy.getAnswer());

    shortAnswerQuestion.answer("Blue");
    Question shortAnswerCopy = shortAnswerQuestion.copy();
    assertEquals(shortAnswerQuestion.getPrompt(), shortAnswerCopy.getPrompt());
    assertEquals(shortAnswerQuestion.isRequired(), shortAnswerCopy.isRequired());
    assertEquals(shortAnswerQuestion.getAnswer(), shortAnswerCopy.getAnswer());

    yesNoQuestion.answer("Yes");
    Question yesNoCopy1 = yesNoQuestion.copy();
    assertEquals(yesNoQuestion.getPrompt(), yesNoCopy1.getPrompt());
    assertEquals(yesNoQuestion.isRequired(), yesNoCopy1.isRequired());
    assertEquals(yesNoQuestion.getAnswer(), yesNoCopy1.getAnswer());
    yesNoQuestion.answer("No");
    Question yesNoCopy2 = yesNoQuestion.copy();
    assertEquals(yesNoQuestion.getPrompt(), yesNoCopy2.getPrompt());
    assertEquals(yesNoQuestion.isRequired(), yesNoCopy2.isRequired());
    assertEquals(yesNoQuestion.getAnswer(), yesNoCopy2.getAnswer());

    yesNoQuestion.answer("yes");
    Question yesNoCopy3 = yesNoQuestion.copy();
    assertEquals(yesNoQuestion.getPrompt(), yesNoCopy3.getPrompt());
    assertEquals(yesNoQuestion.isRequired(), yesNoCopy3.isRequired());
    assertEquals(yesNoQuestion.getAnswer(), yesNoCopy3.getAnswer());
    yesNoQuestion.answer("no");
    Question yesNoCopy4 = yesNoQuestion.copy();
    assertEquals(yesNoQuestion.getPrompt(), yesNoCopy4.getPrompt());
    assertEquals(yesNoQuestion.isRequired(), yesNoCopy4.isRequired());
    assertEquals(yesNoQuestion.getAnswer(), yesNoCopy4.getAnswer());
  }

  /**
   * Test get prompt.
   */
  @Test
  public void testGetPrompt() {
    assertEquals("How much do you like this class?", likertQuestion.getPrompt());
    assertEquals("What is your favorite color?", shortAnswerQuestion.getPrompt());
    assertEquals("Do you like this class?", yesNoQuestion.getPrompt());
  }

  /**
   * Test is required.
   */
  @Test
  public void testIsRequired() {
    assertTrue(likertQuestion.isRequired());
    assertFalse(shortAnswerQuestion.isRequired());
    assertTrue(yesNoQuestion.isRequired());
  }

  /**
   * Test valid answer.
   */
  @Test
  public void testValidAnswer() {
    likertQuestion.answer("Strongly Agree");
    assertEquals("Strongly Agree", likertQuestion.getAnswer());

    shortAnswerQuestion.answer("Blue");
    assertEquals("Blue", shortAnswerQuestion.getAnswer());

    yesNoQuestion.answer("Yes");
    assertEquals("Yes", yesNoQuestion.getAnswer());
  }

  /**
   * Test invalid answer.
   */
  @Test
  public void testInvalidAnswer() {
    assertThrows(IllegalArgumentException.class, () -> likertQuestion.answer(null));
    assertThrows(IllegalArgumentException.class, () -> likertQuestion.answer("What is this?"));

    assertThrows(IllegalArgumentException.class, () -> shortAnswerQuestion.answer(null));
    assertThrows(IllegalArgumentException.class, () -> shortAnswerQuestion.answer(
            "Java is a highly popular, class-based, "
            + "object-oriented programming language designed to "
            + "have as few implementation dependencies as possible. "
            + "It allows developers to write once, run anywhere (WORA), "
            + "meaning that compiled Java code can run on all platforms "
            + "that support Java without the need for recompilation. "));

    assertThrows(IllegalArgumentException.class, () -> yesNoQuestion.answer(null));
    assertThrows(IllegalArgumentException.class, () -> yesNoQuestion.answer("Maybe"));
  }

  /**
   * Test get answer.
   */
  @Test
  public void testGetAnswer() {
    likertQuestion.answer("Strongly Agree");
    assertEquals("Strongly Agree", likertQuestion.getAnswer());

    shortAnswerQuestion.answer("Blue");
    assertEquals("Blue", shortAnswerQuestion.getAnswer());

    yesNoQuestion.answer("Yes");
    assertEquals("Yes", yesNoQuestion.getAnswer());
  }
}