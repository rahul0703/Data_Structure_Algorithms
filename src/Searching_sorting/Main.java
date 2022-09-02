package Searching_sorting;

import Searching_sorting.Implementation.Binary_search;
import Searching_sorting.Implementation.Count_Sort;
import Searching_sorting.Implementation.Median_In_Integer_Stream;
import Searching_sorting.Implementation.Quick_sort;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array1 = new int[n];
        for(int i = 0; i < n; i++){
            array1[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] array2 = new int[m];
        for(int i = 0; i < m; i++){
            array2[i] = scanner.nextInt();
        }
//        int x = scanner.nextInt();

//        binarySearch2(array, x);
//        missingAndRepeatingNumberInArray(array);
//        combintionOf4SumEuqalsX(array, x);
//        quicksort(array);
//        countSort(array);
//        medianInStream();
//        arrayProductExceptSelf(array);
        findPairXYwithPowerDiff(array1, array2);
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

    public static void binarySearch2(int[] array, int num){
        Binary_search binarySearch = new Binary_search();
        int answer = binarySearch.binarySearch2(array, num);
        System.out.println("binarySearch2 : answer :: " + answer);
    }

    public static void findUniquePairWithGivenDiffInArr(int[] array, int num){
        Utility utility = new Utility();
        int answer = utility.findUniquePairWithGivenDiffInArr(array, num);
        System.out.println("findUniquePairWithGivenDiffInArr : answer :: " + answer);
    }

    public static void combintionOf4SumEuqalsX(int[] nums, int target){
        Utility utility = new Utility();
        ArrayList<String> answer = utility.combintionOf4SumEuqalsX(nums, target);
        System.out.println("combintionOf4SumEuqalsX : combinations :: ");
        for(String subAns : answer){
            System.out.println(subAns);
        }
    }

    public static void quicksort(int[] array){
        Quick_sort quickSort = new Quick_sort();
        quickSort.quickSort3Way(array, 0, array.length-1);
        System.out.println();
        for(int num : array){
            System.out.print(num + " ");
        }
    }

    public static void countSort(int[] array){
        Count_Sort countSort = new Count_Sort();
        countSort.countSort(array, 1, 4);
        for(int num : array){
            System.out.print(num + " ");
        }
    }

    public static void medianInStream(){
        Median_In_Integer_Stream medianInStreamArray = new Median_In_Integer_Stream();
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < 10; i++){
            int num = scan.nextInt();
            medianInStreamArray.addNum(num);
            System.out.println(medianInStreamArray.findMedian());
        }
    }

    public static void arrayProductExceptSelf(int[] nums){
        Utility utility = new Utility();
        int[] answer = utility.productOfArrayExpectSelf(nums);

        for(int i = 0; i < answer.length; i++){
            System.out.print(answer[i] + " ");
        }
        System.out.println();
    }

    public static void findPairXYwithPowerDiff(int[] array1, int[] array2){
        Utility utility = new Utility();
        int answer = utility.findPairXYwithPowerDiff(array1, array2);
        System.out.println("findPairXYwithPowerDiff : answer :: " + answer);
    }
}
