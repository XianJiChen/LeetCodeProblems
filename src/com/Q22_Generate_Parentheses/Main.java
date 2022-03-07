package com.Q22_Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> ans = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        ans.clear();
        GP("", n, 0, 0);
        return ans;
    }
    public void GP(String str, int n, int l, int r){
        if (r==n) ans.add(str);
        else{
            if(l<n) GP(str+"(", n,l+1, r);
            if(l>r)GP(str+")", n, l,r+1);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] inputs = {3,1};
        Solution tt = new Solution();
        for(int input:inputs){
            for(String str:tt.generateParenthesis(input)) System.out.println(str);
            System.out.println("===============");
        }
    }
}
