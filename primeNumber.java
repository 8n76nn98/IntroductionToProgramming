/* SELF ASSESSMENT
   1.   createSequence:
Did I use the correct method definition?
Mark out of 5: 5
Comment:5
I have used all the method in the question
Did I create an array of size n (passed as the parameter) and initialise it?
Mark out of 5:5
Comment: Yes I have done it
Did I return the correct item?
Mark out of 5:5
Comment: yeah i correct it
   2.   crossOutMultiples
Did I use the correct method definition?
Mark out of 5:5
Comment: yea i do it
Did I ensure the parameters are not null and one of them is a valid index into the array
Mark out of 2:2
Comment:yeah
Did I loop through the array using the correct multiple?
Mark out of 5:5
Comment: making the right multiple
Did I cross out correct items in the array that were not already crossed out?
Mark out of 3:3
Comment: using boolean array to tag
   3.   sieve
Did I have the correct function definition?
Mark out of 5: 5
Comment:yeah
Did I make calls to other methods?
Mark out of 5:5
Comment: yeah crossMultiple and  print function
Did I return an array with all non-prime numbers are crossed out?
Mark out of 2:2
Comment: yeah
   4.   sequenceTostring
Did I have the correct function definition?
Mark out of 5:5
Comment: yeah
Did I ensure the parameter to be used is not null?
Mark out of 3:3
Comment: yeah
Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets?
Mark out of 10:10
Comment: yeah
   5.   nonCrossedOutSubseqToString
Did I have the correct function definition
Mark out of 5:5
Comment: yeah
Did I ensure the parameter to be used is not null?
Mark out of 3:3
Comment: yeah
Did I loop through the array updating the String variable with just the non-crossed out numbers?
Mark out of 5:5
Comment: yeah for loop
   6.   main
Did I ask  the user for input n and handles input errors?
Mark out of 5: yeah
Comments:5
Did I make calls to other methods (at least one)?
Mark out of 5:5
Comment:yeah
Did I print the output as shown in the question?
Mark out of 5:5
Comment: yeah
   7.   Overall
Is my code indented correctly?
Mark out of 4:4
Comments: yeash
Do my variable names make sense?
Mark out of 4:4
Comments: yeah
Do my variable names, method names and class name follow the Java coding standard
Mark out of 4:4
Comments: yeah
      Total Mark out of 100 (Add all the previous marks):100
*/
import java.util.Scanner;
public class primeNumber {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter a postive integer bigger than 2>");
        if(inputScanner.hasNextInt())
        {
            // this array to judge whether current integer is prime or not
            boolean primes [] = createSequence(inputScanner.nextInt());
            System.out.println(nonCrossedOutSubseqToString(primes));
            primes = sieve(primes);
            System.out.println(nonCrossedOutSubseqToString(primes));
        }
        else
        {
            System.out.println("The input entered is not an Integer");
        }
        inputScanner.close();
    }
    public static boolean [] createSequence(int number)
    {
        //+1 allows to have the boolean at index i to represent if i is a boolean or not (instead of i - 1)
        boolean array [] = new boolean[number + 1];
        if(number >= 2)
        {
            for(int index = 2; index < array.length; index++)
            {
                array[index] = true;
            }
            return array;
        }
        else
        {
            System.out.println("Number entered is not bigger or equal to 2");
            return null;
        }
    }

    public static String nonCrossedOutSubseqToString(boolean [] array)
    {
        if(array != null)
        {
            String output = "";
            for(int count = 2; count < array.length; count++)
            {
                if(count == 2)
                {
                    output += "2";
                }
                else if(array[count])
                {
                    output = output + (", " + count);
                }
            }
            return output;
        }
        else
        {
            return "Error : the array is empty";
        }

    }

    public static String sequenceToString(boolean [] array)
    {
        String output = "";
        for(int count = 2; count < array.length; count++)
        {
            if(count == 2)
            {
                output += "2";
            }
            else if(array[count])
            {
                output = output + (", " + count);
            }
            else
            {
                output = output + (", [" + count + "]");
            }
        }
        return output;
    }

    public static boolean [] sieve(boolean [] array)
    {
        if(array != null)
        {
            boolean tmpArray [] = new boolean[array.length];
            System.arraycopy(array, 0, tmpArray, 0, array.length);
            for(int index = 2; index * index < array.length; index++)//using array.length>= sqaure(index) but
            {
                /*
                Also could be writen as index < array.length/index but index may overflow ,using mathmathic transformation
                index *index <=array.length
                 */
                if(tmpArray[index])
                {
                    tmpArray = crossOutHigherMultiples(index, tmpArray);
                    System.out.println(sequenceToString(tmpArray));
                }
            }
            return tmpArray;
        }
        else
        {
            return null;
        }
    }

    public static boolean [] crossOutHigherMultiples(int number, boolean [] array)
    {
        boolean tmpArray [] = new boolean[array.length];
        System.arraycopy(array, 0, tmpArray, 0, array.length);
        for(int index = number * 2; index < array.length; index+= number)
        {
            tmpArray[index] = false;
        }
        return tmpArray;
    }
}
