/*
Find Peak Element In Mountain Array.
A peak element is an element that is strictly greater than its neighbors.

Given an integer array nums,
find a peak element, and return its index.
If the array contains multiple peaks, return the index to any of the peaks.

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2,
or index number 5 where the peak element is 6.
 */
package binary_search.medium;

import java.util.Scanner;

public class FindPeakInMountain {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Size Of An Array:");
        int arraySize = scanner.nextInt();

        System.out.println("Enter The Elements:");
        int[] array = new int[arraySize];
        for(int i = 0 ; i < arraySize ; i++){
            array[i] = scanner.nextInt();
        }

        int peakElement = Solution(array, arraySize);
        System.out.println(peakElement);
    }

    private static int Solution(int[] array, int arraySize) {
        int peakElement = -1;

        int startIndex = 0;
        int endIndex = arraySize - 1;

        while(startIndex < endIndex){
            int middleIndex = (startIndex + endIndex) / 2;

            if(array[middleIndex] < array[middleIndex + 1]){
                startIndex = middleIndex + 1;
            }
            else{
                endIndex = middleIndex;
            }
        }

        peakElement = startIndex;
//        System.out.println(peakElement);
        return array[peakElement];
    }
}
