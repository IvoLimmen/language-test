package nl.qsd.language;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Ivo Limmen <ivo.limmen@qsd.nl>
 */
public class Main {

    public static void main(String... args) throws IOException {
        new Main().read();
    }

    private int countAscend = 0;
    private int countDescend = 0;

    private String longestAscending = "";
    private String longestDescending = "";

    public void read() throws IOException {        

        List<Word> words = null;
        
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        this.getClass().getResourceAsStream("/opentaal.txt")))) {

            words = reader.lines()
                    .map(item -> new Word(item))
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
                    System.out.println(item);
                });

        words.stream().filter(word -> word.length() > 2)
                .filter(word -> word.isDescendingOrder())
                .filter(word -> !word.isAbrivate())
                .forEach(item -> {
                    countDescend++;
                    if (item.length() > longestDescending.length()) {
                        longestDescending = item.toString();
                    }
                    System.out.println(item);
                });
        
        System.out.println("Words that ascend: " + this.countAscend);
        System.out.println("Words that descend: " + this.countDescend);
        System.out.println("Longest ascending word: " + this.longestAscending);
        System.out.println("Longest descening word: " + this.longestDescending);               
    }
}
