package arrays.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
//        int[] array = {3,2,3,1,2,4,5,5,6};
//        int k = 4;
//
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//
//        for(int i = 0 ; i < k ; i++){
//            queue.add(array[i]);
//        }
//
//        for(int i = k ; i < array.length ; i++){
//            if(array[i] > queue.peek()){
//                queue.poll();
//                queue.add(array[i]);
//            }
//        }
//
//        System.out.print(queue.peek());
//
        String string = "book";
        String s1 = string.substring(0, string.length() / 2).toLowerCase();
        String s2 = string.substring(string.length() / 2, string.length());

        System.out.print(s2);


    }
}
