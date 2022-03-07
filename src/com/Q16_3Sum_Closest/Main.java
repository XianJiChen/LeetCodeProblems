package com.Q16_3Sum_Closest;

import java.util.*;

class Solution {
    public int threeSumClosest(int[] num, int target) {
        int len = num.length;
        int result = num[0] + num[1] + num[2];
        int min_dist = Math.abs(result-target);
        int sum, dist;
        Arrays.sort(num);
        for (int i = 0; i < len-2; i++) {
            int start = i + 1, end = len-1;
            while (start < end) {
                sum = num[i] + num[start] + num[end];
                // -3, 0, 1, 2
//                System.out.printf("sum: %d, dist: %d, min_dist: %d\n", sum, Math.abs(sum-target), min_dist);
//                System.out.println("-------------");
                if(sum==target) return target;
                else{
                    dist = Math.abs(sum - target);
                    if (dist < min_dist) {
                        result = sum;
                        min_dist = dist;
                    }
                }
                if(num[start]==num[end]) break;
                else if (sum > target) {
                    end--;
                    while(end>0 && num[end]==num[end+1]) end--;
                } else {
                    start++;
                    while(start<len && num[start]==num[start-1]) start++;
                }

            }
        }
        return result;
    }
}
//629ms ver...
/*
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Sort the given array
        Arrays.sort(nums);
        int len = nums.length;
        if((nums[len-1]<0 && target>=0)||(nums[len-3] + nums[len-2] + nums[len-1]<target)) return nums[len-3] + nums[len-2] + nums[len-1];
        else if((nums[0]>0 && target<=0)||(nums[0] + nums[1] + nums[2] > target)) return nums[0] + nums[1] + nums[2];
        int min_dist = Integer.MAX_VALUE;
        int min_val=0, tmp=0;
        int sum;//, num2Idx, num3Idx;
        int prev_dist=Integer.MAX_VALUE, dist;
        for(int num1Idx = 0; num1Idx < len-2; num1Idx++){
            for(int num2Idx = num1Idx+1; num2Idx<len-1; num2Idx++){
                prev_dist = Integer.MAX_VALUE;
                for(int num3Idx = num2Idx+1; num3Idx<len; num3Idx++){
                    System.out.printf("num1: %d, num2: %d, num3: %d\n", num1Idx, num2Idx, num3Idx);
                    tmp = nums[num1Idx]+nums[num2Idx]+nums[num3Idx];
                    dist = Math.abs(tmp-target);
                    System.out.println(tmp);
                    System.out.printf("prev_dist: %d, dist: %d, min_dist: %d\n", prev_dist, dist, min_dist);
                    System.out.println("-------------");
                    if (tmp == target) return tmp;
                    else if(dist>prev_dist) break;
                    else{
                        prev_dist = dist;
                        if(dist<min_dist){
                            min_dist = dist;
                            min_val = tmp;
                        }
                    }
                }
                while (num2Idx+1<len && nums[num2Idx]==nums[num2Idx+1]) num2Idx++;
            }
            while(num1Idx+1<len && nums[num1Idx] == nums[num1Idx+1]) num1Idx++;
        }
        return min_val;
    }
}
*/

public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{-1,2,1,-4},{0,0,0},{0,2,1,-3}};
        int[] targets = {1,1,1};
        Solution tt = new Solution();
        for(int i=0; i< inputs.length; i++){
            System.out.println(tt.threeSumClosest(inputs[i], targets[i]));
            System.out.println("=======================");
        }
    }
}
