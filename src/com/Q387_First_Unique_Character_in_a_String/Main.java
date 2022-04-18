package com.Q387_First_Unique_Character_in_a_String;

import java.util.*;


//36ms ver
/*
class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> cnt = new HashMap<>();

        char key;
        for(int i=0, idx; i<s.length(); i++){
            key = s.charAt(i);
            if(cnt.containsKey(key)){
                cnt.put(key, cnt.get(key)+1);
            }
            else{
                cnt.put(key,1);
            }
        }

        for(int i=0, idx; i<s.length(); i++){
            key = s.charAt(i);
            if(cnt.get(key)==1){
                return i;
            }
        }
        return -1;
    }
}

 */


class Solution {
    public int firstUniqChar(String s) {
        int[] cnt = new int[26];
        for(int i=0, idx; i<s.length(); i++) {
            cnt[s.charAt(i)-97]++;
        }
        int first = s.length();
        for(int i=0, idx; i<s.length(); i++) {
            if(cnt[s.charAt(i)-97]==1){
                return i;
            }
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        String[] inputs = {"leetcode","loveleetcode","aabb"};
        Solution solution = new Solution();
        for(String input : inputs){
            System.out.println(solution.firstUniqChar(input));
            System.out.println("======");
        }
    }
}
