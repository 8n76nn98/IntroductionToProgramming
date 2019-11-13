import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static double weightedAverage(int []credit,int []studentPercentage)
    {
        double weightAverage = 0.0;
        int sum = 0;
        for(int element = 0;element<credit.length;element++)
        {
            int eachCredit = credit[element];
            int eachPrecentge = studentPercentage[element];
            sum += eachCredit*eachPrecentge;
        }
        System.out.println(sum);
        int totalCredits = 0;
        for(int element = 0;element<credit.length;element++)
        {
            totalCredits +=credit[element];
        }
        weightAverage = (double)sum/totalCredits;
        BigDecimal twoPrecion = new BigDecimal(weightAverage);
        weightAverage = twoPrecion.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        return weightAverage;
    }
    public static int[] readArrayOfNumbers(String userInput)
    {
        ArrayList<String> currentArry = new ArrayList<String>(Arrays.asList(userInput.split("\\s+")));
        ArrayList<Integer>integerArray = new ArrayList<Integer>();
        for(int element = 0;element<currentArry.size();element++)
        {
            //integerArray.get(element) =Integer.parseInt(currentArry.get(element));
            integerArray.add(Integer.parseInt(currentArry.get(element)));
        }
        int []answer = new int[integerArray.size()];
        for(int element = 0;element<integerArray.size();element++)
        {
            answer[element] = integerArray.get(element);
        }
        return answer;
    }
    public static void main(String []args)
    {
        System.out.print("Enter the ECTS(credits)associated with the courses>");
        Scanner inputScanner = new Scanner(System.in);

        String credits = inputScanner.nextLine();
        System.out.println(credits);
        int []creditsArray = readArrayOfNumbers(credits);
        for(int i = 0;i<creditsArray.length-1;i++)
        {
            System.out.print(creditsArray[i]);
        }
        double b = 2.000;
        BigDecimal ff = new BigDecimal(b);
        b = ff.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        boolean notFinished = false;
        while(!notFinished)
        {
            System.out.print("Enter student percentages>");
            String studnetPrecentageInput = inputScanner.nextLine();
            if(studnetPrecentageInput.equals("quit"))
            {
                notFinished = true;
                break;
            }
            int []studentPrecentageArray = readArrayOfNumbers(studnetPrecentageInput);
            for(int i:studentPrecentageArray)
            {
                System.out.println(i);
            }
            double currentStudentWeight = weightedAverage(creditsArray,studentPrecentageArray);
            System.out.println("Weight average is"+currentStudentWeight+" %");

        }

    }
}
