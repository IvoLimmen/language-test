package nl.qsd.language;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * @author Ivo Limmen <ivo.limmen@qsd.nl>
 */
public class Main {

    public static void main(String... args) throws IOException {
        new Main().read();
    }

    private int count = 0;
    private String longest = "";
    
    public void read() throws IOException {
                
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        this.getClass().getResourceAsStream("/opentaal.txt")))) {
            
            Stream<Word> stream = reader.lines().map(item -> new Word(item));
            
            stream.filter(word -> word.length() > 2)
                    .filter(word -> word.isInOrder())
                    .filter(word -> !word.isAbrivate())
                    .forEach(item -> {
                        count++;
                        if (item.length() > longest.length()) {
                            longest = item.toString();
                        }
                        System.out.println(item);
                    });
            
            System.out.println("Count: " + this.count);
            System.out.println("Longest word: " + this.longest);
        }        
    }    
}
