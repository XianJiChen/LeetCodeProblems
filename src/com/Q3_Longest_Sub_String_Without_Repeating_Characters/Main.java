package com.Q3_Longest_Sub_String_Without_Repeating_Characters;
import java.lang.reflect.Array;
import java.util.*;
//My own first version
/*
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int cnt=0;
        int max=0;
        ArrayList<Character> passed = new ArrayList<Character>();
        for(char ch:s.toCharArray()){
//            System.out.println("----------------");
//            System.out.println(ch);
            if(passed.contains((Character) ch)){
//                System.out.println("In");
                passed.subList(0, passed.indexOf((Character) ch)+1).clear();
                passed.add((Character) ch);
                cnt = passed.size();
            }
            else{
//                System.out.println("Not In");
                passed.add((Character) ch);
                cnt++;
                max = (cnt > max) ? cnt : max;
            }
//            System.out.println(passed.toString());
//            System.out.printf("max = %d\n", max);
        }
        return max;
    }
}
*/
//My own second version
/*
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        char t;
        Map<Character,Integer> cache = new HashMap<Character,Integer>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            t = s.charAt(i);
            if(cache.containsKey(t)){
                j = Math.max(j, cache.get(t));
                //System.out.println("NOT IN");
            }
//            else{
//                System.out.println("IN");
//            }
            cache.put(t,i+1);
            //System.out.println(cache.toString());
            result = Math.max(result, i - j + 1);
        }
        return result;
    }
}
*/
//LeetCode Solution
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int[] cache = new int[256];
        for (int i = 0, j = 0; i < s.length(); i++) {
            j = (cache[s.charAt(i)] > 0) ? Math.max(j, cache[s.charAt(i)]) : j;
            cache[s.charAt(i)] = i + 1;
            result = Math.max(result, i - j + 1);
            //if(s.length()-j<result) break;
        }
        return result;
    }
}
public class Main {
    public static void main(String[] args){
        String[] inputs = {"abcabcbb","bbbbb","pwwkew","aabaab!bb"};
        int[] arr = new int[256];
        for(int i=0; i<256; i++) arr[i] = i;

        Solution tt = new Solution();
        for(String str:inputs){
            System.out.println("==================");
            System.out.println(tt.lengthOfLongestSubstring(str));
        }
//        System.out.println(inputs[0].charAt(0));
//        System.out.println(arr[inputs[0].charAt(0)]);
        //System.out.println(inputs[0].charAt(0));
    }
}
