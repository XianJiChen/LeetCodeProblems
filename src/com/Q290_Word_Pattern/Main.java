package com.Q290_Word_Pattern;

import java.util.HashMap;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        char[] patternArr = pattern.toCharArray();
        String[] strings = s.split(" ");
        if(patternArr.length!=strings.length){
            return false;
        }
        HashMap<Character, String> map = new HashMap<Character, String>();
        String ans;
        for(int i=0; i<patternArr.length; i++){
            ans = map.get(patternArr[i]);
//            System.out.println(patternArr[i]);
//            System.out.println(ans);
//            System.out.println(strings[i]);
//            System.out.println("====");
            if(ans==null){
                if(map.containsValue(strings[i])){
                    return false;
                }
                else{
                    map.put(patternArr[i], strings[i]);
                }
            }
            else if(!ans.equals(strings[i])){
                return false;
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        String[] patterns = {"abba","abba","aaaa"};
        String[] ss = {"dog cat cat dog","dog cat cat fish","dog cat cat dog"};
        Solution solution = new Solution();
        for(int i=0; i<patterns.length; i++){
            System.out.println(solution.wordPattern(patterns[i],ss[i]));
            System.out.println("=======");
        }
    }
}
