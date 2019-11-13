import java.util.Arrays;
import java.util.Scanner;

public class main {
    public  static void countDigitFrequencies(int number,int[] frequencies)
    {
        int copyNumber = number;
        while(copyNumber>0)
        {
            frequencies[copyNumber%10]++;
            copyNumber = copyNumber/10;
        }
    }

    public static void  printDigitFrequencies(int[] frequencies)
    {
        int []recordIndex = new int[frequencies.length];
        for(int element = 0;element<frequencies.length;element++)
        {
            if(frequencies[element]!=0)
            {
                recordIndex[element] = element;
            }
        }
        //Arrays.sort(recordIndex);
        System.out.print("Digit frequencies: ");
        for(int element = 0;element<frequencies.length;element++)
        {
            if(frequencies[element]!=0)
            {
                int printInteger = recordIndex[element];
                int frequencyInteger = frequencies[element];
                System.out.print(printInteger+"("+frequencyInteger+")");
            }
        }
        System.out.println();
    }
    public static void main(String []args)
    {
        boolean notFinished  = false;
        final int TOTAL_NUMBER_OF_DIGITS = 11;//0-9 ,\0
        int [] frequencies = new int[TOTAL_NUMBER_OF_DIGITS];

        for(int element = 0;element<frequencies.length;element++)
        {
            frequencies[element] =0;
        }
        while (!notFinished)
        {
            System.out.print("Enter a number> ");
            Scanner inputScannner = new Scanner(System.in);
            String userInput = inputScannner.nextLine();
            if(userInput.equals(""))
            {
                notFinished = false;
                break;
            }
            int inputNumber = Integer.parseInt(userInput);
           // System.out.println(inputNumber);
            countDigitFrequencies(inputNumber,frequencies);
            printDigitFrequencies(frequencies);
        }
        System.out.println("PROGREAM END");
    }

}
