package arrays.Day3;

import java.util.Arrays;
import java.util.Scanner;

/*
Given an array of n integers where each value represents the number of chocolates in a packet.
Each packet can have a variable number of chocolates.
There are m students, the task is to distribute chocolate packets such that:

1).Each student gets one packet.
2).The difference between the number of chocolates in the packet with maximum chocolates and packet with minimum chocolates given to the students is minimum.

return the difference.

Examples:

Input : arr[] = {7, 3, 2, 4, 9, 12, 56} , m = 3
Output: Minimum Difference is 2
Explanation:
We have seven packets of chocolates, and
we need to pick three packets for 3 students
If we pick 2, 3 and 4, we get the minimum
difference between maximum and minimum packet
sizes.

Input : arr[] = {3, 4, 1, 9, 56, 7, 9, 12} , m = 5
Output: Minimum Difference is 6
Explanation:
The set goes like 3,4,7,9,9 and the output
is 9-3 = 6

Input : arr[] = {12, 4, 7, 9, 2, 23, 25, 41,
30, 40, 28, 42, 30, 44, 48,
43, 50} , m = 7
Output: Minimum Difference is 10
Explanation:
We need to pick 7 packets. We pick 40, 41,
42, 44, 48, 43 and 50 to minimize difference
between maximum and minimum.

 */
public class ChocolateDistribution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] chocolate_packets = new int[size];

        for(int i = 0 ; i < size ; i++){
            chocolate_packets[i] = scanner.nextInt();
        }

        int students = scanner.nextInt();

        int minimum_difference = slidingWindowApproach(chocolate_packets, size, students);
        System.out.print("Minimum Difference = " + minimum_difference);

    }

    //Sliding-Window-Approach:
    private static int slidingWindowApproach(int[] chocolate_packets, int size, int students) {

        Arrays.sort(chocolate_packets);

        int difference = Integer.MAX_VALUE;
                        //If Arrays Has Only 1 Element?
        for(int i = 0 ; i <= size - students ; i++){
                //MAX-ELEMENT                         //MIN-ELEMENT
            if(chocolate_packets[i + students - 1] - chocolate_packets[i] < difference ){
                //DIFFERENCE
                difference = chocolate_packets[i + students - 1] - chocolate_packets[i];
            }
        }
        return difference;
    }

}
