package com.Q345_Reverse_Vowels_of_a_String;

import java.util.Arrays;

//2ms ver
/*
class Solution {
    private boolean isVowel(char ch){
        return (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')||(ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U');
    }

    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        char tmp;
        for(int i=0, j= arr.length-1; i<j; i++){
            if(isVowel(arr[i])){
                while(!isVowel(arr[j])){
                    j--;
                }
                if(i<j){
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
                j--;
            }
        }
        return new String(arr);
    }
}
*/

class Solution {
    private boolean isVowel(char ch){
        return (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')||(ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U');
    }

    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        char tmp;
        int i=0;
        int j=arr.length-1;
        while(true){
            while(!isVowel(arr[i]) && i<j){
                i++;
            }
            while(!isVowel(arr[j]) && i<j){
                j--;
            }

            if(i<j){
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
            else{
                break;
            }
        }
        return new String(arr);
    }
}

public class Main {
    public static void main(String[] args) {
        String[] inputs = {"hello","leetcode","aA"};
        Solution solution = new Solution();
        for(String str : inputs){
            System.out.println(solution.reverseVowels(str));
            System.out.println("====");
        }
    }
}
