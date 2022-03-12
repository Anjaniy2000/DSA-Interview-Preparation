/*
Given an array ‘arr’ of integer numbers .
where ‘arr[i]’ represents the number of pages in the ‘i-th’ book.
There are ‘m’ number of students and the task is to allocate all the books to their students.

Allocate books in such a way that:
1. Each student gets at least one book.
2. Each book should be allocated to a student.
3. Book allocation should be in a contiguous manner.

You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum.

Example:
Let’s consider ‘n=4’ (number of books ) and ‘m=2’ (number of students).
‘arr = { 10, 20, 30, 40 }’.

All possible way to allocate the ‘4’ books in ‘2’ number of students is -

10 | 20, 30, 40 - sum of all the pages of books which allocated to student-1 is ‘10’, and student-2 is ‘20+ 30+ 40 = 90’ so maximum is ‘max(10, 90)= 90’.

10, 20 | 30, 40 - sum of all the pages of books which allocated to student-1 is ‘10+ 20 = 30’, and student-2 is ‘30+ 40 = 70’ so maximum is ‘max(30, 70)= 70’.

10, 20, 30 | 40 - sum of all the pages of books which allocated to student-1 is ‘10+ 20 +30 = 60’, and student-2 is ‘40’ so maximum is ‘max(60, 40)= 60’.

So possible maximum number of pages which allocated to a single student is { 90, 70, 60 }.

But you have to return a minimum of this so return ‘min(90,70,60) =60’.

OR

Capacity To Ship Packages Within D Days.
 */
package binary_search.hard;

import java.util.Scanner;

public class BookAllocationProblem {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Number Of Books:");
        int arraySize = scanner.nextInt();

        System.out.println("Enter The No. Of Pages:");
        int[] array = new int[arraySize];
        for(int i = 0 ; i < arraySize ; i++){
            array[i] = scanner.nextInt();
        }

        System.out.println("Enter The No. Of Students:");
        int students = scanner.nextInt();

        int result = Solution(array, arraySize, students);
        System.out.println(result);
    }

    private static int Solution(int[] array, int arraySize, int students) {

        int startIndex = 0;
        int sum = 0;

        for(int i : array){
            sum = sum + i;
        }

        int endIndex = sum;
        int result = -1;

        while(startIndex <= endIndex){
            int middleIndex = startIndex + ((endIndex - startIndex) / 2);

            if(isPossibleSolution(array, arraySize, students, middleIndex)){
                result = middleIndex;
                //This Is Possible Solution.But We Want The Minimum, So We Will Go To Left Side.
                endIndex = middleIndex - 1;

                //If We Want Maximum, We Will Go To Right Side.
                //startIndex = middleIndex + 1;
            }

            else{
                //It's Not Possible Solution, And array[middleIndex - 1] < array[middleIndex], So We Have To Right Side.
                startIndex = middleIndex + 1;

                //endIndex = middleIndex - 1;
            }
        }

        return result;
    }

    private static boolean isPossibleSolution(int[] array, int arraySize, int students, int middleIndex) {

        //First Student:
        int studentCount = 1;
        int pageSum = 0;

        for(int i = 0 ; i < arraySize ; i++){

            if(pageSum + array[i] <= middleIndex){
                pageSum = pageSum + array[i];
            }

            else{
                //Create New Student.
                studentCount++;

                if(studentCount > students || array[i] > middleIndex){
                    return false;
                }
                else{
                    //Re-Initialize PageSum With 0.
                    pageSum = 0;
                    pageSum = pageSum + array[i];
                }

            }
        }

        return true;
    }

}
