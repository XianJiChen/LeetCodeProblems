package com.Q409_Longest_Palindrome;


import javax.xml.transform.SourceLocator;

class Solution {
    public int longestPalindrome(String s) {
        int[] cnt = new int[52];
        int idx;
        for(char c : s.toCharArray()){
            idx = c-65;
            if(idx>25){
                idx-=6;
            }
            cnt[idx]++;
        }
        int ttlLen = 0;
        for(int c : cnt){
            if(c%2==0){
                ttlLen += c;
            }
            else if(c!=1){
                ttlLen += c-1;
            }
        }
        for(int c : cnt){
            if(c%2==1){
                ttlLen+=1;
                break;
            }
        }

        return ttlLen;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] inputs = {"abccccdd","a","bb","ccc"};
        for(String input : inputs){
            System.out.println(solution.longestPalindrome(input));
            System.out.println("-----------");
        }
    }
}
