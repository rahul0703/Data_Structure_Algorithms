package Dynamic_Programming;

import Dynamic_Programming.ProblemExplanations.Utlity_1D_DP;
import Dynamic_Programming.ProblemExplanations.Utlity_2D_DP;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
//        int[] array = new int[n];
//        for(int i = 0; i < n; i++){
//            array[i] = scan.nextInt();
//        }
//        longestBiotonicSubsequence(array);
//        String str1 = scan.nextLine();
//        String str2 = scan.nextLine();
//        String str3 = scan.nextLine();
//        LCSIn3String(str1, str2, str3);
        friendPairingProblem(n);
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

    public static void LCSIn3String(String str1, String str2, String str3){
        Utlity_2D_DP utility = new Utlity_2D_DP();
        int answer = utility.longestCommonSubsequenceOf3Strings(str1, str2, str3);
        System.out.println("LCSIn3String : answer :: " + answer);
    }

    public static void friendPairingProblem(int n){
        Utlity_2D_DP utility = new Utlity_2D_DP();
//        int answer = utility.friendsPairingProblem(n);
        int answer = utility.friendsPairingProblemMemoization(n);
        System.out.println("friendPairingProblem : answer :: " + answer);
    }
}

