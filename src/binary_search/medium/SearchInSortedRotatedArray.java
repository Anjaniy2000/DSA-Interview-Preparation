/*
Search A Given Element In Sorted Rotated Array.

Input: array = [4,5,6,7,0,1,2], key = 0
Output: 4

Input: array = [4,5,6,7,0,1,2], key = 3
Output: -1

Input: array = [1], key = 0
Output: -1
 */
package binary_search.medium;

import java.util.Scanner;

public class SearchInSortedRotatedArray {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Size Of An Array:");
        int arraySize = scanner.nextInt();

        System.out.println("Enter The Elements:");
        int[] array = new int[arraySize];
        for(int i = 0 ; i < arraySize ; i++){
            array[i] = scanner.nextInt();
        }

        System.out.println("Enter A Key");
        int key = scanner.nextInt();

        int index = Solution(array, arraySize, key);
        System.out.println(index);
    }

    /*
    Solution Steps: 1). Find Pivot Element Of Given Array.
                    2). Figure Out Where(In Which Part Of The Array) Our Key Will Be Present(Either Left Side Or Right Side).
                    3). Use Binary Search & Find Our Key.
     */
    private static int Solution(int[] array, int arraySize, int key) {
        int index = -1;

        //Step - 1:
        int pivot = getPivot(array, arraySize);

        //Step - 1:
        if(key >= array[pivot] && key <= array[arraySize - 1]){
                index =  binarySearch(array, pivot, arraySize - 1, key);
        }
        else{
            index = binarySearch(array, 0, pivot - 1, key);
        }
        return index;
    }

    //Return Pivot Element Of Our Array.
    private static int getPivot(int[] array, int arraySize) {
        int startIndex = 0;
        int endIndex = arraySize -1;

        while(startIndex < endIndex){
            int middleIndex = (startIndex + endIndex) / 2;

            if(middleIndex > 0 && array[middleIndex] < array[middleIndex -1]){
                return  middleIndex;
            }

            if(array[startIndex] <= array[middleIndex] && array[middleIndex] > array[endIndex]){
                startIndex = middleIndex + 1;
            }

            else{
                endIndex = middleIndex - 1;
            }
        }

        return startIndex;
    }

    //Binary Search Algo:
    private static int binarySearch(int[] array, int startIndex, int endIndex, int key) {

        while(startIndex <= endIndex){
            int middleIndex = (startIndex + endIndex) / 2;

            if(key == array[middleIndex]){
                return middleIndex;
            }
            if(key < array[middleIndex]){
                endIndex = middleIndex - 1;
            }

            if(key > array[middleIndex]){
                startIndex = middleIndex + 1;
            }
        }

        return -1;
    }

}
