package com.Q482_License_Key_Formatting;

import java.util.Locale;

class Solution {
    public String licenseKeyFormatting(String s, int k) {

        s = s.replaceAll("-","").toUpperCase(Locale.ROOT);
        StringBuilder sb = new StringBuilder(s);
        s = sb.reverse().toString();
        sb.setLength(0);
        //sb = new StringBuilder();
        int i=0;
        while(i+k<s.length()){
            sb.append(s.substring(i,i+k));
            sb.append("-");
            i = i+k;
        }
        sb.append(s.substring(i,s.length()));
        return sb.reverse().toString();
    }
}

public class Main {
    public static void main(String[] args) {
        String[] ss = {"5F3Z-2e-9-w", "2-5g-3-J"};
        int[] ks = {4,2};
        Solution solution = new Solution();
        for(int i=0; i<ss.length; i++){
            System.out.println(solution.licenseKeyFormatting(ss[i],ks[i]));
            System.out.println("=======");
        }
    }
}
