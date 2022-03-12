/*
Given an array/list of length ‘N’,
where the array/list represents the boards and each element of the given array/list represents the length of each board.
Some ‘K’ numbers of painters are available to paint these boards.
Consider that each unit of a board takes 1 unit of time to paint.

You are supposed to return the area of the minimum time to get this job done of painting all the ‘N’ boards under a constraint that any painter will only paint the continuous sections of boards.

Note:   In the below figure where array/list elements are {2, 1, 5, 6, 2, 3}.
        A painter can paint blocks {5,6} or {1,5,6,2} together but not {2,5,6} or {5,6,3}.(Continuous Sub-array).

Input: array = {5 5 5 5}, painters = 2
Output: 10

Same As Book Allocation Problem.
 */
package binary_search.hard;

import java.util.Scanner;

public class PaintersPartitionProblem {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number Of Boards:");
        int arraySize = scanner.nextInt();

        System.out.println("Enter The Boards:");
        int[] array = new int[arraySize];
        for(int i = 0 ; i < arraySize ; i++){
            array[i] = scanner.nextInt();
        }

        System.out.println("Enter The No. Of Painters");
        int painters = scanner.nextInt();

        int minimumTime = Solution(array, arraySize, painters);
        System.out.println(minimumTime);
    }

    private static int Solution(int[] array, int arraySize, int painters) {
        int minimumTime = -1;
        int startIndex = 0;
        int sum = 0;
        for(int i : array){
            sum = sum + i;
        }
        int endIndex = sum;

        while(startIndex <= endIndex){
            int middleIndex = startIndex + ((endIndex - startIndex) / 2);
            if(isPossible(array, arraySize, middleIndex, painters)){
                //This Is Possible Solution.But We Want The Minimum, So We Will Go To Left Side.
                minimumTime = middleIndex;
                endIndex = middleIndex - 1;
            }
            else{
                //It's Not Possible Solution, And array[middleIndex - 1] < array[middleIndex], So We Have To Right Side.
                startIndex = middleIndex + 1;
            }
        }
        return minimumTime;
    }

    private static boolean isPossible(int[] array, int arraySize, int middleIndex, int painters) {
        //First Painter:
        int paintersCount = 1;
        int sum = 0;

        for(int i = 0 ; i < arraySize ; i++){
            if(sum + array[i] <= middleIndex){
                sum = sum + array[i];
            }
            else{
                //Create New Painter.
                paintersCount++;
                if(paintersCount > painters || array[i] > middleIndex){
                    return false;
                }
                else{
                    //Re-Initialize PageSum With 0.
                    sum = 0;
                    sum = sum + array[i];
                }
            }
        }
        return true;
    }
}
