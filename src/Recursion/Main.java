package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        getSubsequence(str);
    }

    public static void getSubsequence(String str){
        Recursion recursion = new Recursion();
        ArrayList<String> ans = recursion.getSubsequence(str);
        for(String strAns : ans){
            System.out.println(strAns + " ");
        }
    }
}
