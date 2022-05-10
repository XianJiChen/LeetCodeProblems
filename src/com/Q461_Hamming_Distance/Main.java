package com.Q461_Hamming_Distance;

class Solution {
    public int hammingDistance(int x, int y) {
        int n = x^y;
        int oneCount = 0;

        while(n >= 1)
        {
            if(n % 2 == 1)
            {
                oneCount++;
            }

            n = n / 2;
        }
        return oneCount;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] xs = {1,3};
        int[] ys = {4,1};
        Solution solution = new Solution();
        for(int i=0; i<xs.length; i++){
            System.out.println(solution.hammingDistance(xs[i],ys[i]));
            System.out.println("========");
        }
    }
}
