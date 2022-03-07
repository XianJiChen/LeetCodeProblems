package com.Q20_Valid_Parentheses;

import java.util.Stack;

//0ms ver
/*
class Solution {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        //Stack<Character> stk = new Stack<Character>();
        char[] stk= new char[len];
        int k=-1;
        for(int i=0; i<len; i++){
            if(k>len/2) return false;
            switch (arr[i]){
                case '(':
                case '[':
                case '{':
                    stk[++k] = arr[i];
                    break;
                case ')':
                    if(k==-1 || stk[k]!='(') return  false;
                    else k--;
                    break;
                case ']':
                    if(k==-1 || stk[k]!='[') return  false;
                    else k--;
                    break;
                case '}':
                    if(k==-1 || stk[k]!='{') return  false;
                    else k--;
                    break;
            }
        }
        return k==-1;
    }
}
*/
//1ms ver

class Solution {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        Stack<Character> stk = new Stack<Character>();
        for(int i=0; i<len; i++){
            if(stk.size()>len/2) return false;
            switch (arr[i]){
                case '(':
                case '[':
                case '{':
                    stk.add(arr[i]);
                    break;
                case ')':
                    if(stk.empty() || stk.peek()!='(') return  false;
                    else stk.pop();
                    break;
                case ']':
                    if(stk.empty() || stk.peek()!='[') return  false;
                    else stk.pop();
                    break;
                case '}':
                    if(stk.empty() || stk.peek()!='{') return  false;
                    else stk.pop();
                    break;
            }
        }
        return stk.empty();
    }
}


public class Main {
    public static void main(String[] args) {
        String[] inputs = {"()","()[]{}","(]"};
        Solution tt = new Solution();
        for(String str:inputs){
            System.out.println(tt.isValid(str));
            System.out.println("====================");
        }
    }
}
