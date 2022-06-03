package com.Q598_Range_Addition_II;

class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int mMin = m;
        int nMin = n;
        for (int[] op : ops) {
            mMin = Math.min(mMin, op[0]);
            nMin = Math.min(nMin, op[1]);
        }
        return mMin * nMin;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] ms = {3, 3, 3};
        int[] ns = {3, 3, 3};
        int[][][] opss = {{{2, 2}, {3, 3}}, {{2, 2}, {3, 3}, {3, 3}, {3, 3}, {2, 2}, {3, 3}, {3, 3}, {3, 3}, {2, 2}, {3, 3}, {3, 3}, {3, 3}}, {}};
        Solution solution = new Solution();
        for (int i = 0; i < ms.length; i++) {
            System.out.println(solution.maxCount(ms[i], ns[i], opss[i]));
            System.out.println("================");
        }
    }
}
