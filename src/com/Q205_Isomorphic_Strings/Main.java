package com.Q205_Isomorphic_Strings;

import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> freq = new HashMap<>();
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        for(int i=0; i<s.length(); i++){
            if(freq.containsKey(arrS[i])){
                if(freq.get(arrS[i])!=arrT[i]){
                    return false;
                }
            }
            else{
                if(freq.containsValue(arrT[i])){
                    return false;
                }
                else{
                    freq.put(arrS[i],arrT[i]);
                }
            }
        }
        return true;
    }
}

/*
class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> freq = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(freq.containsKey(s.charAt(i))){
                if(freq.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }
            else{
                if(freq.containsValue(t.charAt(i))){
                    return false;
                }
                else{
                    freq.put(s.charAt(i),t.charAt(i));
                }
            }
        }
        return true;
    }
}
 */

public class Main {
    public static void main(String[] args) {
        String[] ss = {"egg","foo","paper","badc"};
        String[] ts = {"add","bar","title","baba"};
        Solution solution = new Solution();
        for(int i=0; i<ss.length; i++){
            System.out.println(solution.isIsomorphic(ss[i],ts[i]));
        }
    }
}
