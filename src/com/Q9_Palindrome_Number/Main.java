package com.Q9_Palindrome_Number;
//6ms ver
class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        else if(x<10) return true;
        else if(x<100) return x%11 == 0;
        else if(x%10==0) return false;
        else{
            int t = 0;
            while(x>t){
                t = t*10 + x%10;
                x/=10;

                System.out.println(x);
                System.out.println(t);
                System.out.println("----------");

            }

            System.out.println(x);
            System.out.println(t);
            System.out.println(t-10*x<10);

            //if(x==t || Math.abs(t-10*x)<10) return true;
            if(x==t || x==t/10) return true;
            else return false;
        }
    }
}
// 7ms ver
/*
class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        else if(x<10) return true;
        else if(x<100) return x%11 == 0;
        else{
            String str = String.valueOf(x);
            int len = str.length();
            char[] arr = str.toCharArray();
            int i,j;
            i = j = len/2-1;
            if(len%2==0){
                //i = len/2-1;
                j += 1;//j = len/2;
            }
            else{
                //i = len/2-1;
                j += 2;//j = len/2+1;
            }
            while(i>=0 && j<= len-1){
                if(arr[i]==arr[j]){
                    i--;
                    j++;
                }
                else return false;
            }
            return true;
        }
    }
}
*/
public class Main {
    public static void main(String[] args) {
        int[] inputs = {121, -121, 10, 12342342, 12344321, 123565321, 12345432, 313};
        Solution tt = new Solution();

        for(int input:inputs){
            System.out.println(input);
            System.out.println(tt.isPalindrome(input));
            System.out.println("====================");
        }
    }
}
