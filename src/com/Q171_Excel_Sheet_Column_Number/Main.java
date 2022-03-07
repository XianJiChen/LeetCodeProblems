package com.Q171_Excel_Sheet_Column_Number;

/*
class Solution {
    public int titleToNumber(String columnTitle) {
        char[] arr = columnTitle.toCharArray();
        int ans = 0;
        for(int i=arr.length-1, pow=0; i>=0; i--, pow++){
            ans += (int) Math.pow(26,pow) * (int) (arr[i]-64);
        }
        return ans;
    }
}
*/

class Solution {
    public int titleToNumber(String columnTitle) {
        char[] arr = columnTitle.toCharArray();
        int ans = 0;
        for(int i=arr.length-1, pow=1; i>=0; i--, pow*=26){
            ans += pow * (arr[i]-64);
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        String[] inputs = {"A","AB","ZZ"};
        Solution solution = new Solution();
        for(String input : inputs){
            System.out.println(solution.titleToNumber(input));
        }
    }
}
