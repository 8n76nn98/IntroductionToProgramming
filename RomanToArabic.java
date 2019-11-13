import javax.swing.*;
import java.util.HashMap;
import java.util.Scanner;

public class RomanToArabic {
    public static final int LOWER_BOUND_VALUE =1;
    public static final int UPPER_BOUND_VALUE =3999;
    public static final int ERROR_VALUE = 1;
    public static boolean isVaildRomanNumber(String romanNumberals)
    {
        int length = romanNumberals.length();
        int countSmallNumber =0;
        int countBigNumber =  0;
        int index = 0;
        int secondPointer =1;
        int thirdPointer =2;
        int fourthPointer=3;
        while((index<length)&&(secondPointer<length)&&(thirdPointer<length)&&(fourthPointer<length))
        {
            if ((romanNumberals.charAt(index)=='I')||(romanNumberals.charAt(index)=='X')||(romanNumberals.charAt(index)=='C')||(romanNumberals.charAt(index)=='M')&&(romanNumberals.charAt(index)==romanNumberals.charAt(secondPointer)))
            {
                if(romanNumberals.charAt(secondPointer)==romanNumberals.charAt(thirdPointer))
                {
                    if (romanNumberals.charAt(thirdPointer)==romanNumberals.charAt(fourthPointer))
                    {
                        return false;
                    }
                    else
                    {
                        return true;
                    }
                }
                else
                {
                    return true;
                }
            }
            else
            {
                return true;
            }
        }
        return true;
    }
    public static int convertToArabic(String romanNumberals)
    {
        HashMap<Character,Integer>map = new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int result = 0;
        int length = romanNumberals.length();
        int count = 0;
        while(count<length)
        {
            if((count<length-1)&&(map.get(romanNumberals.charAt(count))<map.get(romanNumberals.charAt(count+1))))
            {
                result += map.get(romanNumberals.charAt(count+1))-map.get(romanNumberals.charAt(count));
                count = count+2;
            }
            else
            {
                result += map.get(romanNumberals.charAt(count));
                count++;
            }

        }
        if(result <LOWER_BOUND_VALUE || result>UPPER_BOUND_VALUE)
        {
            return ERROR_VALUE;
        }
        else {
            return result;
        }
    }
    public static void main(String []args)
    {

        boolean notFinished = false;
       // int value = convertToArabic(inputRomanNumerial);
       // System.out.println(value);
        while(!notFinished)
        {
            System.out.print("Enter the Roman number to be converted>");
            Scanner inputScanner = new Scanner(System.in);
            String inputRomanNumerial = "";
            inputRomanNumerial = inputScanner.nextLine();
            if(inputRomanNumerial.equals(""))
            {
                notFinished = true;
                break;
            }
            if(isVaildRomanNumber(inputRomanNumerial))
            {
                int arbricValue = convertToArabic(inputRomanNumerial);
                String outputValue = (arbricValue == -1? " not valid.":""+arbricValue+".");
                System.out.println("In Arabic form "+inputRomanNumerial+"is "+outputValue);
            }
            else
            {
                System.out.println("Your input is not valied");
            }
        }

    }
}
