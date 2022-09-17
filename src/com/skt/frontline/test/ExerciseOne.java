package com.skt.frontline.test;

public class ExerciseOne {
	// method to find the length of longest increasing contiguous subarray
    public void printLongestIncSubArr(int arr[])
    {
        // 'longest': length of longest subarray
        // 'len' to store the lengths of longest
        int longest = 1, len = 1, longestIdx = 0;
        int n = arr.length;
        //skip first element of array
        for (int i = 1; i < n; i++)
        {
            /** if current-element > previous-element,
        	    start building up subarray with this element **/
            if (arr[i] > arr[i-1])
                len++;
            else
            {
                /* if 'longest' length < length of the current increasing subarray
                 then update 'longest' **/
                if (longest < len)   
                {
                    longest = len;
                    /* index assign the starting
                     index of longest increasing
                     contiguous subarray. **/  
                    longestIdx = i - longest;
                }
                /** reset 'len' to 1 as from this element again the length of the
                 new increasing subarray is being calculated   **/
                len = 1;   
            }   
        }
          
        // comparing the length of the last
        // increasing subarray with 'longest'
        if (longest < len)
        {
            longest = len;
            longestIdx = n - longest;
        }
      
        // Print the elements of longest
        // increasing contiguous subarray.
        for (int i = longestIdx; i < longest+longestIdx; i++)
            System.out.print(arr[i] + " ");
    }
     
    public static void main(String[] args)
    {
        int arr[] = {5, 6, 13, 5, 17, 18, 19, 21, 2};
        ExerciseOne exOne = new ExerciseOne();
        exOne.printLongestIncSubArr(arr);
    }
}