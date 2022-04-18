package com.Q242_Valid_Anagram;



//wrong ver
/*
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();

        int tmp = 0;
        for(char charS : arrS){
            System.out.println((int)charS);
            tmp ^= charS;
        }
        System.out.println("!!");
        for(char charT : arrT){
            System.out.println((int)charT);
            tmp ^= charT;
        }
        return (tmp==0);
    }
}
*/

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


//18ms ver
/*
class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length()){
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
        }
        for(char ch : t.toCharArray()){
            if(map.containsKey(ch)){
                if(map.get(ch)==1){
                    map.remove(ch);
                }
                else{
                    map.put(ch,map.get(ch)-1);
                }
            }
            else{
                return false;
            }
        }
        return true;
    }
}
*/


//1ms ver
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] cnt = new int[26];
        for(char c : s.toCharArray()){
            cnt[c-'a']++;
        }
        for(char c : t.toCharArray()) {
            cnt[c - 'a']--;
            if (cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}

//another 1ms ver
/*
class Solution {

    public boolean isAnagram(String s, String t) {

        int[] cnts = new int[26];
        int[] cntt = new int[26];

        for( char x : s.toCharArray() )
            cnts[x-'a']++;

        for( char x : t.toCharArray() )
            cntt[x-'a']++;

        for( int i = 0 ; i < 26 ;i++ ){
            if ( cnts[i] != cntt[i] )
                return false;
        }
        return true;
    }
}
*/

public class Main {
    public static void main(String[] args) {
        System.out.println((int)'a');
        String[] ss = {"anagram","rat", "aa", "ab"};
        String[] ts = {"nagaram","car", "bb", "a"};
        Solution solution = new Solution();
        for(int i=0; i<ss.length; i++){
            System.out.println(solution.isAnagram(ss[i],ts[i]));
            System.out.println("--------");
        }
    }
}
