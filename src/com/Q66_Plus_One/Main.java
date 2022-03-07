package com.Q66_Plus_One;

import java.util.Arrays;

class Solution {
    public int[] plusOne(int[] digits) {
        int i,carry;
        int len = digits.length;
        for(i=len-1, carry=1; i>=0 ;i--){
            if(digits[i]==9){
                digits[i]=0;
            }
            else{
                digits[i]++;
                break;
            }
        }
        if(i==-1){
            int[] ans = new int[len+1];
            ans[0] = 1;
            System.arraycopy(digits, 0, ans, 1, len);
            digits = ans;
        }
        return digits;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{1,2,3},{4,3,2,1},{9}};
        Solution tt = new Solution();
        for(int[] input:inputs){
            System.out.println(Arrays.toString(tt.plusOne(input)));
            System.out.println("=====================");
        }
    }
}
