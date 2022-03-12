/*
First and Last Position of an Element In Sorted Array.
Or
First/Last Occurrence of an Element in Sorted Array.

Constraints:
1 <= T <= 100
1 <= N <= 5000
0 <= K <= 10^5
0 <= ARR[i] <=10^5

Sample Input 1:
2
6 3
0 5 5 6 6 6
8 2
0 0 1 1 2 2 2 2

Sample Output 1:
-1 -1
4 7

Sample Input 2:
2
4 0
0 0 0 0
1 2
2

Sample Output 2:
0 3
0 0

 */
package binary_search.easy;

import java.util.ArrayList;
import java.util.Scanner;

public class FirstOccAndLastOccOfElementInArray {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Size Of An Array:");
        int arraySize = scanner.nextInt();

        System.out.println("Enter The Elements:");
        int[] array = new int[arraySize];
        for(int i = 0 ; i < arraySize ; i++){
            array[i] = scanner.nextInt();
        }

        System.out.println("Enter K:");
        int k = scanner.nextInt();

        ArrayList<Integer> occurrences = Solution(array, arraySize, k);
        System.out.println(occurrences);
    }

    private static ArrayList<Integer> Solution(int[] array, int arraySize, int k) {
        ArrayList<Integer> occurrences = new ArrayList<>();
        occurrences.add(FirstOcc(array, arraySize, k));
        occurrences.add((LastOcc(array,arraySize, k)));
        return occurrences;
    }

    /*  Find The First Occurrence(We Need Leftmost Occurrence,
        So We Need To Search In Left Part After Every Successful Iteration */
    private static Integer FirstOcc(int[] array, int arraySize, int k) {

        int startIndex = 0;
        int endIndex = arraySize - 1;
        int firstOcc = -1;

        while(startIndex <= endIndex){
            int middleIndex = (startIndex + endIndex) / 2;

            if(k == array[middleIndex]){
                firstOcc = middleIndex;
                endIndex = middleIndex - 1;
            }

            if(k < array[middleIndex]){
                endIndex = middleIndex - 1;
            }

            if(k > array[middleIndex]){
                startIndex = middleIndex + 1;
            }
        }

        return firstOcc;
    }

    /*  Find The Last Occurrence(We Need Rightmost Occurrence,
        So We Need To Search In Right Part After Every Successful Iteration */
    private static Integer LastOcc(int[] array, int arraySize, int k) {

        int startIndex = 0;
        int endIndex = arraySize - 1;
        int lastOcc = -1;

        while(startIndex <= endIndex){
            int middleIndex = (startIndex + endIndex) / 2;

            if(k == array[middleIndex]){
                lastOcc = middleIndex;
                startIndex = middleIndex + 1;
            }

            if(k < array[middleIndex]){
                endIndex = middleIndex - 1;
            }

            if(k > array[middleIndex]){
                startIndex = middleIndex + 1;
            }
        }

        return lastOcc;
    }
}
