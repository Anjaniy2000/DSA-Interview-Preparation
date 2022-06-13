/*
Given an integer array sorted in non-decreasing order,
remove the duplicates in-place such that each unique element appears only once.
The relative order of the elements should be kept the same.

Input: array = [0,0,1,1,1,2,2,3,3,4]
Output: 5, array = [0,1,2,3,4,_,_,_,_,_]
 */

package arrays.easy;

import java.util.Scanner;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];

        for(int i = 0 ; i < size ; i++){
            array[i] = scanner.nextInt();
        }

        int removedElements = solution(array, size);

        System.out.println("No. Of Elements Removed Are: " + removedElements);
        scanner.close();
    }
    //Direct - Approach:
    private static int solution(int[] array, int size) {
        int lastIndex = 0;
        for(int i = 1 ; i < size ; i++){
            if(array[i] != array[lastIndex]){
                array[lastIndex + 1] = array[i];
                lastIndex++;
            }
        }
//        for (int element :
//                array) {
//            System.out.print(element + " ");
//        }
        return lastIndex + 1;
    }
}
