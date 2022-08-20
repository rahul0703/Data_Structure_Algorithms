package Searching_sorting.Implementation;

public class Count_Sort {
/*
This is used to sort the number having a definite small range. Lets say, n bumber ranges from 0 to 100. here,
as range is small we can use count sort
 */
    public void countSort(int[] array, int rangeStart, int rangeEnd){
        int[] countArray = new int[rangeEnd-rangeStart+1];
        for(int i = 0; i < array.length; i++){
            int num = array[i];
            int index = num - rangeStart;
            countArray[index]++;
        }
        int iter = 0;
        for(int i = 0; i < array.length; i++){
            if(countArray[iter] > 0){
                array[i] = iter + rangeStart;
                countArray[iter]--;
                continue;
            }
            while(countArray[iter] <= 0){
                iter++;
            }
            array[i] = iter + rangeStart;
            countArray[iter]--;
        }

    }
}
