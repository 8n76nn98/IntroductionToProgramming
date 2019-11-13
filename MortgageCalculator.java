import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Scanner;
/* SELF ASSESSMENT

 1. Did I use easy-to-understand meaningfu,l properly formatted, variable names and CONSTANTS?
        Mark out of 10:
        Comment:  Yes i did
 2. Did I indent the code appropriately?
        Mark out of 5:
        Comment:   Yes i did
 3. Did I implement the mainline correctly with a loop which continues using the user says "no" ?
       Mark out of 10:
        Comment:  I've used while loop
 4. Did I obtain the relevant inputs from the user and produce the relevant outputs using the specified prompts & formats ?
       Mark out of 10:
        Comment:
 5. Did I implement the readDoubleFromUser function correctly and in a manner that can be easily understood (4 marks for function definition, 4 marks for function call and 12 marks for function implementation)?
       Mark out of 20:
        Comment:  I made a proper function header and using rightly
 6. Did I implement the calculateMonthlyRepayment function correctly in a manner that can be easily understood (4 marks for function definition, 4 marks for function call and 12 marks for function implementation)?
       Mark out of 20:
        Comment:  I made a proper function header and using rightly
 7. Did I implement the calculateMonthsToRepayMortgage function correctly in a manner that can be easilyunderstood (4 marks for function definition, 4 marks for function call and 12 marks for function implementation)?
       Mark out of 20:
        Comment:  I made a proper function header and using rightly
 8. How well did I complete this self-assessment?
        Mark out of 5:
        Comment:I have test the sample
 Total Mark out of 100 (Add all the previous marks):
*/



public class MortgageCalculator {
    public static final int DURATION_OF_YEAR = 20;
    public static double affordMoneyPerMonth=0.0;
    public static double readDoubleFunction(Scanner inputScanner)
    {
        boolean isDoubleNumber = false;
        double value = 0.0;
        while(!isDoubleNumber)
        {
            if(inputScanner.hasNextDouble())
            {
                value = inputScanner.nextDouble();
                isDoubleNumber = true;
            }
            else
            {
                Scanner inputScanner2 = new Scanner(System.in);
                value =readDoubleFunction(inputScanner2);
            }
        }
        return value;
    }
    public static double calculateMonthlyRepayment(double mortageAmount,int lengthOfDuration,double APR)
    {
        double principal =mortageAmount;
        double monthlyRepayment = 0.0;
        double numerator = principal*(APR/(12*100));
        double base = 1+APR/(12*100);
        double expoent = -12*lengthOfDuration;
        double deminator = (1-Math.pow(base,expoent));
        monthlyRepayment = numerator/deminator;
        BigDecimal precision = new BigDecimal(monthlyRepayment);
        monthlyRepayment = precision.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        return monthlyRepayment;
    }

    public static int calculateMonthsToRepayMortgage(double mortageAmount,double monthlyRepay,double annualRate)
    {
        double totalMoney = monthlyRepay*DURATION_OF_YEAR*12;
        double deminator = affordMoneyPerMonth+(affordMoneyPerMonth-monthlyRepay)/2;
        double day = (totalMoney/deminator);
        return ((int)Math.round(day));

    }
    public static void main(String []args)
    {
        String ending = "yes";
        do {
            System.out.println("Welcome to the mortgage calculator.");
            System.out.print("Please enter the mortgage amount:");
            Scanner inputScanner = new Scanner(System.in);
            double mortageAmount = readDoubleFunction(inputScanner);
            System.out.print("Please enter the annual interest rate (APR):");
            double APR = readDoubleFunction(inputScanner);
            double monthlyRepayments = calculateMonthlyRepayment(mortageAmount,DURATION_OF_YEAR,APR);
            System.out.println("Assuming a 20 year term, the monthly repayments would be "+monthlyRepayments);

            System.out.print("How much can you afford to pay per month?");
            affordMoneyPerMonth = readDoubleFunction(inputScanner);
            int totoalMoth = calculateMonthsToRepayMortgage(mortageAmount,monthlyRepayments,APR);
            int year = totoalMoth/12;
            int month = totoalMoth-year*12;
            DecimalFormat presion = new DecimalFormat("0.00");
            System.out.println("If you pay "+presion.format(affordMoneyPerMonth)+" per month your mortgage would be paid off in "+year+" years and "+month+" months.");

            System.out.print("Would you like to use the mortgage calculator again (yes/no)?");
            ending = inputScanner.next();
        }while (!ending.equalsIgnoreCase("no"));
    }

}
