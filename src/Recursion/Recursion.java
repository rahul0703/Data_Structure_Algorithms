package Recursion;

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
}
