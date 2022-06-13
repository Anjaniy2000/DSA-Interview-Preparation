package arrays.easy;

import java.util.Arrays;
import java.util.Scanner;

/*
Given an integer sorted array in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Examples:

Input: array = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Input: array = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

 */
public class SortedSquaredArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size  = scanner.nextInt();
        int[] array = new int[size];
        for(int i = 0 ; i < size ; i++){
            array[i] = scanner.nextInt();
        }

//        int[] result = bruteForceApproach(array, size);
//        for(int i : result){
//            System.out.print(i + " ");
//        }

        int[] result = twoPointersApproach(array, size);
        for(int i : result){
            System.out.print(i + " ");
        }

    }

    //BruteForce-Approach:
    private static int[] bruteForceApproach(int[] array, int size) {
        int[] result = new int[size];

        for(int i = 0 ; i < size ; i++){
            result[i] = (array[i] * array[i]);
        }

        Arrays.sort(result);
        return result;
    }

    //Two-Pointers-Approach:
    private static int[] twoPointersApproach(int[] array, int size) {

        int[] result = new int[size];
        int startIndex = 0;
        int endIndex = size - 1;

        for(int i = size - 1 ; i>= 0 ; i--){
            if(Math.abs(array[startIndex]) > Math.abs(array[endIndex])){
                result[i] = (array[startIndex] * array[startIndex]);
                startIndex++;
            }
            else{
                result[i] = (array[endIndex] * array[endIndex]);
                endIndex--;
            }
        }
        return result;

    }
}
