package com.Q268_Missing_Number;


class Solution {
    public int missingNumber(int[] nums) {
        boolean[] ans = new boolean[nums.length+1];
        for(int i=0; i<nums.length; i++){
            ans[nums[i]] = true;
        }
        for(int i=0; i<ans.length; i++){
            if(ans[i]==false){
                return i;
            }
        }
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{3,0,1},{0,1},{9,6,4,2,3,5,7,0,1}};
        Solution solution = new Solution();
        for(int[] input : inputs){
            System.out.println(solution.missingNumber(input));
            System.out.println("=====");
        }
    }
}
