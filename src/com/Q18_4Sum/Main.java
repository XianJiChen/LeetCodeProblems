package com.Q18_4Sum;

import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Arrays;

//5ms ver
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int len = nums.length;
        if(len<4) return ans;
        int sum;
        Arrays.sort(nums);
        int twoSumTarget, twoSumMin, twoSumMax;
        for(int idx1=0; idx1<len-3;idx1++) {
            for (int idx2 = len - 1; idx1+2 < idx2; idx2--) {
                twoSumTarget = target-nums[idx1]-nums[idx2];
                twoSumMax = nums[idx2-1]+nums[idx2-2];
                twoSumMin = nums[idx1+1]+nums[idx1+2];
                if(twoSumMax<twoSumTarget) break;
                else if(twoSumMin>twoSumTarget) continue;
                for(int idx3=idx1+1, idx4=idx2-1; idx3<idx4; idx3++, idx4--){
                    sum = nums[idx3]+nums[idx4];
                    if(sum<twoSumTarget){
                        while(idx3<idx4 && nums[idx3]==nums[idx3+1]) idx3++;
                        idx4++;
                    }
                    else if(sum>twoSumTarget){
                        while(idx4>idx3 && nums[idx4]==nums[idx4-1]) idx4--;
                        idx3--;
                    }
                    else{
                        ans.add(new Vector<Integer>(Arrays.asList(nums[idx1],nums[idx3], nums[idx4], nums[idx2])));
                        while(idx3<idx4 && nums[idx3]==nums[idx3+1]) idx3++;
                        while(idx4>idx3 && nums[idx4]==nums[idx4-1]) idx4--;
                    }
                }
                while(idx2>idx1 && nums[idx2]==nums[idx2-1]) idx2--;
            }
            while(idx1<len-3 && nums[idx1]==nums[idx1+1]) idx1++;
        }
        return ans;
    }
}
//9ms ver
/*
class Solution {
   public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(nums);
        for(int i = 0;i< nums.length - 3;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1;j< nums.length - 2;j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int twoSumTarget = target - nums[i] - nums[j];
                //The following 3 lines of code to calculate the min and max of twoSum
                int minTwoSum = nums[j+1] + nums[j+2];
                int maxTwoSum = nums[nums.length - 1] + nums[nums.length - 2];
                if(twoSumTarget < minTwoSum || twoSumTarget > maxTwoSum) continue;
                for(int m = j+1,n= nums.length-1;m < n;){
                    int twoSum = nums[m] + nums[n];
                    if(twoSum < twoSumTarget){
                        while(m < n && nums[m] == nums[m+1]) m++;
                        m++;
                    }else if(twoSum > twoSumTarget){
                        while(m < n && nums[n] == nums[n-1]) n--;
                        n--;
                    }else{
                        List<Integer> tempList = new LinkedList<>(Arrays.asList(nums[i],nums[j],nums[m],nums[n]));
                        list.add(tempList);
                        while(m < n && nums[m] == nums[m+1]) m++;
                        m++;
                        while(m < n && nums[n] == nums[n-1]) n--;
                        n--;
                    }
                }
            }
        }
        return list;
    }
}
*/

//20ms ver
/*
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(len<4) return ans;
        Arrays.sort(nums);

        int sum;//, idx=-1;
        for(int idx1=0; idx1<len-3;idx1++){
            for(int idx2 = len-1; idx1<idx2; idx2--){
                for(int idx3=idx1+1, idx4=idx2-1; idx3<idx4;idx3++, idx4--){
                    sum = nums[idx1]+nums[idx2]+nums[idx3]+nums[idx4];
                    if(sum<target){
                        while(idx3<idx4 && nums[idx3]==nums[idx3+1]) idx3++;
                        idx4++;
                    }
                    else if(sum>target){
                        while(idx4>idx3 && nums[idx4]==nums[idx4-1]) idx4--;
                        idx3--;
                    }
                    else{
                        ans.add(new Vector<Integer>(Arrays.asList(nums[idx1],nums[idx3], nums[idx4], nums[idx2])));
                        while(idx3<idx4 && nums[idx3]==nums[idx3+1]) idx3++;
                        while(idx4>idx3 && nums[idx4]==nums[idx4-1]) idx4--;
                    }
                }
                while(idx2>idx1 && nums[idx2]==nums[idx2-1]) idx2--;
            }
            while(idx1<len-3 && nums[idx1]==nums[idx1+1]) idx1++;
        }
        return ans;
    }
}
*/
//41ms ver
/*
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(len<4) return ans;
        Arrays.sort(nums);

        int sum;//, idx=-1;
        for(int idx1=0; idx1<len-3;idx1++){
            for(int idx2 = len-1; idx1<idx2; idx2--){
                for(int idx3=idx1+1, idx4=idx2-1; idx3<idx4;idx3++, idx4--){
                    sum = nums[idx1]+nums[idx2]+nums[idx3]+nums[idx4];
                    if(sum<target){
                        while(idx3<idx4 && nums[idx3]==nums[idx3+1]) idx3++;
                        idx4++;
                    }
                    else if(sum>target){
                        while(idx4>idx3 && nums[idx4]==nums[idx4-1]) idx4--;
                        idx3--;
                    }
                    else{
                        ans.add(new Vector<Integer>(Arrays.asList(nums[idx1],nums[idx3], nums[idx4], nums[idx2])));
                        while(idx3<idx4 && nums[idx3]==nums[idx3+1]) idx3++;
                        while(idx4>idx3 && nums[idx4]==nums[idx4-1]) idx4--;
                    }
                }
                while(idx2>idx1 && nums[idx2]==nums[idx2-1]) idx2--;
            }
            while(idx1<len-3 && nums[idx1]==nums[idx1+1]) idx1++;
        }
        return ans;
    }
}
*/

public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{1,0,-1,0,-2,2},{2,2,2,2,2},{-3,-1,0,2,4,5},{0,0,0,1000000000,1000000000,1000000000,1000000000}};
                            //-2,-1,0,0,1,2
        int[] targets = {0,8,0,1000000000};
        Solution tt = new Solution();
        for(int i=0; i<inputs.length; i++){
            System.out.println(tt.fourSum(inputs[i], targets[i]));
            System.out.println("===========================================");
        }
    }
}
