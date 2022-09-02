package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
//        String str = scan.next();
//        getSubsequence(str);
//        int n = scan.nextInt();
//        int m = scan.nextInt();
        getMazePath(0, 0, 5, 5, 6, 6);
//        getDicePath(start, end);
    }

    public static void getSubsequence(String str){
        Recursion recursion = new Recursion();
        ArrayList<String> ans = recursion.getSubsequence(str);
        for(String strAns : ans){
            System.out.println(strAns + " ");
        }
    }

    public static void getDicePath(int start, int end){
        Recursion recursion = new Recursion();
        ArrayList<String> ans = recursion.getDicePath(start, end);
        for(String str : ans){
            System.out.println(str);
        }
    }

    public static void getMazePath(int startI, int startJ, int endI, int endJ, int n, int m){
        Recursion recursion = new Recursion();
        ArrayList<String> ans = recursion.getMazePath(startI, startJ, endI, endJ, n, m);
        for(String str : ans){
            System.out.println(str);
        }
    }
}
