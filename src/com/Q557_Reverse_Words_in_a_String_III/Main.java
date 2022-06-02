package com.Q557_Reverse_Words_in_a_String_III;

//4ms ver

class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        for(int i=words.length-1; i>=0; i--){
            sb.append(words[i]);
            sb.append(" ");
        }
        return sb.reverse().toString().trim();
        //return sb.reverse().deleteCharAt(0).toString();
    }
}

public class Main {
    public static void main(String[] args) {
        String[] inputs = {"Let's take LeetCode contest", "God Ding"};
        Solution solution = new Solution();
        for(String input : inputs){
            System.out.println(solution.reverseWords(input));
            System.out.println("================");
        }
    }
}
