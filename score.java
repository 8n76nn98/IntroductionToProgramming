import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class score {
    public static String grade(double average)
    {
        final String FIRST_CLASS = "First class honour(I)";
        final String SECOND_CLASS_FIRST_DIVISION ="Second class First division honour(II,2)";
        final String SECOND_CLASS_SECOND_DIVISION ="Second class Second division honour(II,2)";
        final String THIRD_CLASS = "Third class honour(III)";
        final String FAIL = "Fail(F)";
        String grade = "";
        double copyAverage = average;
        if(copyAverage>=70)
        {
            grade =FIRST_CLASS;
        }
        else if((copyAverage>=60)&&(copyAverage<70))
        {
            grade= SECOND_CLASS_FIRST_DIVISION;
        }
        else if((copyAverage>=50)&&(copyAverage<60))
        {
            grade =SECOND_CLASS_SECOND_DIVISION;
        }
        else if((copyAverage>=40)&&(copyAverage<50))
        {
            grade =THIRD_CLASS;
        }
        else if((copyAverage>=0)&&(copyAverage<40))
        {
            grade = FAIL;
        }
        else
        {
            grade="Not vailed number";
        }
        return grade;
    }
    public static void main(String []args)
    {
        Scanner inputScaner = new Scanner(System.in);
        String userInput = inputScaner.nextLine();
        ArrayList<String> currentArry = new ArrayList<String>(Arrays.asList(userInput.split("\\s+")));
        ArrayList<Double>DoubleArray = new ArrayList<Double>();

        for(int element =0;element<currentArry.size();element++)
        {
            DoubleArray.add(Double.parseDouble(currentArry.get(element)));
        }
        double []answer = new double[DoubleArray.size()];
        for(int element = 0;element<DoubleArray.size();element++)
        {
            answer[element] = DoubleArray.get(element);
        }
        /*
        for(int i = 0;i<answer.length;i++)
        {
            System.out.println(answer[i]);
        }

         */
        double sum = 0;
        for(int i = 0;i<answer.length;i++)
        {
            sum += answer[i];
        }
        double average = sum/answer.length;
        System.out.println(average);

        String grade = grade(average);
        System.out.println(grade);


    }

}


