package com.Q88_Merge_Sorted_Array;

import java.util.Arrays;

//0ms ver
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cnt = 0;
        int idx1 = 0;
        int idx2 = 0;
        /**
         * idx1-idx2==m: nums1 is all used
         * idx2==n: nums2 is all used
         */
        while(idx1-idx2<m && idx2<n){
           if(nums1[idx1]>nums2[idx2]){
               System.arraycopy(nums1, idx1, nums1,idx1+1,m-(idx1-idx2));
               nums1[idx1] = nums2[idx2];
               idx2++;
           }
           idx1++;
        }
        if(idx1-idx2==m){
            System.arraycopy(nums2, idx2, nums1, idx1, n-idx2);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int numOfTestCases = 2;
        int[][] nums1s = {{1,2,3,0,0,0},{1}};
        int[][] nums2s = {{2,5,6},{}};
        int[] ms = {3,1};
        int[] ns = {3,0};
        Solution tt = new Solution();
        for(int i=0; i<numOfTestCases; i++){
            System.out.println(Arrays.toString(nums1s[i]));
            System.out.println("----------------------------");
            tt.merge(nums1s[i], ms[i], nums2s[i], ns[i]);
            System.out.println(Arrays.toString(nums1s[i]));
            System.out.println("============================");
        }
    }
}
