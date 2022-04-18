package com.Q342_Power_of_Four;


class Solution {
    public boolean isPowerOfFour(int n) {
        int i=1;
        while(i<n && i>0){
            i <<= 2;
        }
        return (i==n);
    }
}

public class Main {
    public static void main(String[] args) {
        int[] inputs = { 16, 5, 1};
        Solution solution = new Solution();
        for(int input : inputs){
            System.out.println(solution.isPowerOfFour(input));
            System.out.println("====");
        }
    }
}
