package nl.qsd.language;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ivo Limmen <ivo.limmen@qsd.nl>
 */
public class WordTest {
   
   public WordTest() {
   }

   @Test
   public void testAbriviate() {	  
	  Word word = new Word("B");	  
	  Assert.assertTrue(word.isAbrivate());
   }

   @Test
   public void testAbriviate2() {	  
	  Word word = new Word("FYI");	  
	  Assert.assertTrue(word.isAbrivate());
   }

   @Test
   public void testAbriviate3() {	  
	  Word word = new Word("Normal");	  
	  Assert.assertFalse(word.isAbrivate());
   }

}
