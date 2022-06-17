package com.Q643_Maximum_Average_Subarray_I;

//3ms ver
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int val = 0;
        for (int i = 0; i < k; i++) {
            val += nums[i];
        }
        int max = val;
        for (int i = 1; i < nums.length-k+1; i++) {
            val -= nums[i - 1];
            val += nums[i + k - 1];
            max = Math.max(max, val);
        }
        return (double) max / k;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{1, 12, -5, -6, 50, 3}, {5}};
        int[] ks = {4, 1};
        Solution solution = new Solution();
        for (int i = 0; i < inputs.length; i++) {
            System.out.println(solution.findMaxAverage(inputs[i], ks[i]));
            System.out.println("=======");
        }
    }
}
