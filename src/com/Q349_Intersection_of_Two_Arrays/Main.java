package com.Q349_Intersection_of_Two_Arrays;

import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for(int num : nums1){
            set1.add(num);
        }
        HashSet<Integer> set2 = new HashSet<Integer>();
        for(int num : nums2){
            set2.add(num);
        }
        set1.retainAll(set2);
        int[] ans = new int[set1.size()];
        int i=0;
        for(int j : set1){
            ans[i++] = j;
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] nums1s = {{1,2,2,1},{4,9,5}};
        int[][] nums2s = {{2,2},{9,4,9,8,4}};
        Solution solution = new Solution();
        for(int i=0; i< nums1s.length; i++){
            System.out.println(Arrays.toString(solution.intersection(nums1s[i],nums2s[i])));
            System.out.println("======");
        }
    }
}
