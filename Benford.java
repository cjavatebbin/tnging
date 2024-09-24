import java.util.*;
import java.io.*;

/**
 * Benford's law, or the first-digit law, is an observation about the frequency
 * distribution of leading digits in many real-life sets of numerical data. The law states
 * that in many naturally occurring collections of numbers, the leading digit is likely to
 * be small. For example, in sets that obey the law, the number 1 appears as the leading
 * significant digit about 30% of the time, while 9 appears as the leading significant
 * digit less than 5% of the time. If the digits were distributed uniformly, they would
 * each occur about 11.1% of the time. Benford's law also makes predictions about the
 * distribution of second digits, third digits, digit combinations, and so on.
 * 
 * Write a program that tests Benford’s Law. You will use data from two different real-life 
 * data sources. The data is stored in two separate text files: sunspots.txt and librarybooks.txt
 * Feel free to try this program out on other large sets of data! 
 *
 * You will also be tested on a third mystery file of stock data and a file of randomly 
 * generated integers.
 * 
 * 
 * You will loop through the list of numbers and count how many times 1 is the first
 * digit, 2 is the first, etc...
 * 
 * Your output/results should look like this:
 * 
 * Analysis of library book data:
 * [33.4, 17.6, 11.1, 8.8, 7.0, 6.1, 5.5, 5.5, 4.9]
 * Analysis of sunspot data:
 * [29.1, 12.4, 10.3, 10.6, 10.2, 8.6, 6.5, 6.6, 5.8]
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Benford
{
    public static void main(String[] args){
       
        // Main method used for testing code. Feel free to edit or add to the main method for further testing.
        System.out.println("According to Benford's Law, one might expect the following frequency of first digits");
        System.out.println("************************************************************************************");
        final double[]  freq = {0.0, 30.1, 17.6, 12.5, 9.7, 7.9, 6.7, 5.8, 5.1, 4.6};
        
        for (int i = 1; i <=9; i++)
            System.out.println("Percentage of numbers starting with " + i + ": " + freq[i] + "%");
        System.out.println();
        System.out.println("Analysis of sunspot data:");
        System.out.println(Arrays.toString(firstDigitFrequencies("sunspots.txt",21)));
        System.out.println();
        System.out.println("Analysis of library book data:");
        System.out.println(Arrays.toString(firstDigitFrequencies("librarybooks.txt",0)));
        
    }
        
    /**
     * Returns the frequencies of first digits in a text file, as a percentage, rounded to the nearest tenth.
     * (12.349 should round to 12.3 and 12.350 should round to 12.4.) 
     * For example: firstDigitFrequencies("sunspots.txt",21) -> [29.1, 12.4, 10.3, 10.6, 10.2, 8.6, 6.5, 6.6, 5.8]
     * In other words, 29.1% of the data begins with a 1, 12.4% of the data begins with a 2, and so on. 
     * In this example, the actual data that we are concerned with (the number of sun spots in this example) is located
     * at index 21 (the 22nd character) on each line of the text file. For example, the first line of the sunspots textfile
     * looks like this:
     * (* Month: 1749 01 *) 58
     * In the above example, there were 58 sunspots in January, 1749. We only need to look at the number 58, and more 
     * specifically, the first digit of this number, which is 5.
     * 
     * @param filename the name of the text file to open for input
     * @param indexOfFirstDigit the starting index of the data(number) in each line of the file
     * @return an array of doubles, representing the frequencies of first digits in a text file, as a percentage, rounded to the nearest tenth.
     */
    
    public static double[] firstDigitFrequencies(String filename, int indexOfFirstDigit){
        // Location of file to read
        File file = new File(filename);        
        
        // keeps count of the number of leading digits
        // for example, tally[1] stores the number of digits beginning with 1,
        // tally[2] stores the number of digits beginning with 2, etc...
        // Note: tally[0] is not used for anything, as we are ignoring numbers that start with a 0.
        // You may use the array, tally, below, or decide to approach this problem
        // another way.
        int[] tally = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; 
        double[] frequencies = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}; // used to store frequencies 
        // e.g.  frequencies[0] counts the number of 1's, 
        // frequencies[1] counts the number of 2's, etc...
        
        
        try // try to read the file named file, if it exists
        {
 
            Scanner scanner = new Scanner(file);
           
            while (scanner.hasNextLine())
            {
                // Read in the next line from the text file.
                // For example, the first line of the sunspots textfile looks like this:
                // (* Month: 1749 01 *) 58
                // where 58 is the number of sunspots. 
                String line = scanner.nextLine();
               
                // TODO: your code here
                // Your code here should keep a tally of the leading digits.
                // Ignore all zero entries, as though they don't exist. (IMPORTANT)
                // Thus, zero entries also do not count in the total number of entries. (ALSO IMPORTANT)
                // Remember that the first digit of the number in question occurs at index: indexOfFirstDigit
                // You'll have to think about how to convert a char or String to an int. There are many ways of
                // doing so. Feel free to use StackOverflow to research this if you get stuck.
                
                
            }

            scanner.close();
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
        // TODO: your code here
        // return an array of doubles, representing the frequencies of first digits in a text file, as a percentage, 
        // rounded to the nearest tenth. For example,  29.14% becomes 29.1 and 29.15% becomes 29.2 after rounding.
        // NOTE: If you do not round correctly, you will likely fail some of the test cases.
   
        

        return frequencies;
    }
        
    
}
