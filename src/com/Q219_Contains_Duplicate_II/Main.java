package com.Q219_Contains_Duplicate_II;

import java.util.*;

//38ms ver
/*
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Integer val;
        for(int i=0; i< nums.length; i++){
            val = map.get(nums[i]);
            if(val != null && i-val<=k){
                return true;
            }
            else{
                map.put(nums[i],i);
            }
        }
        return false;
    }
}
*/
//12 ms ver
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}


public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{1,2,3,1},{1,0,1,1},{1,2,3,1,2,3}};
        int[] ks = {3,1,2};
        Solution solution = new Solution();
        for(int i=0; i<inputs.length; i++){
            System.out.println(solution.containsNearbyDuplicate(inputs[i], ks[i]));
            System.out.println("------------------");
        }
    }
}
