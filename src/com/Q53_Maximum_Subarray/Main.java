package com.Q53_Maximum_Subarray;

class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int maxSum = nums[0];
        int curSum = nums[0];
        for(int i=1; i<len; i++){
            curSum = (curSum>0) ? curSum + nums[i] : nums[i];
            maxSum = (curSum>maxSum) ? curSum : maxSum;
        }
        return maxSum;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{-2,1,-3,4,-1,2,1,-5,4},{1}};
        Solution tt= new Solution();
        for(int[] input:inputs){
            System.out.println(tt.maxSubArray(input));
            System.out.println("==================");
        }
    }
}
