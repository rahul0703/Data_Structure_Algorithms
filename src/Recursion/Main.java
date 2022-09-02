package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
//        String str = scan.next();
//        getSubsequence(str);
        int start = scan.nextInt();
        int end = scan.nextInt();
        getDicePath(start, end);
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
}
