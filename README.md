# language-test

Lambda test. Searching words with consecutive letters from the alphabet.

The tool has been modified to include both ascending order (i.e. adel) and descending order (i.e. spookje). The logic
has an option to check loose/strict but there is currently no command line option to change it. Strict means that 
letters may nog occur more than once, in loose mode the letters may repeat. Currently the tool only count strict.

I suddenly had this question prying in my mind: are there any word in the Dutch dictionary (I'm Dutch by the way)
that exist only using consecutive letters from the alphabet? After a long though I could think of one: 'Adel'. The Dutch
word for Royal.
Since I wanted to play with JDK 8 and lambda functions I decided to test my theory.

Later on I added some more statistics to the output on the dictionary. Also added a part to show words that can be shown
on a calculator when it is upside down (Calculator spelling).

Clone and simply execute:

    mvn exec:java

To see the result.

# Puzzle

Because I needed to do this. My wife was given a few T-Shirts with letters on them and she wanted to use it in a quiz. 
So the question is what word can you make of the T-Shirts. She was given 4 blue and 4 red with different letters on them.
If you run the Puzzle it will output the list of words that can be found in the Dutch wordlist for each team.

# Credits

Made with help from the dictionary from [OpenTaal](http://www.opentaal.org).