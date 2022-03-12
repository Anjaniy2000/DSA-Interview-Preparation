package sorting_algorithms;


public class Selection_Sort {

    public static void main(String[] args){
        int[] array = {12, -1, -100, 35, 1000, 96, 256, 900, 0};
        int [] answer = sort(array, array.length);
        for(int i : answer){
            System.out.print(i + " ");
        }
    }

    //Selection - Sort:
    private static int[] sort(int[] array, int length) {

        for(int i = 0 ; i < length - 1 ; i++){
            int temp;
            for(int j = i + 1; j < length ; j++){
                if(array[j] < array[i]){
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }
}
