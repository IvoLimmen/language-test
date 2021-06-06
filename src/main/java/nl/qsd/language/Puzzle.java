package nl.qsd.language;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Puzzle {

    public static void main(String... args) throws IOException {
        new Puzzle().read();
    }

    private class Shirt {
        private char front;
        private char back;

        public Shirt(char front, char back) {
            this.front = front;
            this.back = back;
        }
    }

    private class Team {
        private List<Shirt> shirts = new ArrayList<>();
        private List<String> possibleWord = new ArrayList<>();

        public Team(List<Shirt> shirts) {
            this.shirts = shirts;
        }

        List<String> getAllLetterCombos() {
            return List.of("" + shirts.get(0).front + shirts.get(1).front + shirts.get(2).front + shirts.get(3).front,
                    "" + shirts.get(0).front + shirts.get(1).front + shirts.get(2).front + shirts.get(3).back,
                    "" + shirts.get(0).front + shirts.get(1).front + shirts.get(2).back + shirts.get(3).front,
                    "" + shirts.get(0).front + shirts.get(1).front + shirts.get(2).back + shirts.get(3).back,
                    "" + shirts.get(0).front + shirts.get(1).back + shirts.get(2).front + shirts.get(3).front,
                    "" + shirts.get(0).front + shirts.get(1).back + shirts.get(2).front + shirts.get(3).back,
                    "" + shirts.get(0).front + shirts.get(1).back + shirts.get(2).back + shirts.get(3).front,
                    "" + shirts.get(0).front + shirts.get(1).back + shirts.get(2).back + shirts.get(3).back,
                    "" + shirts.get(0).back + shirts.get(1).front + shirts.get(2).front + shirts.get(3).front,
                    "" + shirts.get(0).back + shirts.get(1).front + shirts.get(2).front + shirts.get(3).back,
                    "" + shirts.get(0).back + shirts.get(1).front + shirts.get(2).back + shirts.get(3).front,
                    "" + shirts.get(0).back + shirts.get(1).front + shirts.get(2).back + shirts.get(3).back,
                    "" + shirts.get(0).back + shirts.get(1).back + shirts.get(2).front + shirts.get(3).front,
                    "" + shirts.get(0).back + shirts.get(1).back + shirts.get(2).front + shirts.get(3).back,
                    "" + shirts.get(0).back + shirts.get(1).back + shirts.get(2).back + shirts.get(3).front,
                    "" + shirts.get(0).back + shirts.get(1).back + shirts.get(2).back + shirts.get(3).back);
        }

        public void add(String word) {

            // we check all combinations of the shirts
            getAllLetterCombos().forEach(combo -> {
                boolean correct = true;
                // each letter should be in the combo
                for (int i = 0; i < combo.length(); i++) {
                    if (word.indexOf(combo.charAt(i)) == -1) {
                        correct = false;
                        break;
                    }
                }
                // the same amount of letters should be in the shirts combo as in the word
                for (int i = 0; i < combo.length(); i++) {
                    char test = combo.charAt(i);
                    if (countCharsInWord(word, test) != countCharsInWord(combo, test)) {
                        correct = false;
                        break;
                    }
                }
                if (correct && !possibleWord.contains(word)) {
                    possibleWord.add(word);
                }
            });
        }

        int countCharsInWord(String word, char character) {
            int count = 0;
            for(int i = 0; i < word.length(); i++) {    
                if(word.charAt(i) == character)    
                    count++;    
            }   
            return count;
        }
    }

    public void read() throws IOException {
        Team red = new Team(
                List.of(new Shirt('s', 'o'), new Shirt('t', 'r'), new Shirt('a', 'e'), new Shirt('g', 'v')));
        Team blue = new Team(
                List.of(new Shirt('t', 'i'), new Shirt('e', 'u'), new Shirt('u', 'm'), new Shirt('r', 's')));

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(this.getClass().getResourceAsStream("/opentaal.txt")))) {

            reader.lines().filter(p -> p.length() == 4).map(String::toLowerCase).forEach(word -> {
                red.add(word);
                blue.add(word);
            });
        }

        System.out.println("Red team - " + red.possibleWord.size() + " Woorden");
        System.out.println(red.possibleWord.stream().collect(Collectors.joining(", ")));
        System.out.println("Blue team - " + blue.possibleWord.size() + " Woorden");
        System.out.println(blue.possibleWord.stream().collect(Collectors.joining(", ")));
    }
}