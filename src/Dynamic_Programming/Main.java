package Dynamic_Programming;

import Dynamic_Programming.ProblemExplanations.Utlity_1D_DP;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = scan.nextInt();
        }
        longestBiotonicSubsequence(array);
    }

    public static void uglyNumbers(int n){
        Utlity_1D_DP utility = new Utlity_1D_DP();
        boolean answer = utility.uglyNumber(n);
        System.out.println("uglyNumbers : answer :: " + answer);
    }

    public static void nthUglyNumber(int n, int[] array){
        Utlity_1D_DP utility = new Utlity_1D_DP();
        int answer = utility.findNthUglyNumber(array, n);
        System.out.println("nthUglyNumber : answer :: " + answer);
    }

    public static void longestBiotonicSubsequence(int[] array){
        Utlity_1D_DP utility = new Utlity_1D_DP();
        int answer = utility.longestBiotonicSubsequence(array);
        System.out.println("longestBiotonicSubsequence : answer :: " + answer);
    }
}

