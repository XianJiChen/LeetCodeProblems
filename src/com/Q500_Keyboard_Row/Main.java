package com.Q500_Keyboard_Row;

import java.util.*;

//0ms ver
/*
class Solution {
    private HashMap<Character, Integer> lines = new HashMap<Character,Integer>();

    private boolean isSameRow(String str){
        for(int i=1; i<str.length(); i++){
            if(lines.get(str.charAt(i-1))!=lines.get(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public String[] findWords(String[] words) {
        String str = "qwertyuiopQWERTYUIOP";
        for(int i=0; i<str.length(); i++){
            lines.put(str.charAt(i),1);
        }
        str = "asdfghjklASDFGHJKL";
        for(int i=0; i<str.length(); i++){
            lines.put(str.charAt(i),2);
        }
        str = "zxcvbnmZXCVBNM";
        for(int i=0; i<str.length(); i++){
            lines.put(str.charAt(i),3);
        }

        List<String> ans = new LinkedList<String>();
        for (String word : words){
            if(isSameRow(word)){
                ans.add(word);
            }
        }
        String[] aa = new String[ans.size()];
        for(int i=0; i<aa.length; i++){
            aa[i] = ans.get(i);
        }
        return aa;
    }
}

 */
//0ms ver
class Solution {
    public String[] findWords(String[] words) {
        int[] rows = {2,3,3,2,1,2,2,2,1,2,2,2,3,3,1,1,1,1,2,1,1,3,1,3,1,3};
        List<String> list = new ArrayList<>();
        for(String a: words){
            String s = a.toLowerCase();
            boolean isValid = true;
            int row = rows[s.charAt(0)-'a'];
            for(int i=1; i<s.length();i++){
                if(rows[s.charAt(i)-'a']!=row){
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                list.add(a);
            }

        }
        return list.toArray(new String[0]);
    }
}
public class Main {
    public static void main(String[] args) {
        String[][] inputWords = {{"Hello","Alaska","Dad","Peace"},{"omk"},{"adsdf","sfd"}};
        Solution solution = new Solution();
        for(String[] words : inputWords){
            System.out.println(Arrays.toString(solution.findWords(words)));
        }
    }
}
