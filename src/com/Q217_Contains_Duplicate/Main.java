package com.Q217_Contains_Duplicate;

import java.util.HashSet;
import java.util.List;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }

    //can be further optimized to this version
    /*
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(!set.add(num)){
                return true;
            }
        }
        return false;
    }
     */
}



public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{1,2,3,1},{1,2,3,4},{1,1,1,3,3,4,3,2,4,2}};
        Solution solution = new Solution();
        for(int[] input : inputs){
            System.out.println(solution.containsDuplicate(input));
            System.out.println("---------------");
        }
    }
}
