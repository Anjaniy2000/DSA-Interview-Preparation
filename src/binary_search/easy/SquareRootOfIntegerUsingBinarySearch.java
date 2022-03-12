/*
Given a non-negative integer number, compute and return the square root of number.

Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

Input: number = 4
Output: 2

Input: number = 36
Output: 6

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 */
package binary_search.easy;

import java.util.Scanner;

public class SquareRootOfIntegerUsingBinarySearch {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter An Integer");
        int number = scanner.nextInt();

        int squareRoot = Solution(number);
        System.out.println(squareRoot);
    }

    private static int Solution(int number) {
        int startIndex = 0;
        int endIndex = number;
        int squareRoot = -1;

        while(startIndex < endIndex){

            long middleIndex = (startIndex + endIndex) / 2;
            //To Avoid Integer Overflow Situation.
            long square = middleIndex * middleIndex;

            if(square == number){
                squareRoot = (int)middleIndex;
                return squareRoot;
            }

            if(square > number){
                endIndex = (int)middleIndex - 1;
            }

            if(square < number){
                squareRoot = (int)middleIndex;
                startIndex = (int)middleIndex + 1;
            }
        }

        return squareRoot;
    }
}
