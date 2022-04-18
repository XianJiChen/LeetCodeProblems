package com.Q344_Reverse_String;

import java.util.Arrays;

class Solution {
    public void reverseString(char[] s) {
        char tmp;
        for(int i=0, j=s.length-1; i<j; i++,j--){
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        String[] inputs  = {"hello", "Hannah"};
        Solution solution = new Solution();
        char[] tmp;
        for(String string : inputs){
            tmp = string.toCharArray();
            //System.out.println(Arrays.toString(tmp));
            solution.reverseString(tmp);
            System.out.println(Arrays.toString(tmp));
            System.out.println("====");
        }
    }
}
