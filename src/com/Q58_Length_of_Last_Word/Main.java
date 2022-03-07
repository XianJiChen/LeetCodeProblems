package com.Q58_Length_of_Last_Word;

class Solution {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        int endIdx=len-1;
        boolean flag = false;
        char[] arr = s.toCharArray();
        for(int i=len-1;i>=0;i--){
            if(arr[i]==' '&&flag){
                return endIdx-i;
            }
            else if(!flag && arr[i]!=' '){
                flag = true;
                endIdx = i;
            }
        }
        return endIdx+1;
    }
}

public class Main {
}
