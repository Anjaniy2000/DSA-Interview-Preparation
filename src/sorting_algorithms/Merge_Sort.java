package sorting_algorithms;

public class Merge_Sort {
    public static void main(String[] args){
        int[] array = {12, -1, -100, 35, 1000, 96, 256, 900, 0};
        int [] answer = sort(array, array.length);
        for(int i : answer){
            System.out.print(i + " ");
        }
    }

    private static int[] sort(int[] array, int length) {
        int startIndex = 0;
        int endIndex = length - 1;
        int middleIndex = startIndex + (endIndex - startIndex) / 2;
        divide(array, startIndex, middleIndex);
        divide(array, middleIndex + 1, endIndex);
        merge(array, startIndex, middleIndex, endIndex);
    }

    private static void divide(int[] array, int startIndex, int endIndex) {


    }
}
