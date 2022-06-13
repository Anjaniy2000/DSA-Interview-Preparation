package arrays.easy;

/*
Given an integer array, find the contiguous sub-array (containing at least one number) which has the largest sum and return its sum.

A sub-array is a contiguous part of an array.

Examples:
Input: array = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Input: array = [1]
Output: 1

Input: array = [5,4,-1,7,8]
Output: 23

 */

import java.util.Scanner;

public class MaximumSubArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        
        int[] array = new int[size];
        for(int i = 0 ; i < size ; i++){
            array[i] = scanner.nextInt();
        }
        
//        int result = bruteForceApproach(array, size);
//        System.out.print(result);

        int result = kadaneAlgorithmApproach (array, size);
        System.out.print(result);
    }

    //BruteForce-Approach:
    private static int bruteForceApproach(int[] array, int size) {
        int MAX_SUM = Integer.MIN_VALUE;
        for(int i = 0 ; i < size ; i++){
            int currentSum = 0;
            for(int j = i ; j < size ; j++){
                currentSum = currentSum + array[j];
                if(currentSum > MAX_SUM){
                    MAX_SUM = currentSum;
                }
            }
        }

        return MAX_SUM;
    }

    //Kadane's Algorithm-Approach(With Negative Elements Too):
    private static int kadaneAlgorithmApproach(int[] array, int size) {
        int maxSum = array[0];
        int currentSum = array[0];
        for(int i = 1 ; i < size ; i++){
            if(currentSum >= 0){
                currentSum = currentSum + array[i];
            }
            else{
                currentSum = array[i];
            }

            if(currentSum > maxSum){
                maxSum = currentSum;
            }
        }
        return maxSum;
    }

}
