package com.Q125_Valid_Palindrome;

import java.util.Arrays;
import java.util.Locale;

//648ms ver
/*
class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().toCharArray();
        System.out.println(arr.length==0);
        System.out.println(">>>>>>>>>>>");
        for(int i=0, j=arr.length-1; i<j; i++, j--){
            if(arr[i]!=arr[j]){
                return false;
            }
        }
        return true;
    }
}
*/

//5ms ver
/*
class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = s.toLowerCase().toCharArray();
//        System.out.println(Arrays.toString(arr));
//        System.out.println("-----------------");
        for(int i=0, j = arr.length-1; i<j;){
//            System.out.println(i);
//            System.out.println(arr[i]);
//            System.out.println(j);
//            System.out.println(arr[j]);
//            System.out.println("???????????");
            if((('a'<=arr[i] && arr[i]<='z')||('0'<=arr[i]&&arr[i]<='9'))&&(('a'<=arr[j] && arr[j]<='z')||('0'<=arr[j]&&arr[j]<='9'))){
                if(arr[i]!=arr[j]){
                    return false;
                }
                else{
                    i++;
                    j--;
                }
            }
            else {
                if(!(('a'<=arr[i] && arr[i]<='z')||('0'<=arr[i]&&arr[i]<='9'))){
                    i++;
                }
                if(!(('a'<=arr[j] && arr[j]<='z')||('0'<=arr[j]&&arr[j]<='9'))){
                    j--;
                }
            }

        }
        return true;
    }
}
*/
//3ms ver
/*
class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        for(int i=0, j = arr.length-1; i<j;){
            if((Character.isAlphabetic(arr[i])||Character.isDigit(arr[i]))&&(Character.isAlphabetic(arr[j])||Character.isDigit(arr[j]))){
                if(Character.toLowerCase(arr[i])!=Character.toLowerCase(arr[j])){
                    return false;
                }
                else{
                    i++;
                    j--;
                }
            }
            else {
//                flag = false;
                while(i<j && (!(Character.isAlphabetic(arr[i])||Character.isDigit(arr[i])))){
                    i++;
                }
                while(i<j && (!(Character.isAlphabetic(arr[j])||Character.isDigit(arr[j])))){
                    j--;
                }
            }

        }
        return true;
    }
}
*/
//1ms ver
class Solution {
    private boolean isAlphaNumeric(char char1) {
        return ((char1 >= 'a' && char1 <= 'z') ||
                (char1 >= 'A' && char1 <= 'Z')||
                (char1 >= '0' && char1 <= '9'));
    }
    private char toLower(char c){
        if(c >= 'a' && c <= 'z')
            return c;
        return (char)(c + 32);
    }
    public boolean isPalindrome(String sb) {
        char[] arr = sb.toCharArray();
        int i = 0, j = arr.length-1;
        while(i < j){
            if(!(isAlphaNumeric(arr[i]))){
                i++;
                continue;
            }
            if(!(isAlphaNumeric(arr[j]))){
                j--;
                continue;
            }

            if(toLower(arr[i]) != toLower(arr[j])){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        String[] inputs = {"A man, a plan, a canal: Panama","race a car", "ab_a", "0P","ooooooo" , "  ", "8V8K;G;K;V;"};
        Solution solution = new Solution();
        for(String str : inputs){
            System.out.println(solution.isPalindrome(str));
            System.out.println("========");
        }
    }
}
