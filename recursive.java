import java.util.Scanner;

public class recursive {
    public static boolean isDudneyNumber(int number)
    {
        int currentNumber = number;
        int sum = 0;
        int count = 0;
        while(currentNumber!=0)
        {
            count++;
            sum+=currentNumber%10;
            currentNumber/=10;
        }
        int DudenyNumber = (int) Math.pow(sum,count);
        return (DudenyNumber==number);
    }
    public static boolean isAscendingPowerNumber(int number)
    {
        int currentNumber = number;
        int ascendingNumber  = number;
        int sum = 0;
        int timesOfPower =0;
        while(currentNumber!=0)
        {
            timesOfPower++;
            sum+=currentNumber%10;
            currentNumber/=10;
        }
        while(ascendingNumber!=0)
        {
            sum+=Math.pow(ascendingNumber%10,timesOfPower--);
            ascendingNumber/=10;
        }
        return (sum==number);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner( System.in );
        String inputString="";
        do {
            System.out.print("Enter number (or 'quit')>");
            input = new Scanner( System.in );
            if (input.hasNextInt())
            {
                int number = input.nextInt();
                System.out.println("The number " + number + " is " +
                        (isFactorian( number ) ? "" : "not ") + "a Factorian.");

            }
            else if (input.hasNext())
                inputString = input.next();
        } while (!inputString.equals("quit"));
    }

    public static int computeFactorial(int number)
    {
        int result = 1;
        for (int index=2; (index<=number); index++)
            result *= index;
        return result;
    }

    public static boolean isFactorian(int number)
    {
        int currentNumber = number;
        int sumOfFactorials = 0;
        do {
            sumOfFactorials += computeFactorial(currentNumber % 10);
            currentNumber /= 10;
        } while (currentNumber != 0);
        return (number == sumOfFactorials);
    }
}
