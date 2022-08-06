package Searching_sorting;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = scanner.nextInt();
        }

        searching_sorting(array);
    }

    public static void searching_sorting(int[] array){
        Utility utility = new Utility();
        int answer = utility.majorityElement(array);
        System.out.println("searching_sorting : Majority Element :: "  + answer);
    }

    public static void maxGapBwAdEleInSrtdFrm(int[] array){
        Utility utility = new Utility();

    }
}
