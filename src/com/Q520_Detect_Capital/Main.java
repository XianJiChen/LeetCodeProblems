package com.Q520_Detect_Capital;

import java.util.Locale;

//3ms ver
/*
class Solution {
    public boolean detectCapitalUse(String word) {
//        System.out.println(word);
        String allCap = word.toUpperCase(Locale.ROOT);
        String allLow = word.toLowerCase(Locale.ROOT);

//        System.out.println((word.equals(allCap)));
//        System.out.println(word.equals(allLow));
//        System.out.println(Character.isUpperCase(word.charAt(0)));

        if(word.equals(allCap)||word.equals(allLow)){
            return true;
        }
        else{
            String sub = word.substring(1, word.length());
//            System.out.println("SUB");
//            System.out.println(sub);
//            System.out.println(sub.equals(sub.toLowerCase(Locale.ROOT)));
            return (Character.isUpperCase(word.charAt(0))&&(sub.equals(sub.toLowerCase(Locale.ROOT))));
        }
    }
}
*/

//1ms ver
/*
class Solution {
    public boolean detectCapitalUse(String word) {
        String sub;
        if(Character.isLowerCase(word.charAt(0))){
            sub = word.substring(1,word.length());
            return (sub.equals(sub.toLowerCase(Locale.ROOT)));
        }
        else {
            if(Character.isUpperCase(word.charAt(1))){
                return word.equals(word.toUpperCase(Locale.ROOT));
            }
            else{
                sub = word.substring(1,word.length());
                return (sub.equals(sub.toLowerCase(Locale.ROOT)));
            }
        }
    }
}
*/

class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length()==1){
            return true;
        }
        boolean shouldBeAllUpper = false;
        if((int)word.charAt(0)<91 && (int)word.charAt(1)<91){
            shouldBeAllUpper = true;
        }

        if(shouldBeAllUpper){
            for(int i=2;i<word.length();i++){
                if((int)word.charAt(i)>90){
                    return false;
                }
            }
        }
        else{
            for(int i=1;i<word.length();i++){
                if((int)word.charAt(i)<91){
                    return false;
                }
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        String[] inputs = {"USA", "leetcode", "Google", "FlaG"};
        Solution solution = new Solution();
        for(String input : inputs){
            System.out.println(solution.detectCapitalUse(input));
            System.out.println("==================");
        }
    }
}
