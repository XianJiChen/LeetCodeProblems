package com.Q14_Longest_Common_Prefix;

import java.util.Arrays;

//0ms 100% ver
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(int index=1;index<strs.length;index++){
            while(strs[index].indexOf(prefix) != 0){
                prefix=prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }
}

//2ms 49.43%  ver...QQ
/*
class Solution {
    public String longestCommonPrefix(String[] strs) {
        boolean print = false;
        int max_len =0;
        int strs_len = strs.length;
        int[] strs_lens = new int[strs_len];
        for(int i=0; i<strs_len; i++){
            strs_lens[i] = strs[i].length();
            if(strs_lens[i]>max_len) max_len = strs_lens[i];
        }
        if(print){
            System.out.println("<<<<<<<<<<<<<<");
            for(int len:strs_lens){
                System.out.println(len);
            }
            System.out.println(">>>>>>>>>>>>>>");
        }
        char[][] arr = new char[strs_len][max_len];
        for(int i=0; i< strs_len; i++) arr[i] = strs[i].toCharArray();
        if(max_len == 0) return "";
        else{
            int idx = 0;
            char tmp = 'a';
            for(int i=0; ; i++){
                if(print)System.out.println(idx);
                if(print)System.out.println(i);
                if(idx>=strs_lens[i]) {
                    if(print) System.out.println("case1");
                    break;
                }
                else if(i==0) {
                    if(print) System.out.println("case2");
                    tmp = arr[i][idx];
                }
                else if(arr[i][idx]!=tmp) {
                    if(print) System.out.println("case3");
                    break;
                }
                if(i==strs_len-1){
                    if(print) System.out.println("case4");
                    i=-1;
                    idx++;
                }
                if(print)System.out.println("--------------");
            }
            return strs[0].substring(0,idx);
        }
    }
}
*/

// 172ms 5.15% ver  ...
/*
class Solution {
    public String longestCommonPrefix(String[] strs) {
        char tmp= (strs[0].isEmpty()) ? ' ' : strs[0].charAt(0);
        int idx=0;
        int len = strs.length-1;
        System.out.println(len);
        System.out.println("<<<<<<<<");
        for(int i=0; ; i++){
            System.out.println(idx);
            System.out.println(i);
            if(idx>=strs[i].length()) {
                System.out.println("case1");
                break;
            }
            else if(i==0) {
                System.out.println("case2");
                tmp = strs[i].charAt(idx);
            }
            else if(strs[i].charAt(idx)!=tmp) {
                System.out.println("case3");
                break;
            }
            if(i==len){
                System.out.println("case4");
                i=-1;
                idx++;
            }
            System.out.println("--------------");
        }
        if(tmp==' ') return "";
        else return strs[0].substring(0,idx);
    }
}
*/

public class Main {
    public static void main(String[] args) {
        String[][] inputs = {{"flower","flow","flight"}, {"dog","racecar","car"},{"a"},{""}};
        Solution tt = new Solution();

        for(String[] input:inputs){
            System.out.println(tt.longestCommonPrefix(input));
            System.out.println("==================");
        }

        //System.out.println(tt.longestCommonPrefix(inputs[2]));
    }
}
