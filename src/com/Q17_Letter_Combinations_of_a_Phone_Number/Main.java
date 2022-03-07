package com.Q17_Letter_Combinations_of_a_Phone_Number;

import java.util.*;
//0ms 100% ver
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();

        String[][] dict = {{"a","b","c"},{"d","e","f"},{"g","h","i"},{"j","k","l"},{"m","n","o"},{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};
        List<String> combos = new ArrayList<>();
        backtrack(combos, digits.toCharArray(), digits.length(), "", 0, dict);
        return combos;
    }

    public void backtrack(List<String> combos, char[] digits, int dlen, String s, int slen, String[][] dict) {
        if (slen==dlen) { combos.add(s); return; }
        int digit = digits[slen] - '2';
        for (String letter : dict[digit]) {
            backtrack(combos, digits, dlen, s + letter, slen+1,dict);
        }
    }
}
//1ms ver
/*
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();

        String[] dict = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> combos = new ArrayList<>();
        backtrack(combos, digits.toCharArray(), "", dict);
        return combos;
    }

    public void backtrack(List<String> combos, char[] digits, String s, String[] dict) {
        if (s.length() == digits.length) { combos.add(s); return; }
        int i = s.length();
        int digit = digits[i] - '0';
        for (char letter : dict[digit].toCharArray()) {
            backtrack(combos, digits, s + Character.toString(letter), dict);
        }
    }
}
*/
//3 ms ver
/*
class Solution {
    public List<String> letterCombinations(String digits) {
        char[] dig = digits.toCharArray();
        int len = digits.length();
        if(len==0) return new ArrayList<String>();
        String[][] arr = {{"a","b","c"},{"d","e","f"},{"g","h","i"},{"j","k","l"},{"m","n","o"},{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};
        int idx=0;
        int cnt=0;
        for(int i=0; i<len; i++){
            if(digits.charAt(i)=='7'||digits.charAt(i)=='9') cnt++;
        }
        cnt = (int)(Math.pow(3,len-cnt)*Math.pow(4,cnt));
        String[] ans = new String[cnt];
//        System.out.println(cnt);
//        System.out.println("AAAAAAAAAAAAAAAA");
        idx = digits.charAt(0)-'2';



        idx=0;
        for(int i=0; i<len; i++){
            idx = digits.charAt(i)-'2';
            cnt/=arr[idx].length;
//            System.out.println(idx);
//            System.out.println(cnt);
//            System.out.println(digits.charAt(i));
//            System.out.println("---------------");
            if(i==0){
                for(int j=0; j< ans.length; j++){
                    ans[j] = arr[idx][j/cnt];
                }
            }
            else{
                for(int j=0; j< ans.length; j++) {
//                    System.out.println(ans[j]);
//                    System.out.println(j);
//                    System.out.println(cnt);
//                    System.out.println(arr[idx][j / cnt]);
                    ans[j] += arr[idx][(j / cnt)%arr[idx].length];
                }
            }
        }
        return Arrays.stream(ans).toList();
    }
}
 */

public class Main {
    public static void main(String[] args) {
        String[] inputs = {"23", "", "2", "739"};
        Solution tt = new Solution();
        System.out.println((int)(inputs[0].charAt(0)-'2'));
        for(String str:inputs){
            System.out.println(tt.letterCombinations(str));
            System.out.println("============>");
        }
    }
}
