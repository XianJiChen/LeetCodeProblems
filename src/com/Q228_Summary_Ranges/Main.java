package com.Q228_Summary_Ranges;

import java.util.ArrayList;
import java.util.List;

//1ms ver
class Solution {
    public List<String> summaryRanges(int[] nums) {
        int len = nums.length;
        List<String> ranges = new ArrayList<String>();
        String str = "";
        int start = -1;
        for(int i=0; i<len; i++){
            if(start==-1){
                start = i;
                str = String.valueOf(nums[i]);
            }
            else if(nums[i]!=nums[i-1]+1){
                if(i-1!=start){
                    str += "->";
                    str += String.valueOf(nums[i-1]);
                }
                ranges.add(str);
                start = i;
                str = String.valueOf(nums[i]);
            }

            if(i==len-1){
                if(start==len-1){
                    ranges.add(String.valueOf(nums[i]));
                }
                else{
                    str += "->";
                    str += String.valueOf(nums[i]);
                    ranges.add(str);
                }
            }
        }
        return ranges;
    }
}


public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{0,1,2,4,5,7},{0,2,3,4,6,8,9}};
        Solution solution = new Solution();
        for(int[] input : inputs){
            System.out.println(solution.summaryRanges(input));
            System.out.println("----------------");
        }
    }
}
