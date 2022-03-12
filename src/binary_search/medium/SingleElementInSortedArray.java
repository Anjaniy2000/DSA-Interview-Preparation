/*
You are given a sorted array consisting of only integers where every element appears exactly twice,
except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

Input: array = [1,1,2,3,3,4,4,8,8]
Output: 2

Input: array = [3,3,7,7,10,11,11]
Output: 10

Brute Force: XOR
Optimized: Binary Search
 */
package binary_search.medium;

import java.util.Scanner;

public class SingleElementInSortedArray {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ArraySize:");
        int arraySize = scanner.nextInt();

        int[] array = new int[arraySize];
        System.out.println("Enter The Elements:");
        for(int i = 0 ; i < arraySize ; i++){
            array[i] = scanner.nextInt();
        }

        int element = Solution(array, arraySize);
        System.out.println(element);
    }

    private static int Solution(int[] array, int arraySize) {

        int startIndex = 0;
        int endIndex = arraySize - 1;

        //Edge Cases:
        if(endIndex == 0){
            return array[0];
        }
        if(array[startIndex] != array[startIndex + 1]){
            return array[startIndex];
        }
        if(array[endIndex] != array[endIndex - 1]){
            return array[endIndex];
        }

        //Core - Logic:
        while(startIndex <= endIndex){
            int middleIndex = startIndex + ((endIndex - startIndex) / 2);

            //Element Who Is Single
            if(array[middleIndex] != array[middleIndex + 1] && array[middleIndex] != array[middleIndex - 1]){
                return array[middleIndex];
            }
            //Go To Right Side:
            else if((middleIndex % 2 == 0 && array[middleIndex] == array[middleIndex + 1]) || (middleIndex % 2 == 1 && array[middleIndex] == array[middleIndex - 1])){
                startIndex = middleIndex + 1;
            }
            //Go To Left Side:
            else{
                endIndex = middleIndex - 1;
            }
        }
        return -1;
    }
}
