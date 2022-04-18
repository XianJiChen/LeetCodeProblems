package com.Q350_Intersection_of_Two_Arrays_II;

import java.util.ArrayList;
import java.util.Arrays;

//2ms ver
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0, j=0; i< nums1.length&&j< nums2.length;){
            if(nums1[i]==nums2[j]){
                ans.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i]<nums2[j]){
                    i++;
            }
            else{
                j++;
            }
        }
        int[] a = new int[ans.size()];
        for(int i=0; i<a.length; i++){
            a[i] = ans.get(i);
        }
        return a;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] nums1s = {{1,2,2,1},{4,9,5}};
        int[][] nums2s = {{2,2},{9,4,9,8,4}};
        Solution solution = new Solution();
        for(int i=0; i< nums1s.length; i++) {
            System.out.println(Arrays.toString(solution.intersect(nums1s[i], nums2s[i])));
            System.out.println("====");
        }
    }
}
