package sorting_algorithms;

public class Bubble_Sort {
    public static void main(String[] args){
        int[] array = {12, -1, -100, 35, 1000, 96, 256, 900, 0};
        int [] answer = sort(array, array.length);
        for(int i : answer){
            System.out.print(i + " ");
        }
    }

    //Bubble - Sort:
    private static int[] sort(int[] array, int length) {

        //Rounds:
        for(int i = 0 ; i < length - 1 ; i++){
            int temp;
            //Processing Elements Till (length - i):
            for(int j = 0 ; j < length - i - 1 ; j++){
                if(array[j] > array[j + 1]){
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
