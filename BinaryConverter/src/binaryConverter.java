import java.util.Scanner;

public class binaryConverter {
    public static String convertToBinaryString(int number)
    {
        int reminder = 0;
        String binaryNumber ="";
        while(number>0)
        {
            reminder = number%2;
            number=number/2;
            binaryNumber = reminder+binaryNumber;
        }
        return binaryNumber;
    }
    public static String reverBinary(int number)
    {
        int reminder = 0;
        String reverseBinary ="";
        while(number>0)
        {
            reminder = number%2;
            number=number/2;
            reverseBinary = reverseBinary+reminder;
        }
        return reverseBinary;
    }
    public static boolean isBinaryPalidromic(int number)
    {
        boolean isBinaryPalidromic = false;
        String newBinary = convertToBinaryString(number);
        String reverBinary = reverBinary(number);
        if(newBinary.equals(reverBinary))
        {
            isBinaryPalidromic= true;
        }
        return isBinaryPalidromic;
    }
    public static void main(String []args)
    {
        boolean finished = false;
        int newNumber = 0;
        while(!finished)
        {
            System.out.print("Enter a number (or quit)>");
            Scanner inputScanner = new Scanner(System.in);

            if(inputScanner.hasNextInt())
            {
                newNumber = inputScanner.nextInt();
                if(newNumber>=0)
                {
                    String binaryNumber = convertToBinaryString(newNumber);
                    System.out.print("The number"+newNumber+"in binary is "+binaryNumber);
                    if(isBinaryPalidromic(newNumber))
                    {
                        System.out.println(" which is palindromic.");
                    }
                    else
                    {
                        System.out.println(" which is not palindromic.");
                    }
                }
                else
                {
                    System.out.println("Invailed input try again");
                }

            }
            else if(inputScanner.hasNext("quit"))
            {
                finished =true;
            }
            else
            {
                System.out.println("Invailed input ");
            }
        }
    }
}
