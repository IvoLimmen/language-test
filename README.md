language-test
=============

Java 8 lambda test. Searching words with consecutive letters from the alphabet.

The tool has been modified to include both ascending order (i.e. adel) and descending order (i.e. spookje). The logic
has an option to check loose/strict but there is currently no command line option to change it. Strict means that 
letters may nog occur more than once, in loose mode the letters may repeat. Currently the tool only count strict.

I suddenly had this question prying in my mind: are there any word in the Dutch dictionary (I'm Dutch by the way)
that exist only using consecutive letters from the alphabet? After a long though I could think of one: 'Adel'. The Dutch
word for Royal.
Since I wanted to play with JDK 8 and lambda functions I decided to test my theory.

Clone and simply execute:

    mvn exec:java

To see the result.

Made with help from the dictionary from [OpenTaal](http://www.opentaal.org), ('basis-gekeurd' and 'flexievormen').