import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class AlphabeticalOrder {
    public static boolean wordsInAlphabeticalOrder(char []firstWord)
    {
        int index = 0;
        while(index<firstWord.length)
        {
            if((firstWord[index]>firstWord[index+1])&&((index+1)!=firstWord.length))
            {
                return false;
            }
            index++;
            if((index+1)==firstWord.length)
            {
                break;
            }
        }
        return true;
    }
    public static double averageWordLength(String []words)
    {
        int index = 0;
        int sum = 0;
        while(index<words.length)
        {
            char []arrayArray = words[index].toCharArray();
            int countWords = 0;
            while(countWords<arrayArray.length)
            {
                countWords++;
            }
            sum+=countWords;
            index++;
        }
        double averageLength = (double)( sum)/words.length;
        return averageLength;
    }
    public static char[] longestWord(String []words)
    {
        String longestCharacter ="";
        int index = 0;
        int longestLength =0;
        while(index<words.length)
        {
            char []arrayArray = words[index].toCharArray();
            int countWords = 0;
            while(countWords<arrayArray.length)
            {
                countWords++;
            }
            if(countWords>longestLength)
            {
                longestLength=countWords;
                longestCharacter = words[index];
            }
            index++;
        }
        char []longCharacter = longestCharacter.toCharArray();
        return longCharacter;
    }
    public static void main(String []args)
    {
        boolean notFinish = false;
        while(!notFinish)
        {
            System.out.print("Enter a sentence>");
            Scanner inputScanner = new Scanner(System.in);
            if (inputScanner.hasNextLine())
            {
                String userSentence = inputScanner.nextLine();
                if(userSentence.equals(""))
                {
                    notFinish=true;
                    break;
                }
                userSentence = userSentence.replace('.',' ');
                String []finalCharacterArray = userSentence.split("\\s+");
                String fistword =finalCharacterArray[0];
                System.out.println(fistword);
                char []fistWordArray = fistword.toCharArray();
                int longestWordCount = 0;

                if(wordsInAlphabeticalOrder(fistWordArray))
                {
                    //System.out.println("Yes");
                    double averageLength = averageWordLength(finalCharacterArray);
                    System.out.println(averageLength);
                    char []longestWord=longestWord(finalCharacterArray);
                    String longestStringWord=String.valueOf(longestWord);
                    for(int i = 0;i<longestWord.length;i++)
                    {
                        longestWordCount++;
                    }
                    System.out.println("The words in the sentence are in alphabetical order,have an average length of \n"+
                            averageLength+"letters and"+"'"+longestStringWord+"'"+"is the longest word in sentence");
                }
                else
                {
                    System.out.println("No");
                    double averageLength = averageWordLength(finalCharacterArray);
                    System.out.println(averageLength);
                    char []longestWord=longestWord(finalCharacterArray);
                    String longestStringWord=String.valueOf(longestWord);
                    for(int i = 0;i<longestWord.length;i++)
                    {
                        longestWordCount++;
                    }
                    System.out.println("The words in the sentence are not in alphabetical order,have an average length of \n"+
                            averageLength+"letters and"+"'"+longestStringWord+"'"+"is the longest word in sentence");
                }

            }
            else
            {
                System.out.println("Your input is not valild,try again");
            }
        }
    }
}
