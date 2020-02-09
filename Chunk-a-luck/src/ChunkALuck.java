/* SELF ASSESSMENT

1. ResolveBet

I have correctly defined ResolveBet which takes the bet type (String) and the Wallet object, and a void return type [Mark out of 7: ].
Comment:
My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet [Mark out of 8: ].
Comment:
My program ensures the bet amount is not greater than the cash in the wallet [Mark out of 5: ].
Comment:
My program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned [Mark out of 15: ]..
Comment:
My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet [Mark out of 20: ].
Comment:
My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses [Mark out of 10: ].
Comment:

2. Main

I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it [Mark out of 15: ]
Comment:
My program loops continuously until the user either enters quit or the cash in the wallet is 0 [Mark out of 5: ]
Comment:
I ask the user to enter any of the four bet types or quit [Mark out of 5: ].
Comment:
My program calls resolveBet for each bet type entered [Mark out of 5: ].
Comment:
At the end of the game my program presents a summary message regarding winnings and losses [Mark out of 5: ]
Comment:

 Total Mark out of 100 (Add all the previous marks):
*/

import java.awt.*;
import java.util.Scanner;

public class ChunkALuck {
    public static void IntroduceingRuleToUser()
    {
        //Welcomeing sentence
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("|Type of Bet:   |Condition:                                      | Payout (Odds): |");
        System.out.println("|    Triple     |All 3 dice show same number (but not 1s or 6s). |       30:1     |");
        System.out.println("|    Field      |     Total of 3 dice < 8 or total is > 12.      |       1:1      |");
        System.out.println("|    High       |     Total of 3 dice > 10 (but not a Triple).   |       1:1      |");
        System.out.println("|    Low        |     Total of 3 dice < 11 (but not a Triple).   |       1:1      |");
        System.out.println("-----------------------------------------------------------------------------------");

    }
    public static boolean judgeTriple(Dice one,Dice two,Dice three)
    {
        boolean isTriple = false;
        if((one.topFace() == two.topFace())&&(two.topFace()==three.topFace()
        )&&(one.topFace()==three.topFace()))
        {
            isTriple = true;
        }
        return isTriple;
    }

    public static void ResolveBet(String betType,Wallet userWallet)
    {
        Scanner inputScanner = new Scanner(System.in);
        boolean correctInput = false;
        while (!correctInput)
        {
            System.out.println("The wallet contains"+String.format(".%2f",userWallet.check()));
            System.out.print("Please enter how much money you want to bet>");
            if(inputScanner.hasNextDouble())
            {
                double userInputBet =inputScanner.nextDouble();
                if(userWallet.get(userInputBet))
                {
                    correctInput = true;
                    System.out.println("You are betting "+String.format("%.2f",userInputBet)+"on"+betType);
                    Dice diceOne = new Dice();
                    Dice diceTwo = new Dice();
                    Dice diceThree= new Dice();
                    diceOne.roll();
                    diceTwo.roll();
                    diceThree.roll();
                    boolean checkTriple = false;
                    boolean selectedTriple = false;
                    boolean selectedField = false;
                    boolean selectedHigh = false;
                    boolean selectedLow = false;
                    int totalOfThreeDice = diceOne.topFace()+diceTwo.topFace()+diceThree.topFace();

                    if(judgeTriple(diceOne,diceTwo,diceThree))
                    {
                        checkTriple = true;
                        if((totalOfThreeDice==Constant.TRIPLE_LOWEST)||(totalOfThreeDice==Constant.TRIPLE_HIGHEST))
                        {

                        }
                        else
                        {
                            selectedTriple =true;
                        }
                    }
                    if((totalOfThreeDice>Constant.LOWER_BOUND_OF_FIELD)||(totalOfThreeDice<Constant.UPPER_BOUND_OF_FIELD))
                    {
                        selectedField=true;
                    }
                    if((totalOfThreeDice>Constant.LOWER_BOUND_OF_HIGH)&&(!checkTriple))
                    {
                        selectedHigh = true;
                    }
                    if((totalOfThreeDice<Constant.UPPER_BOUND_OF_LOW)&&(!checkTriple))
                    {
                        selectedLow = true;
                    }

                    System.out.println("\nDice One rolled:"+ diceOne.topFace()
                            +"\nDice Two rolled:"+ diceTwo.topFace()
                            +"\nDice Three rolled:"+ diceThree.topFace()
                            +"\nTotal:"+totalOfThreeDice+"\n");

                    switch (betType)
                    {
                        case "Triple":
                            if(selectedTriple)
                            {
                                System.out.println("congratulation you won! you bet on Triple ");
                                userWallet.put((userInputBet*Constant.WINING_MULTIPLE_OF_TRIPLE)+userInputBet);
                                System.out.println("You have won"+String.format("%.2f",userInputBet*Constant.WINING_MULTIPLE_OF_TRIPLE));

                            }
                            else
                            {
                                System.out.println("Unfortunately  you lose .... you bet on Triple ");
                                System.out.println("You have lost"+String.format("%.2f",userInputBet));

                            }
                            break;
                        case "Field":
                            if(selectedField)
                            {
                                System.out.println("congratulation you won! you bet on Field ");
                                userWallet.put(userInputBet);
                                System.out.println("You have won"+String.format("%.2f",userInputBet));

                            }
                            else
                            {
                                System.out.println("Unfortunately  you lose .... you bet on Field ");
                                System.out.println("You have lost"+String.format("%.2f",userInputBet));

                            }
                            break;
                        case "High":
                            if(selectedHigh)
                            {
                                System.out.println("congratulation you won! you bet on High ");
                                userWallet.put(userInputBet);
                                System.out.println("You have won"+String.format("%.2f",userInputBet));

                            }
                            else
                            {
                                System.out.println("Unfortunately  you lose .... you bet on High ");
                                System.out.println("You have lost"+String.format("%.2f",userInputBet));

                            }
                            break;
                        case "Low":
                            if(selectedLow)
                            {
                                System.out.println("congratulation you won! you bet on Low ");
                                userWallet.put(userInputBet);
                                System.out.println("You have won"+String.format("%.2f",userInputBet));

                            }
                            else
                            {
                                System.out.println("Unfortunately  you lose .... you bet on Low ");
                                System.out.println("You have lost"+String.format("%.2f",userInputBet));

                            }
                            break;
                        default:
                            break;
                    }
                    System.out.println("The current amount of moeny is"+String.format("%.2f",userWallet.check()));

                }
                else
                {
                    System.out.println("There is no enough money to bet,please try again");
                    inputScanner.nextLine();
                }


            }
            else
            {
                System.out.print("Your input is not vailed,please try again");
                inputScanner.nextLine();
            }
        }

    }
    public static void summaryMessage(double userInitalCash,Wallet userWallet)
    {
        double cashDifference = Constant.ZERO;
        String cashCompared = null;
        if(userInitalCash>userWallet.check())
        {
            cashDifference = userInitalCash-userWallet.check();
            cashCompared="\nOverall, you lost "+String.format("%.2f",cashDifference)+".";
        }
        else if(userInitalCash<userWallet.check())
        {
            cashDifference = userWallet.check()-userInitalCash;
            cashCompared="\nOverall, you won "+String.format("%.2f",cashDifference)+".";
        }
        System.out.println("You started with "+String.format("%.2f",userInitalCash)+" and you "
                + "now have "+String.format("%.2f",userWallet.check())+cashCompared);
    }
    public static void main(String []args)
    {
        Wallet wallet = new Wallet();
        double userInitalCash = Constant.ZERO;
        boolean checkInputCorrectly = false;
        Scanner inputScanner =new Scanner(System.in);
        while (!checkInputCorrectly)
        {
            System.out.print("Please put some money into your wallet>");
            if(!inputScanner.hasNextDouble())
            {
                System.out.println("Your input is not vaild,please try again");
                inputScanner.nextLine();
            }
            else
            {
                userInitalCash = inputScanner.nextDouble();
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


        boolean terminateGame = false;
        int countTerm = 0;

        while (!terminateGame)
        {
            IntroduceingRuleToUser();
            System.out.println("Please enter the type you would like to choose");
            System.out.print("Please enter either 'Triple','Field'.'High','Low' or 'Quit'>");
            String userInput = inputScanner.next();
            if(userInput.equalsIgnoreCase("Triple"))
            {
                ResolveBet("Triple",wallet);

            }
            else if(userInput.equalsIgnoreCase("Field"))
            {
                ResolveBet("Field",wallet);

            }
            else if(userInput.equalsIgnoreCase("High"))
            {
                ResolveBet("High",wallet);

            }
            else if(userInput.equalsIgnoreCase("Low"))
            {
                ResolveBet("Low",wallet);

            }
            else if(userInput.equalsIgnoreCase("Quit"))
            {
                terminateGame = true;
                // summary message
                summaryMessage(userInitalCash,wallet);
                System.out.print("You stop the game,goodbye.");
            }
            else
            {
                System.out.println("Invalid Input. Please enter either 'Triple','Field'.'High','Low' or 'Quit'");
            }

            if(wallet.check()==Constant.ZERO)
            {
                summaryMessage(userInitalCash,wallet);
                System.out.println("You have ran out of money, unlucky. Goodbye");
            }
            System.out.println("This is "+(++countTerm)+" term of game");

        }
    }
}
