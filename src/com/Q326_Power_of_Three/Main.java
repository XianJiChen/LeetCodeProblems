package com.Q326_Power_of_Three;

class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0){
            return false;
        }
        else{
            while(n%3==0){
                System.out.println(n);
                n/=3;
            }
            return (n==1);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] inputs = {27, 0, 9};
        Solution solution = new Solution();
        for(int input : inputs){
            System.out.println(solution.isPowerOfThree(input));
            System.out.println("======");
        }
    }
}
