package com.Q448_Find_All_Numbers_Disappeared_in_an_Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

//70ms ver
/*
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> nSet = new HashSet<>();
        HashSet<Integer> numSet = new HashSet<>();
        for(int i=1; i<=nums.length; i++){
            nSet.add(i);
        }

        for(int num : nums){
            numSet.add(num);
        }

        nSet.removeAll(numSet);

        return nSet.stream().toList();
    }
}
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        List<Integer> myNums = Arrays.stream(nums).boxed().toList();

        for(int i=1; i<=nums.length; i++){
            if(!myNums.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] numss = {{4,3,2,7,8,2,3,1},{1,1}};
        Solution solution = new Solution();
        for(int[] nums : numss){
            System.out.println(solution.findDisappearedNumbers(nums));
            System.out.println("==========");
        }
    }
}
