package com.Q283_Move_Zeroes;

import java.util.Arrays;


//1ms ver
class Solution {
    public void moveZeroes(int[] nums) {
        int i;
        int j;
        for(i=0, j=0; i<nums.length; i++){
            if(nums[i]!=0){
                nums[j++] = nums[i];
            }
        }
        for(; j<nums.length; j++){
            nums[j] = 0;
        }
    }
}

public class Main {
    public static void main(String[] args) {

        int[][] inputs = {{0,1,0,3,12},{0}};
        Solution solution = new Solution();
        for(int[] input : inputs){
            solution.moveZeroes(input);
            for(int in : input){
                System.out.println(in);
            }
            System.out.println("==========");
        }
    }
}
