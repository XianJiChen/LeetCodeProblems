package com.Q541_Reverse_String_II;


//string builder/ char array
class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i += 2 * k) {
            if (i + k >= s.length()) {
                for (int j = s.length() - 1; j >= i; j--) {
                    sb.append(s.charAt(j));
                }
            } else {
                for (int j = i + k - 1; j >= i; j--) {
                    sb.append(s.charAt(j));
                }
                sb.append(s.substring(i+k, Math.min(i+2*k, s.length())));
            }
        }
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        String[] ss = {"abcdefg", "abcd"};
        int[] ks = {2, 2};

        Solution solution = new Solution();
        for(int i=0; i<ss.length; i++){
            System.out.println(solution.reverseStr(ss[i],ks[i]));
            System.out.println("===================");
        }
    }
}
