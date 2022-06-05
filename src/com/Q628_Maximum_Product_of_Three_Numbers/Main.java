package com.Q628_Maximum_Product_of_Three_Numbers;

import java.util.Arrays;

//14ms
/*
class Solution {
    public int maximumProduct(int[] nums) {
        if(nums.length==3){
            return nums[0]*nums[1]*nums[2];
        }
        else{
            Arrays.sort(nums);
            return Math.max(nums[0]*nums[1]*nums[nums.length-1], nums[nums.length-3]*nums[nums.length-2]*nums[nums.length-1]);
        }
    }
}
*/

//2ms ver
class Solution {
    public int maximumProduct(int[] nums){
        if(nums.length==3){
            return nums[0]*nums[1]*nums[2];
        }
        else{
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            int max1 = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE;
            int max3 = Integer.MIN_VALUE;

            for(int num : nums){
                if(num<=min1){
                    min2= min1;
                    min1 = num;
                }
                else if(num<min2){
                    min2 = num;
                }

                if(num>=max3){
                    max1= max2;
                    max2 = max3;
                    max3 = num;
                }
                else if(num>=max2){
                    max1= max2;
                    max2 = num;
                }
                else if(num>max1){
                    max1 = num;
                }
            }

            return Math.max(min1*min2*max3, max1*max2*max3);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{1,2,3},{1,2,3,4},{-1,-2,-3}};
        Solution solution = new Solution();
        for(int[] input : inputs){
            System.out.println(solution.maximumProduct(input));
            System.out.println("================");
        }
    }
}
