import java.util.Random;
import java.util.Scanner;

public class ceasChiper {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 0123456789&é'()-è_çà=+<>,?;.:/!";
    public static void decrypt(int []positions,char []alphabet,char []text)
    {
        for(int index = 0;index<text.length;index++)
        {
            text[index] = alphabet[positions[index]];
        }
    }
    public static void encrypt(int []positions,char []cipher,char []text) throws IllegalArgumentException
    {
        if(text==null)
        {
            throw  new IllegalArgumentException();
        }
        for(int index = 0;index<text.length;index++)
        {
            text[index] = cipher[positions[index]];
        }
    }
    public static void charToPosition(char []array,char []alphabet,int []position)
    {

        for(int index = 0;index<array.length;index++)
        {
            int count = 0;
            while(array[index] !=alphabet[count])
            {
                count++;
            }
            position[index]= count;
        }
    }
    public static void createCipher(char []array) throws IllegalArgumentException
    {
        if(array==null)
        {
            throw new IllegalArgumentException();
        }
        Random generator = new Random();
        for(int index = 0;index<array.length;index++)
        {
            int otherIndex = generator.nextInt(array.length);
            if(otherIndex!=index)
            {
                char temp = array[index];
                array[index] = array[otherIndex];
                array[otherIndex]= temp;
            }
        }
    }
    public static void main(String []args)
    {
        Scanner inputScanner = null;
        boolean finished = false;
        while(!finished)
        {
            inputScanner = new Scanner(System.in);
            System.out.println("Enter some text,or type '/end' to end the program");
            if(inputScanner.hasNext("/end"))
            {
                finished = true;
                System.out.println("You have stoped the program");
            }
            else if(inputScanner.hasNextLine())
            {
                String textInput = inputScanner.nextLine();
                char []arrayContainingCharacters = ALPHABET.toCharArray();
                char []arrayInput = textInput.toCharArray();
                int []charPositions = new int[arrayInput.length];
                charToPosition(arrayInput,arrayContainingCharacters,charPositions);
                createCipher(arrayContainingCharacters);
                encrypt(charPositions,arrayContainingCharacters,arrayInput);
                String tmpText = new String(arrayInput);
                System.out.println("Here is the encrpyted text:"+tmpText);
                arrayContainingCharacters=ALPHABET.toCharArray();
                decrypt(charPositions,arrayContainingCharacters,arrayInput);
                tmpText = new String(arrayInput);
                System.out.println("Here is the original text:"+textInput+"\n\n");


            }
            else
            {
                System.out.println("No input ,please enter again");
            }
        }
    }
}
