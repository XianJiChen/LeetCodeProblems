package com.Q496_Next_Greater_Element_I;

import java.util.Arrays;

//1ms ver
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int max = -1;
        int[] idxs = new int[10001];
        for(int i=0; i<nums2.length; i++){
            idxs[nums2[i]] = i;
            if(nums2[i]>max){
                max = nums2[i];
            }
        }
        int[] ans = new int[nums1.length];
        int nextMax;
        for(int i=0, numIdx; i<nums1.length; i++){
            numIdx = idxs[nums1[i]];
            nextMax=-1;
            if(nums1[i]<max){
                for(int j=numIdx+1; j<nums2.length; j++){
                    if(nums2[j]>nums2[numIdx]){
                        nextMax = nums2[j];
                        break;
                    }
                }
            }
            ans[i] = nextMax;
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] nums1s = {{4,1,2},{2,4}};
        int[][] nums2s = {{1,3,4,2},{1,2,3,4}};
        Solution solution = new Solution();
        for(int i=0; i< nums1s.length; i++){
            System.out.println(Arrays.toString(solution.nextGreaterElement(nums1s[i], nums2s[i])));
            System.out.println("===========");
        }
    }
}
