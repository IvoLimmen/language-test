package nl.qsd.language;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author Ivo Limmen <ivo.limmen@qsd.nl>
 */
public class Main {

   public static void main(String... args) throws IOException {
	  new Main().read();
   }

   private int countAscend = 0;
   private int countDescend = 0;
   private int countPalindrome = 0;

   private long wordCount = 0;
   private long totalLength = 0;
   private long longestWord = 0;

   private String longestAscending = "";
   private String longestDescending = "";
   private String longestPalindrome = "";

   private final Map<Integer, Long> counts = new HashMap<>();

   public void read() throws IOException {

	  List<Word> words;

	  try (BufferedReader reader = new BufferedReader(
			  new InputStreamReader(
					  this.getClass().getResourceAsStream("/opentaal.txt")))) {

				 words = reader.lines()
						 .map(item -> new Word(item, true))
						 .collect(Collectors.toList());
			  }

			  words.stream().filter(word -> word.length() > 2)
					  .filter(word -> word.isAscendingOrder())
					  .filter(word -> !word.isAbrivate())
					  .forEach(item -> {
						 countAscend++;
						 if (item.length() > longestAscending.length()) {
							longestAscending = item.toString();
						 }
					  });

			  words.stream().filter(word -> word.length() > 2)
					  .filter(word -> word.isDescendingOrder())
					  .filter(word -> !word.isAbrivate())
					  .forEach(item -> {
						 countDescend++;
						 if (item.length() > longestDescending.length()) {
							longestDescending = item.toString();
						 }
					  });

			  words.stream().filter(word -> word.length() > 2)
					  .filter(word -> word.isPalindrome())
					  .filter(word -> !word.isAbrivate())
					  .forEach(item -> {
						 countPalindrome++;
						 if (item.length() > longestPalindrome.length()) {
							longestPalindrome = item.toString();
						 }
					  });

			  System.out.println("Words that ascend: " + this.countAscend);
			  System.out.println("Words that descend: " + this.countDescend);
			  System.out.println("Words that are palindromes: " + this.countPalindrome);
			  System.out.println("Longest ascending word: " + this.longestAscending);
			  System.out.println("Longest descening word: " + this.longestDescending);
			  System.out.println("Longest palindrome word: " + this.longestPalindrome);
			  
			  words.stream()
					  .filter(word -> !word.isAbrivate())
					  .forEach(item -> {
						 wordCount++;
						 totalLength += item.length();
						 if (item.length() > longestWord) {
							longestWord = item.length();
						 }

						 Long current = 1l;
						 if (counts.containsKey(item.length())) {
							current += counts.get(item.length());
						 }

						 counts.put(item.length(), current);
					  });

			  System.out.println("Total words in collection: " + wordCount);
			  System.out.println("Average word length: " + (totalLength / wordCount));
			  System.out.println("Longest word length: " + longestWord);

			  Map<Integer, Long> sortedMap = new TreeMap<>((key1, key2) -> {
				 Long value1 = counts.containsKey(key1) ? counts.get(key1) : 0l;
				 Long value2 = counts.containsKey(key2) ? counts.get(key2) : 0l;
				 				 
				 return value2.compareTo(value1);
			  });			  
			  sortedMap.putAll(counts);
			  
			  sortedMap.entrySet().stream().forEach((entry) -> {
				 System.out.println(String.format("Words with length %d are counted %d times.", entry.getKey(), entry.getValue()));
			  });
			  			  
   }
}
