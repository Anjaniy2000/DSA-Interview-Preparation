package arrays.easy;

/*
Given an array of integers and an integer target, return indices of the two numbers such that they add up to target.

You can return the answer in any order.

Examples:
Input: array = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because array[0] + array[1] == 9, we return [0, 1].

Input: array = [3,2,4], target = 6
Output: [1,2]

Input: array = [3,3], target = 6
Output: [0,1]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] array = new int[size];
        for(int i = 0 ; i < size ; i++){
            array[i] = scanner.nextInt();
        }

        int target = scanner.nextInt();

//        int[] indices = bruteForceApproach(array, size, target);
//        for (int i: indices) {
//            System.out.print(i + " ");
//        }

//        int[] indices = twoPointersApproach(array, size, target);
//        for (int i: indices) {
//            System.out.println(i + "th" + " " + "Index Of Sorted Array");
//        }

        int[] indices = HashMapApproach(array, size, target);
        for(int i : indices){
            System.out.print(i + " ");
        }

        scanner.close();

    }

    //BruteForce-Approach:
    private static int[] bruteForceApproach(int[] array, int size, int target) {
        int[] indices = new int[2];

        for(int i = 0 ; i < size ; i++){
            for (int j = i + 1 ; j < size ; j++){
                if(array[i] + array[j] == target){
                    indices[0] = i;
                    indices[1] = j;
                }
            }
        }

        return indices;
    }

    //Two-Pointers-Approach:
    private static int[] twoPointersApproach(int[] array, int size, int target) {
        int[] indices = new int[2];

        Arrays.sort(array);
        int startIndex = 0;
        int endIndex = size - 1;

        while(startIndex < endIndex){
            int sum = array[startIndex] + array[endIndex];

            if(sum == target){
                indices[0] = startIndex;
                indices[1] = endIndex;
                break;
            }
            else if(sum < target){
                startIndex++;
            }
            else{
                endIndex--;
            }
        }
        return indices;
    }

    //HashMap-Approach:
    private static int[] HashMapApproach(int[] array, int size, int target) {
        int[] indices = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < size ; i++){
            if(map.containsKey(target - array[i])){
                indices[0] = i;
                indices[1] = map.get(target - array[i]);
            }
            else{
                map.put(array[i], i);
            }
        }
        return indices;
    }
}
