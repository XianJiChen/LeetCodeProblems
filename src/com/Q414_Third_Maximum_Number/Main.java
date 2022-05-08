package com.Q414_Third_Maximum_Number;

import java.util.*;
import java.util.stream.Stream;

import static java.util.TimeZone.LONG;

//9ms ver
/*
class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> st = new TreeSet<Integer>();
        for(int num : nums){
            st.add(num);
        }
        Iterator<Integer> iterator = st.descendingIterator();
        int ans=0;
        if(st.size()<3){
            return iterator.next();
        }
        else{
            for(int i=0; i<3;i++){
                ans = iterator.next();
            }
            return ans;
        }
    }
}
*/

//7ms ver
/*
class Solution {
    public int thirdMax(int[] nums) {
        Queue<Integer> test = new PriorityQueue<Integer>();
        for(int num : nums){
            if(!test.contains(num)){
                test.add(num);
            }
            if(test.size()>3){
                test.poll();
            }
        }
        if(test.size()==3){
            return test.poll();
        }
        else{
            int ans=0;
            while (!test.isEmpty()){
                ans = test.poll();
            }
            return ans;
        }
    }
}
*/
//1ms ver
class Solution {
    public int thirdMax(int[] nums) {
        long[] maxs = {Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE};

        for(int num : nums){
            if(num!=maxs[0] && num!=maxs[1] && num!=maxs[2]) {
                if (num > maxs[0]) {
                    maxs[2] = maxs[1];
                    maxs[1] = maxs[0];
                    maxs[0] = num;
                } else if (num > maxs[1]) {
                    maxs[2] = maxs[1];
                    maxs[1] = num;
                } else if (num > maxs[2]) {
                    maxs[2] = num;
                }
            }
        }
        if(maxs[0]!= Long.MIN_VALUE && maxs[1]!= Long.MIN_VALUE && maxs[2]!= Long.MIN_VALUE){
            return (int)maxs[2];
        }
        else{
            return (int) maxs[0];
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{3,2,1},{1,2},{2,2,3,1},{1,2,-2147483648}};
        Solution solution = new Solution();
        for(int[] input : inputs){
            System.out.println(solution.thirdMax(input));
            System.out.println("-------------");
        }
    }
}
