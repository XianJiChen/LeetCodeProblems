package com.Q26_Remove_Duplicates_from_Sorted_Array;

//0ms 100%, 43.8MB 67.12%
class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length-1;
        if (nums==null||len==-1) return 0;
        int k=0;
        for(int i=0; i<len; i++){
            if(nums[i]==nums[i+1]) continue;
            else nums[k++] = nums[i];
        }
        nums[k++] = nums[len];
        return k;
    }
}

//1ms ver, 48.1MB 7.56% ver
/*
class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (nums==null||len==0) return 0;
        int k=0;
        for(int i=0; i<len; i++){
            if(i!=len-1 && nums[i]==nums[i+1]) continue;
            else nums[k++] = nums[i];
        }
        return k;
    }
}
*/
public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{1,1,2},{0,0,1,1,1,2,2,3,3,4}};
        Solution tt = new Solution();
        int t;
        for(int[] input:inputs){
            t = tt.removeDuplicates(input);
            for(int i=0; i<t; i++){
                System.out.println(input[i]);
            }
            System.out.println("================");
        }
    }
}
