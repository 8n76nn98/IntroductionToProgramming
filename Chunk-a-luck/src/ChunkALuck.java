import java.awt.*;
import java.util.Scanner;

public class ChunkALuck {
    public static void main(String []args)
    {
        Wallet wallet = new Wallet();
        double userInitalCash = 0.0;
        boolean checkInputCorrectly = false;
        Scanner userInput =new Scanner(System.in);
        while (!checkInputCorrectly)
        {
            System.out.print("Please put some money into your wallet>");
            if(!userInput.hasNextDouble())
            {
                System.out.print("Your input is not vaild,please try again");
                userInput.next();
            }
            else
            {
                userInitalCash = userInput.nextDouble();
                wallet.put(userInitalCash);
                if(userInitalCash>0)
                {
                    checkInputCorrectly = true;
                    System.out.println("Your wallet contains"+String.format("%.2f",wallet.check()));
                }
                else
                {
                    checkInputCorrectly=false;
                    System.out.println("Your input is less than 0,please try again");
                }
            }
        }
    }


}
