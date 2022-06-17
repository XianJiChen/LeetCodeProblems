package com.Q31_Next_Permutation;

import java.util.Arrays;

/*
123
132
213
231
312
321
12345
12354

12435
12453
12534
12543
13245

13542
14235
 */

class Solution {
    private void reverseArray(int[] nums, int start, int end) {
        int tmp;
        for (int j = start, k = end; j < k; j++, k--) {
            tmp = nums[j];
            nums[j] = nums[k];
            nums[k] = tmp;
        }
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }
        if (i == 0) {
            reverseArray(nums, 0, nums.length - 1);
        } else {
            int minValIdx = nums.length-1;
            int minVal = Integer.MAX_VALUE;
            for(int j=nums.length-1; j>=i; j--){
                if(nums[j]-nums[i-1]>0){
                    minValIdx = (nums[j] < minVal) ? j : minValIdx;
                    minVal = Math.min(minVal, nums[minValIdx]);
                }
            }
            int tmp = nums[i-1];
            nums[i-1] = nums[minValIdx];
            nums[minValIdx] = tmp;
            reverseArray(nums, i, nums.length - 1);

            //reverseArray(nums, i - 1, i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] inputs = {/*{1, 2, 3}, {3, 2, 1}, {1, 1, 5}, {1, 3, 2}, {2, 3, 1},*/ {5,1,1}};
        Solution solution = new Solution();
        for (int[] input : inputs) {
            solution.nextPermutation(input);
            System.out.println(Arrays.toString(input));
            System.out.println("============");
        }
    }
}
