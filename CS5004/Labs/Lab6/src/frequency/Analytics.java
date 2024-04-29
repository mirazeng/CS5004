package frequency;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Analytics.
 */
public class Analytics {

  private static int insertions;

  /**
   * Word frequency map.
   *
   * @param message the message
   * @return the map
   */
  public static Map<String, Double> wordFrequency(String message) {

    if (message == null || message.isEmpty()) {
      return null;
    }

    message = message.replaceAll("\\p{Punct}", "");
    String[] words = message.toUpperCase().split("\\p{Blank}");

    Map<String, Double> frequencyMap = new HashMap<>();
    insertions = 0;

    for (String word : words) {
      if (frequencyMap.containsKey(word)) {
        Double value = frequencyMap.get(word);
        value++;
        frequencyMap.put(word, value);
        insertions++;
      } else {
        frequencyMap.put(word, 1.0);
        insertions++;
      }
    }
    frequencyMap.forEach((k, v) -> frequencyMap.put(k, v / insertions));
    return frequencyMap;
  }
}
//  /**
//   * The entry point of application.
//   *
//   * @param args the input arguments
//   */
//  public static void main(String[] args) {
//    String message = "Really? Like, really? I do need another cookie to cook?";
//    Map<String, Double> wordMap = wordFrequency(message);
//    wordMap.forEach((k, v) -> wordMap.put(k, v / insertions));
//    System.out.println(wordMap);
//    System.out.println(wordFrequency(" "));
//  }
//}