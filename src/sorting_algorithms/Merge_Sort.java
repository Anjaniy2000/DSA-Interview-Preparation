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
        int startIndexOfFirstArray = startIndex;
        int startIndexOfRightArray = middleIndex + 1;
        int startIndexOfMergedArray = 0;

        while(startIndexOfFirstArray <= middleIndex && startIndexOfRightArray <= endIndex){
            if(array[startIndexOfFirstArray] <= array[startIndexOfRightArray]){
                mergedArray[startIndexOfMergedArray] = array[startIndexOfFirstArray];
                startIndexOfFirstArray++;
                startIndexOfMergedArray++;
            }
            else{
                mergedArray[startIndexOfMergedArray] = array[startIndexOfRightArray];
                startIndexOfRightArray++;
                startIndexOfMergedArray++;
            }
        }

        while(startIndexOfFirstArray <= middleIndex){
            mergedArray[startIndexOfMergedArray] = array[startIndexOfFirstArray];
            startIndexOfFirstArray++;
            startIndexOfMergedArray++;
        }

        while(startIndexOfRightArray <= endIndex){
            mergedArray[startIndexOfMergedArray] = array[startIndexOfRightArray];
            startIndexOfRightArray++;
            startIndexOfMergedArray++;
        }

        for(int i = 0, j = startIndex ; i < mergedArray.length ; i++, j++){
            array[j] = mergedArray[i];
        }

    }
}
