import java.util.*;

public class computAverage {
    public static int getMaxValue(ArrayList<Integer> arr) {

        Collections.sort(arr);
        int maxValue = arr.get(arr.size()-1);
        return maxValue;
    }
    public static int average(int []arryOfNumber)
    {
        int average =0;
        int sum = 0;

        for(int start = 0;start<arryOfNumber.length;start++)
        {
            sum += arryOfNumber[start];
        }
        return sum/arryOfNumber.length;
    }
    public static int[] readArrayOfNumbers(String userInput)
    {
        ArrayList<String> currentArry = new ArrayList<String>(Arrays.asList(userInput.split("\\s+")));
        ArrayList<Integer>integerArray = new ArrayList<Integer>();
        for(int element = 0;element<currentArry.size();element++)
        {
            //integerArray.get(element) =Integer.parseInt(currentArry.get(element));
            integerArray.add(Integer.parseInt(currentArry.get(element)));
        }
        int []answer = new int[integerArray.size()];
        for(int element = 0;element<integerArray.size();element++)
        {
            answer[element] = integerArray.get(element);
        }
        return answer;
    }
    public static void main(String []args)
    {
        ArrayList<Integer>averagelist  = new ArrayList<Integer>();
        HashMap<Integer,String>findPair = new HashMap<Integer, String>();
        //HashMap<String,Integer>findAverage = new HashMap<String, Integer>();
        boolean notFinished = false;
        while(!notFinished)
        {
            System.out.print("Enter a list of number>");
            Scanner inputScanner = new Scanner(System.in);
            String userInput = inputScanner.nextLine();
            if(userInput.equals("quit"))
            {
                notFinished = true;
                break;
            }
            int []arrayofNumber = readArrayOfNumbers(userInput);
            String valueString ="(";
            int length = arrayofNumber.length-1;
            for(int element = 0 ;element<arrayofNumber.length;element++)
            {
                valueString+=arrayofNumber[element]+(element==length?")":",");
            }
            valueString+='.';
            int average = average(arrayofNumber);
            findPair.put(average,valueString);
            averagelist.add(average);
            int currentMaxAv = getMaxValue(averagelist);
            //findAverage.put(outPut,average);
           // findPair.put(average,outPut);
            String outPut = "";
            if(findPair.containsKey(currentMaxAv))
            {
                int index = currentMaxAv;
                outPut = findPair.get(index);
            }
            System.out.println("The list of numbers of with the highest average is"+outPut);

        }
    }
}
