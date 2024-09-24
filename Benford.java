import java.util.*;
import java.io.*;

/**
 * @author Terence Wu
 * @version 9/23/2024
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
        
  
    
    public static double[] firstDigitFrequencies(String filename, int indexOfFirstDigit){

        File file = new File(filename);        
        int lines = 0;
        int[] tally = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; 
        double[] frequencies = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}; 

        try 
        {
 
            Scanner scanner = new Scanner(file);
           
            while (scanner.hasNextLine())
            {
                lines++;
                String line = scanner.nextLine();

                char digit = line.charAt(indexOfFirstDigit);
                int digint = digit-'0';
                tally[digint]++;
            }

            scanner.close();
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }

        for(int i=0;i<9;i++)
            frequencies[i] = (Math.round(1000*(double)(tally[i+1])/lines))/10.0;

        return frequencies;
    }
    
}
