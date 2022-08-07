package Searching_sorting;

import Searching_sorting.Implementation.Binary_search;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = scanner.nextInt();
        }
        int x = scanner.nextInt();

        binarySearch(array, x);
//        missingAndRepeatingNumberInArray(array);
    }

    public static void searching_sorting(int[] array){
        Utility utility = new Utility();
        int answer = utility.majorityElement(array);
        System.out.println("searching_sorting : Majority Element :: "  + answer);
    }

    public static void maxGapBwAdEleInSrtdFrm(int[] array){
        Utility utility = new Utility();
        int answer = utility.maxGapBwAdEleInSrtdFrm(array);
        System.out.println("maxGapBwAdEleInSrtdFrm : maximum gap :: " + answer);
    }

    public static void missingAndRepeatingNumberInArray(int[] array){
        Utility utility = new Utility();
        ArrayList<Integer> answer = utility.missingAndRepeatingNumberInArray(array);
        System.out.println("missingAndRepeatingNumberInArray : missing number :: " + answer.get(0) + ", repeating number :: "+ answer.get(1));
    }

    public static void binarySearch(int[] array, int num){
        Binary_search binarySearch = new Binary_search();
        int answer = binarySearch.binarySearch1(array,num);
        System.out.println("binarySearch : answer :: " + answer);
    }
}
