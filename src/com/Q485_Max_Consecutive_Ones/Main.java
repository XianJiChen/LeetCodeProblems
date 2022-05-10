package com.Q485_Max_Consecutive_Ones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//2ms ver
/*
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        for(int prevIdx=-1, idx=0; idx<nums.length; idx++){
            if(nums[idx]==0){
                max = Math.max(max, idx-prevIdx-1);
                prevIdx = idx;
            }
            else if(idx==nums.length-1) {
                max = Math.max(max, idx-prevIdx);
            }
        }
        return max;
    }
}
*/

//2ms ver
/*
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int prevIdx=-1;
        int idx=0;
        for(; idx<nums.length; idx++){
            if(nums[idx]==0){
                max = Math.max(max, idx-prevIdx-1);
                prevIdx = idx;
            }
        }
        if(nums[nums.length-1]==1){
            max = Math.max(max, idx-prevIdx);
        }

        return max;
    }
}
*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cnt =0;
        for(int idx=0; idx<nums.length; idx++){
//            System.out.println(idx);
            if(nums[idx]==0){
                max = Math.max(max, cnt);
                cnt = 0;
            }
            else{
                cnt++;
            }
//            System.out.println(cnt);
//            System.out.println("------");
        }
        if(nums[nums.length-1]==1){
            max = Math.max(max, cnt);
        }

        return max;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{1,1,0,1,1,1},{1,0,1,1,0,1}};
        Solution solution = new Solution();
        for(int[] input : inputs){
            System.out.println(solution.findMaxConsecutiveOnes(input));
            System.out.println("==========");
        }
    }
}
