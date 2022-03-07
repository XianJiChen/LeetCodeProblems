package com.Q1_Two_Sum;
import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        int ans[]={-1,-1};
        Map<Integer,Integer>s=new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {

            if(s.containsKey(target-nums[i]))
            {
                //since the problem do not require indexes in sorted order, then the following implementation is fine
                //But if the question requires users to return indexes in sorted order, then we should switch i and s.get();
                ans[0]=i;
                ans[1]=s.get(target-nums[i]);
                break;
            }
            else
                s.put(nums[i],i);
        }
        // System.out.println(s);
        return ans;
    }
}
public class Main {
    public static void main(String args[]){
        int[][] nums = {{2,7,11,15},{3,2,4},{3,3}};
        int[] targets = {9,6,6};
        int[] ans = new int[2];
        Solution tt = new Solution();
        for(int i=0; i<nums.length; i++){
            ans = tt.twoSum(nums[i],targets[i]);
            for(int j=0; j<ans.length; j++)
                System.out.println(ans[j]);
        }

    }
}
