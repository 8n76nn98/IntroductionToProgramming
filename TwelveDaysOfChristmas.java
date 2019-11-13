/*self-assessment

using constant instead of using string directly by UPPER CASE
Form of getVese by using += to link string and using \n to change line
i have use proper funcation header,funcation calls and function implemnted
fOR getgifts and getordinal day ,both of these functions have using
switch case
output is correctly
I did self-assesement by myself

for variables, i have used upper camera case
when reverseNumber = 12
The last symbol is ! rather than .

 */


public class TwelveDaysOfChristmas {
    public static final String FIRST_GIFT = "<tag> Partridge in a Pear Tree.<end>\n";
    public static final String SECOND_GIFT = "two Turtle Doves\n";
    public static final String THIRD_GIFT = "three French Hens,\n";
    public static final String FOURTH_GIFT = "four Calling Birds,\n";
    public static final String FIFTH_GIFT = "five Gold Rings,\n";
    public static final String SIXTH_GIFT = "six Geese a Laying,\n";
    public static final String SEVENTH_GIFT = "seven Swans a Swimming,\n";
    public static final String EIGHTH_GIFT = "eight Maids a Milking,\n";
    public static final String NINTH_GIFT = "nine Ladies Dancing,\n";
    public static final String TENTH_GIFT = "ten Lords a Leaping,\n";
    public static final String ELEVENTH_GIFT = "eleven Pipers Piping,\n";
    public static final String TWELFTH_GIFT = "twelve Drummers Drumming,\n";
    public static String getVerse(int reverseNumber)
    {
        String start = "On the ";
        String dayString = getOrdinalString(reverseNumber);
        start+=dayString+" day of Christmas \n";
        start+="my true love sent to me:\n";
        String verse = "";
        String end =getChristmasGift(1);
        if(reverseNumber ==1)
        {
            end = end.replace("<tag>", "A");
            end = end.replace("<end>","");
        }
        else if(reverseNumber==12)
        {
            end = end.replace("<tag>", "And a");
            end = end.replace(".<end>","!");
        }
        else
        {
            end = end.replace("<tag>", "A");
            end = end.replace("<end>","");

        }
        for(int day = reverseNumber;day>=2;day--)
        {
            verse +=getChristmasGift(day);

        }
        return start+verse+end;
    }

    public static String getChristmasGift(int day)
    {
        String gifts = "";

        switch (day)
        {
            case  12:

                gifts=TWELFTH_GIFT;
                break;
            case  11:

                gifts=ELEVENTH_GIFT;

                break;

            case  10:

                gifts=TENTH_GIFT;
                break;


            case  9:

                gifts=NINTH_GIFT;
                break;


            case  8:

                gifts=EIGHTH_GIFT;
                break;

            case  7:

                gifts=SEVENTH_GIFT;
                break;

            case  6:

                gifts=SIXTH_GIFT;
                break;

            case  5:
                gifts=FIFTH_GIFT;
                break;

            case  4:

                gifts=FOURTH_GIFT;
                break;

            case  3:

                gifts=THIRD_GIFT;
                break;

            case  2:

                gifts=SECOND_GIFT;
                break;

            default:
                gifts = FIRST_GIFT;
                break;
        }
        return gifts;
    }
    public static String getOrdinalString(int day)
    {
        String ordinalString = "";
        final String ORDINAL_ONE = "first";
        final String ORDINAL_TWO = "second";
        final String ORDINAL_THREE = "third";
        final String ORDINAL_FOUR = "fourth";
        final String ORDINAL_FIVE= "fifth";
        final String ORDINAL_SIX = "sixth";
        final String ORDINAL_SEVEN = "seventh";
        final String ORDINAL_EIGHT = "eighth";
        final String ORDINAL_NINE = "nineth";
        final String ORDINAL_TEN= "tenth";
        final String ORDINAL_ELEVEN = "eleventh";
        final String ORDINAL_TWELEVE = "twelfth";
        switch (day)
        {
            case 1:
                ordinalString =ORDINAL_ONE;
                break;
            case 2:
                ordinalString =ORDINAL_TWO;
                break;
            case 3:
                ordinalString =ORDINAL_THREE;
                break;
            case 4:
                ordinalString =ORDINAL_FOUR;
                break;
            case 5:
                ordinalString =ORDINAL_FIVE;
                break;
            case 6:
                ordinalString =ORDINAL_SIX;
                break;
            case 7:
                ordinalString =ORDINAL_ELEVEN;
                break;
            case 8:
                ordinalString =ORDINAL_EIGHT;
                break;
            case 9:
                ordinalString =ORDINAL_NINE;
                break;
            case 10:
                ordinalString =ORDINAL_TEN;
                break;
            case 11:
                ordinalString =ORDINAL_ELEVEN;
                break;
            default:
                ordinalString=ORDINAL_TWELEVE;
                break;
        }
        return ordinalString;
    }
    public static void main(String []args)
    {
        final int TOTAL_DAYS = 12;
        String eachVerse = "";
        for(int day = 1;day <=TOTAL_DAYS;day++)
        {
           eachVerse =getVerse(day);
           System.out.print(eachVerse);
           eachVerse ="";

        }

    }
}
