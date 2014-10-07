package nl.qsd.language;

import java.util.ArrayList;
import java.util.List;

public class Word implements Comparable<Word> {

   private final String word;

   private final String originalWord;

   private final char[] letters;

   private final boolean strict;

   private final List<Character> upsideDown = new ArrayList<>();

   // initializer
   {
	  // S is the 5
	  upsideDown.add('s');
	  // I is the 1
	  upsideDown.add('i');
	  // L is the 7
	  upsideDown.add('l');
	  // B is the 9
	  upsideDown.add('b');
	  // H is the 4
	  upsideDown.add('h');
	  // O is the 0
	  upsideDown.add('o');
   }

   public Word(String word) {
	  this(word, false);
   }

   public Word(String word, boolean strict) {
	  if (word == null) {
		 word = "";
	  }

	  this.originalWord = word;
	  this.word = word.toLowerCase();
	  this.strict = strict;
	  this.letters = this.word.toCharArray();
   }

   public int length() {
	  return this.word.length();
   }

   public boolean isCalculatorSpelling() {
	  
	  for (char c : letters) {
		 if (!upsideDown.contains(c)) {
			return false;
		 }
	  }	 
	  
	  return true;
   }
   
   public boolean isAbrivate() {

	  for (Character letter : originalWord.toCharArray()) {
		 if (!Character.isUpperCase(letter)) {
			return false;
		 }
	  }

	  return true;
   }

   public boolean isAscendingOrder() {

	  char previous = letters[0];

	  for (int i = 1; i < letters.length; i++) {
		 char current = letters[i];
		 if (previous > current) {
			return false;
		 }
		 if (strict && previous == current) {
			return false;
		 }

		 previous = current;
	  }

	  return true;
   }

   public boolean isDescendingOrder() {

	  char previous = letters[0];

	  for (int i = 1; i < letters.length; i++) {
		 char current = letters[i];
		 if (previous < current) {
			return false;
		 }
		 if (strict && previous == current) {
			return false;
		 }

		 previous = current;
	  }

	  return true;
   }

   public boolean isPalindrome() {
	  StringBuilder sb = new StringBuilder(this.word.length());
	  sb.append(this.word);
	  sb.reverse();

	  return this.word.equals(sb.toString());
   }

   @Override
   public String toString() {
	  return this.word;
   }

   @Override
   public int compareTo(Word o) {
	  return this.word.compareTo(o.word);
   }
}
