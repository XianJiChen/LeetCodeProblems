package com.Q338_Counting_Bits;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
//        ans[0] = 0;
//        int bar = 1;
//        int range = 2;
//        for(int i=1; i<=n; i++){
//            if(i==bar){
//                bar *= 2;
//            }
//        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] inputs = {2,5};
        Solution solution = new Solution();
        for(int input : inputs){
            System.out.println(Arrays.toString(solution.countBits(input)));
            System.out.println("---------");
        }
    }
}
