package com.Q392_Is_Subsequence;

//1ms ver
/*
class Solution {
    public boolean isSubsequence(String s, String t) {
        char ch;
        int i;
        int j;
        for(i=0, j=0; i<t.length() && j<s.length(); i++){
            if(t.charAt(i)==s.charAt(j)) {
                j++;
            }
        }
        return (j==s.length());
    }
}
*/

//0ms ver
class Solution {
    public boolean isSubsequence(String s, String t) {
        int index=-1;
        for(int i=0;i<s.length();i++)
        {
            index=t.indexOf(s.charAt(i),index+1);
            if(index<0){
                return false;
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        String[] ss = {"abc", "axc", "abc"};
        String[] ts = {"ahbgdc","ahbgdc", "adsfasdfsbserhukiiy"};
        Solution solution = new Solution();

        for(int i=0; i<ss.length; i++){
            System.out.println(solution.isSubsequence(ss[i], ts[i]));
            System.out.println("======");
        }
    }
}
