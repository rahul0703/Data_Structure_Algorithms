package Searching_sorting.Implementation;

public class Radix_Sort {
    public void radixSort(int[] array, int n){
        int max = Integer.MIN_VALUE;
        for(int num : array){
            max = Math.max(max, num);
        }

        int exp = 1;
        while(exp <= max){
            countSort(array, exp);
            exp = 10 * exp;
        }
    }

    public void countSort(int[] array, int exponent){
        int[] countArray = new int[10];
        int[] ans = new int[array.length];
        for(int i = 0; i < array.length; i++){
            countArray[array[i] / exponent % 10]++;
        }
        for(int i= 1; i < countArray.length; i++){
            countArray[i] = countArray[i] + countArray[i-1];
        }

        for(int i = 0; i < array.length; i++){
            int index = countArray[array[i] / exponent % 10] - 1;
            ans[index] = array[i];
            countArray[array[i] / exponent % 10]--;
        }

        for(int i = 0; i < array.length; i++){
            array[i] = ans[i];
        }
    }
}
