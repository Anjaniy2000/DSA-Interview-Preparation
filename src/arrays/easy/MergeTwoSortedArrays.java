package arrays.easy;

/*
You are given two integer arrays array1 and array2,
sorted in non-decreasing order,
and two integers m and n, representing the number of elements in array1 and array1 respectively.

Merge array1 and array1 into a single array sorted in non-decreasing order.

Note:   The final sorted array should not be returned by the function, but instead be stored inside the array array1.
        To accommodate this, array1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored.
        array2 has a length of n.

Examples:

Input: array1 = [1,2,3,0,0,0], m = 3, array2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from array1.

Input: array1 = [1], m = 1, array2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].

Input: array1 = [0], m = 0, array2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in array1. The 0 is only there to ensure the merge result can fit in array1.

 */

import java.util.Scanner;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int firstArraySize = scanner.nextInt();
        int[] firstArray = new int[firstArraySize];
        for(int i = 0 ; i < firstArraySize ; i++){
            firstArray[i] = scanner.nextInt();
        }

        int secondArraySize = scanner.nextInt();
        int[] secondArray = new int[secondArraySize];
        for(int i = 0 ; i < secondArraySize ; i++){
            secondArray[i] = scanner.nextInt();
        }

//        int[] result = bruteForceApproach(firstArray, secondArray, firstArraySize , secondArraySize);
//        for(int i : result){
//            System.out.print(i + " ");
//        }

        optimalApproach(firstArray, secondArray, firstArraySize , secondArraySize);

        scanner.close();
    }

    //With Extra Space + 2-Pointers Approach:
    private static int[] bruteForceApproach(int[] firstArray, int[] secondArray, int firstArraySize, int secondArraySize) {
        int[] result = new int[firstArraySize + secondArraySize];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < firstArraySize && j < secondArraySize){
            if(firstArray[i] < secondArray[j]){
                result[k] = firstArray[i];
                i++;
                k++;
            }
            else{
                result[k] = secondArray[j];
                j++;
                k++;
            }
        }

        //Remaining Elements In FirstArray:
        while(i < firstArraySize){
            result[k] = firstArray[i];
            i++;
            k++;

        }

        //Remaining Elements In SecondArray:
        while(j < secondArraySize){
            result[k] = secondArray[j];
            j++;
            k++;
        }

        return result;
    }

    //Optimal Approach With O(1) Space:
    private static void optimalApproach(int[] firstArray, int[] secondArray, int firstArraySize, int secondArraySize) {
        int i = firstArraySize;
        int j = secondArraySize;
        int k = firstArraySize;

        while(i >= 0 && j >= 0){
            if(firstArray[i] > secondArray[j]){
                firstArray[k] = firstArray[i];
                i--;
            }
            else{
                firstArray[k] = secondArray[j];
                j--;
            }

            k--;
        }

        while(j >= 0){
            firstArray[k] = secondArray[j];
            j--;
            k--;
        }
    }
}
