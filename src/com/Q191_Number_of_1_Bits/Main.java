package com.Q191_Number_of_1_Bits;

/*
class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        char[] arr = Integer.toBinaryString(n).toCharArray();
        int cnt = 0;
        for(char ch : arr){
            if(ch == '1'){
                cnt++;
            }
        }
        return cnt;
    }
}
*/
//1ms ver
class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ones = 0;
        while(n!=0) {
            ones = ones + (n & 1);
            n = n>>>1;
        }
        return ones;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] inputs = {11,Integer.parseInt("00000000000000000000000010000000"), -3};
        Solution solution = new Solution();
        for(int input : inputs){
            System.out.println(solution.hammingWeight(input));
        }
    }
}
