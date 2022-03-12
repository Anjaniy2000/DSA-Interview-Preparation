/*
Given an array of length ‘N’, where each element denotes the position of a stall.
Now you have ‘N’ stalls and an integer ‘K’ which denotes the number of cows that are aggressive.
To prevent the cows from hurting each other,
you need to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible.
Return the largest minimum distance.

Constraints :
1 <= T <= 5
2 <= N <= 20000
2 <= C <= N
0 <= ARR[i] <= 10 ^ 9

Sample Input:
2
3 2
1 2 3
5 2
4 2 1 3 6

Output:
2
5

In the first test case, the largest minimum distance will be 2 when 2 cows are placed at positions {1, 3}.
In the second test case, the largest minimum distance will be 5 when 2 cows are placed at positions {1, 6}.
 */
package binary_search.hard;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCowsProblem {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("No. Of Stalls");
        int n = scanner.nextInt();
        System.out.println("Enter No. Of Stalls");
        int[] stalls = new int[n];
        for(int i = 0; i < n; i++){
            stalls[i] = scanner.nextInt();
        }
        System.out.println("Enter No. Of Aggressive Cows");
        int aggressive_cows = scanner.nextInt();

        int distance = Solution(stalls, n, aggressive_cows);
        System.out.println(distance);

    }

    private static int Solution(int[] stalls, int n, int aggressive_cows) {
        int distance = -1;
        int startIndex = 0;
        int endIndex = -1;
        for (int i : stalls) {
            endIndex = Math.max(endIndex, i);
        }

        while (startIndex <= endIndex) {
            int middleIndex = startIndex + (endIndex - startIndex) / 2;
            if (isPossibleSolution(stalls, n, middleIndex, aggressive_cows)) {
                distance = middleIndex;
                //Because We Want Largest(Maximum) Solution
                startIndex = middleIndex + 1;
            } else {
                endIndex = middleIndex - 1;
            }
        }
        return distance;
    }

    private static boolean isPossibleSolution(int[] stalls, int n, int middleIndex, int aggressive_cows) {
        //Sort The Array:
        Arrays.sort(stalls);
        //Fist Cow:
        int cowCount = 1;
        int position = stalls[0];

        for (int i = 0; i < n; i++) {
            if (stalls[i] - position >= middleIndex) {
                //Next Cow:
                cowCount++;
                //Re-Initialize Position:
                position = stalls[i];
            }
            if (cowCount == aggressive_cows) {
                return true;
            }
        }
        return false;
    }

}
