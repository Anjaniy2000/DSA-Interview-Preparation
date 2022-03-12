/*
Find Total No. Of Occurrences Of An Element In Sorted Array.

Input: array = [1, 2, 3, 3, 3, 3, 5], key = 3
Output: 4, Element '3' Occurs 4 Times In An Array.

 */
package binary_search.easy;

import java.util.Scanner;

public class TotalNoOfOccOfElementInArray {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Size Of An Array:");
        int arraySize = scanner.nextInt();

        System.out.println("Enter The Elements:");
        int[] array = new int[arraySize];
        for(int i = 0 ; i < arraySize ; i++){
            array[i] = scanner.nextInt();
        }

        System.out.println("Enter K:");
        int k = scanner.nextInt();

        int occurrences = Solution(array, arraySize, k);
        System.out.println(occurrences);

    }

    private static int Solution(int[] array, int arraySize, int k) {
        int occurrences = 0;
        int firstOcc = FirstOcc(array, arraySize, k);
        int lastOcc = LastOcc(array, arraySize, k);

        //Formula To Count Total No. Of Occurrences:
        occurrences = (lastOcc - firstOcc + 1);
        return occurrences;
    }

    /*  Find The First Occurrence(We Need Leftmost Occurrence,
        So We Need To Search In Left Part After Every Successful Iteration */
    private static int FirstOcc(int[] array, int arraySize, int k) {
        int firstOcc = -1;
        int startIndex = 0;
        int endIndex = arraySize - 1;

        while(startIndex <= endIndex){
            int middleIndex = (startIndex + ((endIndex - startIndex) / 2));
            if(k == array[middleIndex]){
                firstOcc = middleIndex;
                endIndex = middleIndex - 1;
            }

            if(k < array[middleIndex]){
                endIndex = middleIndex - 1;
            }

            if(k > array[middleIndex]){
                startIndex = middleIndex + 1;
            }
        }
        return firstOcc;
    }

    /*  Find The Last Occurrence(We Need Rightmost Occurrence,
        So We Need To Search In Right Part After Every Successful Iteration */
    private static int LastOcc(int[] array, int arraySize, int k) {
        int lastOcc = -1;
        int startIndex = 0;
        int endIndex = arraySize - 1;

        while(startIndex <= endIndex){
            int middleIndex = (startIndex + ((endIndex - startIndex) / 2));
            if(k == array[middleIndex]){
                lastOcc = middleIndex;
                startIndex = middleIndex + 1;
            }

            if(k < array[middleIndex]){
                endIndex = middleIndex - 1;
            }

            if(k > array[middleIndex]){
                startIndex = middleIndex + 1;
            }
        }
        return lastOcc;
    }
}
