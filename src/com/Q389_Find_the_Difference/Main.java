package com.Q389_Find_the_Difference;

/*
class Solution {
    public char findTheDifference(String s, String t) {
        int[] cntS = new int[26];
        int[] cntT = new int[26];
        for(int i=0; i<s.length(); i++) {
            cntS[s.charAt(i)-97]++;
        }
        for(int i=0; i<t.length(); i++) {
            cntT[t.charAt(i)-97]++;
        }
        for(int i=0; i<26; i++){
            if(cntS[i]!=cntT[i]){
                return (char) (i+97);
            }
        }
        return 'a';
    }
}
*/
/*
class Solution {
    public char findTheDifference(String s, String t) {
        int[] cntS = new int[26];
        int[] cntT = new int[26];
        for(int i=0; i<s.length(); i++) {
            cntS[s.charAt(i)-97]++;
        }
        for(int i=0, idx; i<t.length(); i++) {
            idx = t.charAt(i)-97;
            cntT[idx]++;
            if(cntT[idx]>cntS[idx]){
                return (char) (idx+97);
            }
        }
        for(int i=0; i<26; i++){
            if(cntS[i]!=cntT[i]){
                return (char) (i+97);
            }
        }
        return 'a';
    }
}
*/

class Solution {
    public char findTheDifference(String s, String t) {
        int ans = 0;
        for(int i=0; i<s.length(); i++) {
            ans ^= (int)(s.charAt(i));
        }
        for(int i=0, idx; i<t.length(); i++) {
            ans ^= (int)(t.charAt(i));
        }
        return (char) ans;
    }
}

public class Main {
    public static void main(String[] args) {
        String[] ss = {"abcd",""};
        String[] ts = {"abcde","y"};
        Solution solution = new Solution();
        for(int i=0; i<ss.length; i++){
            System.out.println(solution.findTheDifference(ss[i],ts[i]));
            System.out.println("=====");
        }
    }
}
