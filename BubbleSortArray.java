public class Practice {

    public static void getMin(int []num)
    {
        int min = num[0];
        for(int i = 0 ; i<num.length;i++)
        {
            min = (num[i]<min?num[i]:min);
        }
        System.out.println(min);
    }
    public static void bubbleSort(int []array)
    {
        for(int outerIndex = 0;outerIndex<array.length-1;outerIndex++)
        {
            for(int innerIndex = 0;innerIndex<array.length-1-outerIndex;innerIndex++)
            {
                if(array[innerIndex]>array[innerIndex+1]) // from small to large ;otherwise <
                {
                    int temp = array[innerIndex+1];
                    array[innerIndex+1] = array[innerIndex];
                    array[innerIndex] =temp;
                }
            }
        }

    }
    public static void main(String []args)
    {
        int[] a = new int[]{ 9, 8, 7, 2, 3, 4, 1, 0, 6, 5 };//
        bubbleSort(a);
        for(int i = 0;i<a.length;i++)
        {
            System.out.print(a[i]);
            System.out.print(" ");
        }

    }

}
