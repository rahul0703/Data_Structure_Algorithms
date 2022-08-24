package Dynamic_Programming;

import Dynamic_Programming.ProblemExplanations.Utlity_1D_DP;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

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

    
}

