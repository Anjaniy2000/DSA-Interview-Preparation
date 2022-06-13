package arrays.easy;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueNumberOfOcc {
    public static void main(String[] args) {
        int[] array = {1,2,2,1,1,3};

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int element: array){
            map.put(element, map.getOrDefault(element, 0) + 1);
        }

        HashSet<Integer> set = new HashSet<>(map.values());

        if(map.size() == set.size()){
            System.out.print("True");
        }
        else{
            System.out.print("False");
        }
    }
}
