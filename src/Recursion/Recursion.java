package Recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Recursion {

    public ArrayList<String> getSubsequence(String str){
        if(str.length() == 0){
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }
        char ch = str.charAt(0);
        String subString = str.substring(1);

        ArrayList<String> subAns = getSubsequence(subString);
        ArrayList<String> ans = new ArrayList<>();

        for(String subAnsStr : subAns){
            ans.add(subAnsStr);
            ans.add(ch + subAnsStr);
        }
        return ans;
    }

    public ArrayList<String> getDicePath(int start, int end){
        if(start == end){
            return new ArrayList<>(Arrays.asList("\n"));
        }
        if(start > end){
            return new ArrayList<>();
        }
        ArrayList<String> ans = new ArrayList<>();
        for(int dice = 1; dice <= 6; dice++){
            ArrayList<String> subAns = getDicePath(start + dice, end);
            for(String subAnsStr : subAns){
                ans.add(subAnsStr + " " + dice);
            }
        }
        return ans;
    }

    public ArrayList<String> getMazePath(int currI, int currJ, int endI, int endJ, int n, int m){
        if(currI < 0 || currJ < 0 || currJ >= m || currI >= n){
            return new ArrayList<>();
        }
        if(currI == endI && currJ == endJ){
            return new ArrayList<>(Arrays.asList(""));
        }

        ArrayList<String> ans = new ArrayList<>();
        ArrayList<String> downAns = getMazePath(currI +1, currJ, endI, endJ, n, m);
        for(String subStr : downAns){
            ans.add("down " + subStr);
        }
        ArrayList<String> rightAns = getMazePath(currI, currJ+1, endI, endJ, n, m);
        for(String subStr : rightAns){
            ans.add("right " + subStr);
        }
        return ans;
    }
}
