package com.Q594_Longest_Harmonious_Subsequence;

import java.util.Arrays;
import java.util.HashMap;

//20ms ver
/*
class Solution {
    public int findLHS(int[] nums) {
        int max=0;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for(int num : nums){
            if(cnt.containsKey(num)){
                cnt.put(num, cnt.get(num)+1);
            }
            else{
                cnt.put(num, 1);
            }
        }

        for(int key : cnt.keySet()){
            if(cnt.containsKey(key-1)){
                max = Math.max(max, cnt.get(key)+cnt.get(key-1));
            }
        }
        return max;
    }
}
*/

//14ms ver
class Solution{
    public int findLHS(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int ans = 0;
        int prevVal = 1000000002;
        int prevCount = 0;
        int count = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            left = i;
            i++;
            while (i < n && nums[i - 1] == nums[i]) {
                i++;
            }
            count = i - left;
            i--;

            if (nums[i] - prevVal == 1) {
                if (ans < prevCount + count) {
                    ans = prevCount + count;
                }
            }

            prevCount = count;
            prevVal = nums[i];
        }

        return ans;
    }
}


public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{1, 3, 2, 2, 5, 2, 3, 7}, {1, 2, 3, 4}, {1, 1, 1, 1}};
        Solution solution = new Solution();
        for (int[] input : inputs) {
            System.out.println(solution.findLHS(input));
            System.out.println("===================");
        }
    }
}
