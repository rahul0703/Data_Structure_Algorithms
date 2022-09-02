package Recursion;

import java.util.ArrayList;

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
}
