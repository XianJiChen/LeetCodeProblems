package com.Q136_Single_Number;

import java.util.HashSet;
import java.util.Queue;

//8ms ver
/*
class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> cnt = new HashSet<Integer>();
        for(int num:nums){
            if(cnt.contains(num)){
                cnt.remove(num);
            }
            else{
                cnt.add(num);
            }
        }
        for(Integer i:cnt){
            return i;
        }
        return 0;
    }
}
*/

//0ms ver
class Solution {
    public int singleNumber(int[] nums) {

        int a=0;

        for (int num:nums)
        {
            a^=num;
            System.out.println(a);
            System.out.println("----------------");
        }
        return a;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{2,2,2},{4,1,2,1,2},{3,3,5,5,7,5,5}};
        Solution solution = new Solution();
        for(int[] input:inputs){
            System.out.println(solution.singleNumber(input));
            System.out.println("==============");
        }
    }
}
