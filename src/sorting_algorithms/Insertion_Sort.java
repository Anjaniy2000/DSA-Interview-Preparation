package sorting_algorithms;

public class Insertion_Sort {

    public static void main(String[] args){
        int[] array = {12, -1, -100, 35, 1000, 96, 256, 900, 0};
        int [] answer = sort(array, array.length);
        for(int i : answer){
            System.out.print(i + " ");
        }
    }

    //Insertion - Sort:
    private static int[] sort(int[] array, int length) {

        //Rounds:
        for(int i = 2 ; i < length ; i++){
            //Current - Element:
            int currentElement = array[i];
            //Previous Sub Array:(i - 1 To 0)
            int j = i - 1;
            for( ; j >= 0 ; j--){
                //Current Element Is Smaller Than array[j]:
                if(currentElement < array[j]){
                    //Shift Ahead:
                    array[j + 1] = array[j];
                }else break;
            }
            //Put Element At The Right Place:
            array[j + 1] = currentElement;
        }
        return array;
    }
}
