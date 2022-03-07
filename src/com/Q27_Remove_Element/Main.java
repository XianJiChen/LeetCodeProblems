package com.Q27_Remove_Element;

//0ms ver little less memory
class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int k=0;
        for(int idx=0; idx<len-k; idx++){
            if(nums[idx]==val){
                //if(next_non_val<idx) next_non_val = idx;
                while(idx+k<len && nums[idx+k]==val){
                    k++;
                }
                if(idx+k>=len) break;
                nums[idx] = nums[idx+k];
                nums[idx+k] = val;
            }
        }
        return len-k;
    }
}
//0ms ver
/*
class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int k=0;
        for(int idx=0,next_non_val=0; idx<len-k && next_non_val<len; idx++,next_non_val++){
            if(nums[idx]==val){
                //if(next_non_val<idx) next_non_val = idx;
                while(next_non_val<len && nums[next_non_val]==val){
                    next_non_val++;
                    k++;
                }
                if(next_non_val>=len) break;
                nums[idx] = nums[next_non_val];
                nums[next_non_val] = val;
            }
        }
        return len-k;
    }
}
*/

public class Main {
    public static void main(String[] args) {
        int[] t1 = {1,1,1,1};
        int[] t2 = {2,2};
        int tmp;
        int[][] inputs = {{3,2,2,3},{0,1,2,2,3,0,4,2},{1},{3,3}};
        int[] vals = {3,2,1,3};
        Solution tt = new Solution();
        for(int i=0; i<inputs.length; i++){
            tmp = tt.removeElement(inputs[i], vals[i]);
            for(int j=0; j<tmp; j++) System.out.println(inputs[i][j]);
            System.out.println("=================");
        }
    }
}
