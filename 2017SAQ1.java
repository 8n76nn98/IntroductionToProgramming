import javax.print.DocFlavor;
import java.util.*;

public class main {

    public static double getMinValue(HashMap<Integer,Double>indexOfValue)
    {
        ArrayList<Double>arrayForSort = new ArrayList<Double>();

        for(int element = 0;element<indexOfValue.size();element++)
        {

            double temp = indexOfValue.get(element);
            arrayForSort.add(temp);
        }
        Collections.sort(arrayForSort);
        double minValue = arrayForSort.get(0);
        return minValue;
    }

    public static boolean isVailDate(int day,int month,int year)
    {
        final int DAYS_OF_APRIL_JUNE_SEPTEM_NOV = 30;
        final int DAYS_OF_JUN_MARCH_MAY_JULY_AUG_OCTO_DEC = 31;
        //boolean combinationOfMonthOfDaysThrityOne = (month==1)||(month==3)||(month==5)||(month==7)||(month==8)||(month==10)||(month==12);
        //boolean combinationOfMonthOfDaysThrity =(month==4)||(month==6)||(month==9)||(month==11);
        boolean isLeapYear =false;
        if((year%4==0)&&(year%100!=0)||(year%400==0))
        {
            isLeapYear = true;
        }
        if (isLeapYear)
        {
            if((month<0)&&(month>12))
            {
                return false;
            }
            if((month==2)&&(day>30))
            {
                return false;
            }
           // boolean combinationOfMonthOfDaysThrity =(month==4)||(month==6)||(month==9)||(month==11);
            if((month==4)||(month==6)||(month==9)||(month==11))
            {
                if((day>=31)||(day<=0))
                {
                    return false;
                }

            }
            //JUN_MARCH_MAY_JUNE_JULY_OCTO_DEC
            //boolean combinationOfMonthOfDaysThrityOne = (month==1)||(month==3)||(month==6)||(month==7)||(month==8)||(month==10)||(month==12);
            if((month==1)||(month==3)||(month==5)||(month==7)||(month==8)||(month==10)||(month==12))
            {
                if((day<=0)||(day>=32))
                {
                    return  false;
                }

            }
        }
        else
        {
            if((month<0)&&(month>12))
            {
                return false;
            }
            if((month==2)&&(day>29))
            {
                return false;
            }
           // boolean combinationOfMonthOfDaysThrity =(month==4)||(month==6)||(month==9)||(month==11);
            if((month==4)||(month==6)||(month==9)||(month==11))
            {
                if((day>=31)||(day<=0))
                {
                    return false;
                }
            }
            //JUN_MARCH_MAY_JUNE_JULY_OCTO_DEC
            //boolean combinationOfMonthOfDaysThrityOne = (month==1)||(month==3)||(month==6)||(month==7)||(month==8)||(month==10)||(month==12);
            if((month==1)||(month==3)||(month==5)||(month==7)||(month==8)||(month==10)||(month==12))
            {
                if((day<=0)||(day>=32))
                {
                    return  false;
                }
            }
        }
        return true;
    }
    public static double getHashValue(int year,int month,int day)
    {
        double hashValue = year*100+month+(double)day/10;
        return hashValue;
    }

    public static boolean isBefore(int yearOne,int monthOne,int dayOne,
                                   int previousYear,int previousMonth,int previousDay)
    {
        if(yearOne>previousYear)
        {
           return false;
        }
        else if(yearOne == previousYear||(yearOne<previousYear))
        {
            if(monthOne>previousMonth)
            {
                return false;
            }
            else if(monthOne == previousMonth ||(monthOne<previousMonth))
            {
                if(dayOne>previousDay)
                {
                    return false;
                }
                else if(dayOne<previousDay)
                {
                    return true;
                }
                else if(dayOne ==previousDay)
                {
                    return true;
                }
            }
        }
        return true;

    }
    public static void main(String []args)
    {
        double hashValue = 0.0;
        boolean notFinished = false;
        //String []recordDate = new String[2000];
        String outputString ="";
        HashMap<Double,String>findMinumString = new HashMap<Double, String>();
        HashMap<String,Double>findMinuValue = new HashMap<String, Double>();
        HashMap<Integer,Double>indexOfValue = new HashMap<Integer, Double>();
        int index = 0;
        ArrayList<String>recordedDate = new ArrayList<String>();
        while(!notFinished)
        {
            System.out.print("Enter a data in the form dd-mm-yyyy>");
            Scanner inputScanner = new Scanner(System.in);
            String userInput = inputScanner.nextLine();
            if(userInput.equals("quit"))
            {
                notFinished = false;
                break;
            }
            String []arrayString = new String[3];
            arrayString= userInput.split("-");

            int day = Integer.parseInt(arrayString[0]);
           // System.out.println(day);
            int month = Integer.parseInt(arrayString[1]);
          //  System.out.println(month);
            int year = Integer.parseInt(arrayString[2]);
           // System.out.println(year);
            //new oder
            //String newOrderDate =year+"-"+month+"-"+day;
            String secondDate = "";
            if(isVailDate(day,month,year))
            {

                hashValue = getHashValue(year,month,day);
                System.out.println("current hash is"+hashValue);
                findMinumString.put(hashValue,userInput);
                findMinuValue.put(userInput,hashValue);
                indexOfValue.put(index,hashValue);
                index++;
                double previousMinumHashValue = getMinValue(indexOfValue);
                if(findMinumString.containsKey(previousMinumHashValue))
                    {
                    secondDate = findMinumString.get(previousMinumHashValue);
                }

                recordedDate.add(userInput);
                String [] stringtoArray = new String[3];
                stringtoArray = secondDate.split("-");
                int secondYear = Integer.parseInt(stringtoArray[2]);
                int secondMonth = Integer.parseInt(stringtoArray[1]);
                int secondDay = Integer.parseInt(stringtoArray[0]);
                outputString ="The earliest date entered so far is";
                if (isBefore(year,month,day,secondYear,secondMonth,secondDay) == false)
                {
                    outputString+=userInput;
                }
                else
                {
                    outputString +=secondDate;
                }
                System.out.println(outputString);
            }
            else
            {
                outputString = "The date"+day+"-"+month+"-"+year+"is invalid";
                System.out.println(outputString);
            }
        }
    }

}
