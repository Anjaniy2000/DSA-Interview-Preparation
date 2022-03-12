/*
Search A Given Element In Sorted Rotated Array With Duplicate Values.

Input: array = [2,5,6,0,0,1,2], key = 0
Output: true

Input: array = [2,5,6,0,0,1,2], target = 3
Output: false
 */
package binary_search.medium;

import java.util.Scanner;

public class SearchInSortedRotatedArrayAdvanced {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Size Of An Array:");
        int arraySize = scanner.nextInt();

        System.out.println("Enter The Elements:");
        int[] array = new int[arraySize];
        for(int i = 0 ; i < arraySize ; i++){
            array[i] = scanner.nextInt();
        }

        System.out.println("Enter A Key");
        int key = scanner.nextInt();

        boolean isPresent = Solution(array, arraySize, key);
        System.out.println(isPresent);
    }

    private static boolean Solution(int[] array, int arraySize, int key) {

        int startIndex = 0;
        int endIndex = arraySize - 1;

        while(startIndex <= endIndex){
            int middleIndex = startIndex + ((endIndex - startIndex) / 2);

            if(array[middleIndex] == key){
                return true;
            }

            //If Left Part Is Sorted:
            if(array[middleIndex] > array[startIndex]){
                if(key < array[middleIndex] && key >= array[startIndex]){
                    //Left:
                    endIndex = middleIndex;
                }
                else{
                    //Right:
                    startIndex = middleIndex + 1;
                }
            }
            //If Right Part Is Sorted:
            else if(array[middleIndex] < array[startIndex]){
                  //Right                                  //array[endIndex]
                if(key > array[middleIndex] && key < array[startIndex]){
                    startIndex = middleIndex + 1;
                }
                else{
                    //Left:
                    endIndex = middleIndex;
                }
            }
            //To Avoid Duplicates + When We Are Not Sure That On Which Part Our Value Is Present:
            // Such As array[startIndex] == array[middleIndex] == array[endIndex].
            else{
                startIndex++;
            }
        }

        return false;
    }
}
