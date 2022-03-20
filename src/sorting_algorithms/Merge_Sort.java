package sorting_algorithms;

public class Merge_Sort {
    public static void main(String[] args){
        int[] array = {12, -1, -100, 35, 1000, 96, 256, 900, 0};
        divide(array, 0, array.length - 1);
        for(int i : array){
            System.out.print(i + " ");
        }
    }

    private static void divide(int[] array, int startIndex, int endIndex) {

        //Base Case:
        if(startIndex >= endIndex){
            return;
        }

        int middleIndex = startIndex + (endIndex - startIndex) / 2;
        divide(array, startIndex, middleIndex);
        divide(array, middleIndex + 1, endIndex);
        conquer(array, startIndex, middleIndex, endIndex);
    }

    private static void conquer(int[] array, int startIndex, int middleIndex, int endIndex) {
        int[] mergedArray = new int[endIndex - startIndex + 1];
        int index1 = startIndex;
        int index2 = middleIndex + 1;
        int index3 = 0;

        while(index1 <= middleIndex && index2 <= endIndex){
            if(array[index1] <= array[index2]){
                mergedArray[index3] = array[index1];
                index1++;
                index3++;
            }
            else{
                mergedArray[index3] = array[index2];
                index2++;
                index3++;
            }
        }

        while(index1 <= middleIndex){
            mergedArray[index3] = array[index1];
            index1++;
            index3++;
        }

        while(index2 <= endIndex){
            mergedArray[index3] = array[index2];
            index2++;
            index3++;
        }

        for(int i = 0, j = startIndex ; i < mergedArray.length ; i++, j++){
            array[j] = mergedArray[i];
        }

    }
}
