/*
Implementation of Binary Search.
 */
package binary_search;

import java.util.Scanner;

public class Implementation {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Size Of An Array:");
        int arraySize = scanner.nextInt();
        System.out.println("Enter The Elements:");
        int[] array = new int[arraySize];
        for(int i = 0 ; i < arraySize ; i++){
            array[i] = scanner.nextInt();
        }
        System.out.println("Enter A Key:");
        int key = scanner.nextInt();

        int index = binarySearch(array, arraySize, key);
        if(index == -1){
            System.out.println("Not Found");
        }
        else{
            System.out.println(index);
        }

    }

    private static int binarySearch(int[] array, int arraySize, int key) {

        int startIndex = 0;
        int endIndex = arraySize - 1;

        while(startIndex <= endIndex){

            //Optimization To Avoid Problems Of Integer Range
            int middleIndex = startIndex + ((endIndex - startIndex) / 2);
//            int middleIndex = (startIndex + endIndex) / 2;

            if(key == array[middleIndex]){
                return middleIndex;
            }

            else if(key > array[middleIndex]){
                startIndex = middleIndex + 1;
            }

            else{
                endIndex = middleIndex - 1;
            }
        }

        return -1;
    }
}
