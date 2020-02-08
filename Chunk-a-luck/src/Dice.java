public class Dice {
    //number of sides on Dice
    private final int sides;
    //curent number on top face of dice
    private int topFace;
    //construct a dice with n sides,pre-condition:n>1
    public Dice(int n)
    {
        sides = n>1?n:2;//ensure at least 2 sides
        topFace = (int)(Math.random()*sides)+1;
    }
    //contruct a dice with 6 sides
    public Dice()
    {
        this(Constant.TOTAL_FACES_ON_DICES);//invoke Dice constructor with value 6

    }
    // return current value of top face of dice
    public int topFace()
    {
        return topFace;
    }
    // roll the dice;returning  the result
    public int roll()
    {
        topFace = (int)(Math.random()*sides)+1;
        return topFace;
    }
    // convert to a data type value
    @Override
    public String toString()
    {
        return getClass().getName() + "[sides = " + sides + ", topFace = " + topFace + "]";
    }




}
