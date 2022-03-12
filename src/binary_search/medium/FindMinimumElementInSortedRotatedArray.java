/*
Find Minimum in Sorted Rotated Array.
Or
Find Pivot Element In Sorted Rotated Array.

Pivot Element: An Element Who Is Smaller Than Previous Element In Sorted Rotated Array.

Original Array = {1, 3, 8, 10, 17}

Input: array[] = {8, 10, 17, 1, 3}(Rotated Array By 3)
Output: 1

Input: array[] = {3, 8, 10, 17, 1}(Rotated Array By 4)
Output: 1

Input: array[] = {1, 3, 8, 10, 17}(Rotated Array By 5)
Output: 1
 */
package binary_search.medium;

import java.util.Scanner;

public class FindMinimumElementInSortedRotatedArray {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Size Of An Array:");
        int arraySize = scanner.nextInt();

        System.out.println("Enter The Elements:");
        int[] array = new int[arraySize];
        for(int i = 0 ; i < arraySize ; i++){
            array[i] = scanner.nextInt();
        }

        int pivot = Solution(array, arraySize);
        System.out.println("Minimum Element Or pivot Element Is " + pivot);

    }

    private static int Solution(int[] array, int arraySize) {
        int pivot = -1;

        int startIndex = 0;
        int endIndex = arraySize - 1;

        while(startIndex < endIndex){
            int middleIndex = startIndex + endIndex / 2;

            //We Are On That point Where Element Are Sorted To Both The Left & Right Side.
            if(middleIndex > 0 && array[middleIndex] < array[middleIndex - 1]){
                pivot = middleIndex;
                return array[pivot];
            }

            //Left Part Is Sorted & Right Part Is Not Sorted, So We Have To Search On The Right Side.
            if(array[startIndex] <= array[middleIndex] && array[middleIndex] > array[endIndex]){
                startIndex = middleIndex + 1;
            }

            //Right Part Is Sorted & Left Part Is Not Sorted, So We Have To Search On The Left Side.
            else{
                endIndex = middleIndex - 1;
            }
        }
        pivot = startIndex;
        return array[pivot];
    }
}
