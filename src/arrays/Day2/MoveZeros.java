package arrays.Day2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
Given an integer array, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Examples:
Input: array = [0,1,0,3,12]
Output: [1,3,12,0,0]

Input: array = [0]
Output: [0]

 */
public class MoveZeros {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int[] array = new int[size];
        for(int i = 0 ; i < size ; i++){
            array[i] = scanner.nextInt();
        }

//        Integer[] result = bruteForceApproachOne(array, size);
//        for (int i : result) {
//            System.out.print(i + " ");
//        }

//        int[] result = bruteForceApproachSecond(array, size);
//        for (int i : result) {
//            System.out.print(i + " ");
//        }

        int[] result = twoPointersApproach(array, size);
        for (int i : result) {
            System.out.print(i + " ");
        }



    }

    //Two-Pointers-Approach:
    private static int[] twoPointersApproach(int[] array, int size) {
        int j = 0;
        for(int i = 0 ; i < size ; i++){
            if(array[i] != 0){
                if(array[j] != 0){
                    j++;
                }
                else{
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    j++;
                }
            }
        }
        return array;

    }


    //BruteForce-Approach(1st[If Order Doesn't Matters]):
    private static Integer[] bruteForceApproachOne(Integer[] array, int size) {
        Arrays.sort(array, Collections.reverseOrder());
        return array;
    }

    //BruteForce-Approach(2nd[If Order Matters]):
    private static int[] bruteForceApproachSecond(int[] array, int size) {
        int[] tempArray = new int[size];
        int tempIndex = 0;
        for(int i = 0 ; i < size ; i++){
            if(array[i] != 0){
                tempArray[tempIndex] = array[i];
                tempIndex++;
            }
        }
        return tempArray;
    }


}
