package com.Q5_Longest_Palindormic_Substring;
import java.util.*;

//13ms ver
class Solution {
    public String str;
    public int start=0, end=0, max=0, len;
    public char[] arr;
    public void Test_Palindrome(int i, int j){
        int cnt=j-i+1;
        for(; i>=0 && j<len; i--, j++){
            if(arr[i]!=arr[j]){
                i++;
                j--;
                break;
            }
        }
        if(i < 0 || j >= len){
            i++;
            j--;
        }
        cnt = j - i +1;
        if(cnt > max){
            max = cnt;
            start = i;
            end = j;
        }
    }
    public String longestPalindrome(String s) {
        str = s;
        max =0;
        len = s.length();
        arr = s.toCharArray();
        if(len<2) return s;
        else{
            for(int i=0;i<len;i++){
                if(2*(len-1-i)+1>max)Test_Palindrome(i,i);
            }
            for(int i=0; i< len-1;i++){
                if(2*(len-1-i)>max)Test_Palindrome(i,i+1);
            }
            return s.substring(start,end+1);
        }
    }
}

//33ms ver
/*
class Solution {
    public String str;
    public int start=0, end=0, max=0;
    public void Test_Palindrome(int i, int j){
        int cnt=j-i+1;
        for(;i>=0&&j<str.length();i--,j++){
            if(str.charAt(i)!=str.charAt(j)){
                i++;
                j--;
                break;
            }
        }
        if(i<0||j>= str.length()){
            i++;
            j--;
        }
        cnt = j - i +1;
        if(cnt > max){
            max = cnt;
            start = i;
            end = j;
        }
    }
    public String longestPalindrome(String s) {
        str = s;
        max =0;
        if(s.isEmpty()) return s;
        else{
            for(int i=0;i<s.length();i++){
                Test_Palindrome(i,i);
            }
            for(int i=0; i< s.length()-1;i++){
                Test_Palindrome(i,i+1);
            }
//            System.out.println(start);
//            System.out.println(end);
//            System.out.println(max);
            return s.substring(start,end+1);
        }
    }
}
*/

/*
class Solution {
    public int max_len(String s, int idx,Stack<Character> stack){
        Stack<Character> stk= (Stack<Character>) stack.clone();
        //System.out.println(stk.toString());
        int cnt=0;
        for(int i=idx;i<s.length() && !stk.empty();i++,cnt++){
            if(s.charAt(i)!=(char)stk.pop()) break;
        }
        //System.out.println(stk.toString());
        return cnt;
    }
    public String longestPalindrome(String s) {
        Stack<Character> stack= new Stack<Character>();
//        if(s.length()<2) return s;
//        else if(s.length()==3){
//            return (s.charAt(0)==s.charAt(s.length()-1)) ? s.substring(1,2) : s;
//        }
//        else{
//            for(int i=1; i<s.length()-1; i++){
//                int prev=i, next=i;
//                if(s.charAt(i-1)==s.charAt(i+1))
//                else if(s.charAt(i)==s.charAt(i+1)) next = i;
//
//                while(prev<=0&&next<s.length()){
//                    if(s.charAt(prev)!=s.charAt(next)) break;
//                    else{
//                        prev--;
//                        next++;
//                    }
//                }
//            }
//        }
        int tmp;
        int max=0;
        int start=0,end=s.length()-1;
        if(s.length()<2) return s;
        else if(s.length()==2) return (s.charAt(0)==s.charAt(1)) ? s : String.valueOf(s.charAt(0));
        for(int i=0; i<s.length(); i++){
//            System.out.println(s.charAt(i));
//            System.out.println(s.charAt(i+1));
//            System.out.println(stack.toString());
            if(stack.empty()){
                stack.add(s.charAt(i));
                max = 1;
                start = end = 0;
            }
            else{
                if(i!=s.length()-1){
                    if(s.charAt(i+1) == (char)stack.peek()){
                        //System.out.println("before1");
                        tmp = max_len(s,i+1, stack);
                        //System.out.println("after1");
                        //System.out.println(tmp);
                        if(2*tmp+1>max){
                            start = i-tmp;
                            end = i+tmp;
                            max = 2*tmp+1;
                        }
    //                    System.out.println(2*tmp+1);
    //                    System.out.println(max);
    //                    System.out.println("finish1");
                    }
                }
                if(s.charAt(i)==(char)stack.peek()){
//                    System.out.println("before2");
                    tmp = max_len(s, i, stack);
//                    System.out.println("after2");
//                    System.out.println(tmp);
                    if(2*tmp>max){
                        start = i-tmp;
                        end = i+tmp-1;
                        max = 2*tmp;
                    }
//                    System.out.println(2*tmp);
//                    System.out.println(max);
//                    System.out.println("finish2");
                }
                stack.add(s.charAt(i));
            }
//            System.out.printf("%d th round is finished! \n", i);
//            System.out.println(stack.toString());
//            System.out.println(max);
//            System.out.println("---------------");
        }
        return s.substring(start,end+1);
    }
}
*/


/*
class Solution {
    public String longestPalindrome(String s) {
        //ASCII codes of char 0~9 are 48~57, of char A~Z are 65~90, of char a~z are 97~122
        //0~9 10~35 36~61
        if(s.length()<2){
            return s;
        }
        else{
            int[] cnt = new int[75];//122-47
            int max = 0,idx;
            int start=0, end=s.length()-1;
            for(int i=0; i<s.length(); i++){
                idx = (int) s.charAt(i);
                if(idx>96){
                    idx -= 61;
                }
                else if(idx>64){
                    idx -= 55;
                }
                if(cnt[idx]!=0 && i-(cnt[idx]-1)+1>max) {
                    max = i-(cnt[idx]-1)+1;
                    start = cnt[idx]-1;
                    end = i+1;
                }
                cnt[idx] = i+1;

                System.out.println("--------------");
                System.out.println(s.substring(start,end));
            }
            return s.substring(start,end);
        }
    }
}
*/

public class Main {
    public static void main(String[] args){
        String[] inputs = {"babad","cbbd","aacabdkacaa","cbbd","bb","abb","bananas"};
        //System.out.println((char)49);
        Solution tt =new Solution();
        for(String str:inputs){
            System.out.println(tt.longestPalindrome(str));
            System.out.println("================");
        }
    }
}
