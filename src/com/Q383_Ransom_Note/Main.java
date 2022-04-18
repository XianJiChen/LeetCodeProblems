package com.Q383_Ransom_Note;

import java.util.HashMap;
import java.util.Map;

//16ms ver
/*
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> ransomCnt = count(ransomNote);
        HashMap<Character, Integer> magazineCnt = count(magazine);


        for(Character ch : ransomCnt.keySet()){
            if(!(magazineCnt.containsKey(ch) && magazineCnt.get(ch)>=ransomCnt.get(ch))){
                return false;
            }
        }
        return true;
    }

    private HashMap<Character, Integer> count(String str){
        HashMap<Character, Integer> cnt = new HashMap<Character, Integer>();
        for(char ch : str.toCharArray()){
            if(cnt.containsKey(ch)){
                cnt.put(ch,cnt.get(ch)+1);
            }
            else{
                cnt.put(ch, 1);
            }
        }
        return cnt;
    }
}
 */

//2ms ver
/*
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] arr = new int[26];
        int[] arr2 = new int[26];

        for (int i=0; i<ransomNote.length(); i++)
            arr[ransomNote.charAt(i)-97]++;

        for (int i=0; i<magazine.length(); i++)
            arr2[magazine.charAt(i)-97]++;

        for (int i=0; i<26; i++)
            if (arr[i] > arr2[i])
                return false;

        return true;
    }
}
*/

/*
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] cnt = new int[26];

        for (char ch : magazine.toCharArray())
            cnt[ch-97]++;

        for (char ch : ransomNote.toCharArray())
            if(cnt[ch-97]==0){
                return false;
            }
            else{
                cnt[ch-97]--;
            }

        return true;
    }
}
*/

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] cnt = new int[26];
        for (int i=0; i<magazine.length(); i++){
            cnt[magazine.charAt(i)-97]++;
        }


        int idx;
        for (int i=0; i<ransomNote.length(); i++){
            idx = ransomNote.charAt(i)-97;
            if(cnt[idx]==0){
                return false;
            }
            else{
                cnt[idx]--;
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        String[] ransomNotes = {"a","aa","aa"};
        String[] magazines = {"b","ab","aab"};

        Solution solution = new Solution();

        for(int i=0; i<ransomNotes.length; i++){
            System.out.println(solution.canConstruct(ransomNotes[i], magazines[i]));
            System.out.println("======");
        }
    }
}
