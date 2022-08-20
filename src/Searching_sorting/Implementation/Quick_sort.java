package Searching_sorting.Implementation;

public class Quick_sort {

    public void quickSort3Way(int[] array, int start, int end){
        if(start > end || end == start){
            return;
        }
        if(end - start == 1){
            if(array[start] > array[end]){
                swap(array, start, end);
            }
            return;
        }
        int pointer = array[start];
        int i = start;
        int j = start;
        int iter = start+1;
        while(iter <= end){
            if(array[iter] > pointer){
                iter++;
                continue;
            }
            if(array[iter] == pointer){
                j++;
                swap(array, j, iter);
                iter++;
                continue;
            }
            if(array[iter] < pointer){
                j++;
                swap(array, j, iter);
                i++;
                swap(array, i, j);
                iter++;
            }
        }
        swap(array, start, i);
        quickSort3Way(array, start, i);
        quickSort3Way(array, j+1, end);
    }

    public void swap(int[]array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
