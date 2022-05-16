package com.Q509_Fibonacci_Number;

class Solution {
    public int fib(int n) {
        if(n<=2){
            return Math.min(1,n);
        }
        else{
            int[] fbs = {1,1};
            int idx=0;
            for(int i=0; i<n-3; i++, idx=(idx==0)? 1:0){
                fbs[idx] = fbs[0] + fbs[1];
            }
            return fbs[0] + fbs[1];
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] inputs = {0,1,2,3,4};
        Solution solution = new Solution();
        for(int input : inputs){
            System.out.println(solution.fib(input));
            System.out.println("=============");
        }
    }
}
