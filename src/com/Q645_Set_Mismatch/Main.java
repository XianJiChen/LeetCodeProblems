package com.Q645_Set_Mismatch;

import java.util.Arrays;
import java.util.HashSet;

//11ms ver
/*
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            if (numSet.contains(num)) {
                ans[0] = num;
            } else {
                numSet.add(num);
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!numSet.contains(i)) {
                ans[1] = i;
                break;
            }
        }
        return ans;
    }
}
 */

//2ms ver

/*
class Solution {
    public int[] findErrorNums(int[] nums) {
        int xor = 0;
        for(int i = 1; i <= nums.length; i++) {
            xor ^= i;
        }
        for(int num : nums){
            xor ^= num;
        }
        int diffBit = xor & (~(xor - 1)), a = 0;
        for(int i = 0; i < nums.length; i++) {
            if((diffBit & nums[i]) != 0) {
                a ^= nums[i];
            }
            if((diffBit & (i + 1)) != 0) {
                a ^= (i + 1);
            }
        }
        for(int num: nums) {
            if(num == a) {
                return new int[] {a, xor ^ a};
            }
        }
        return new int[] {xor ^ a, a};
    }
}
*/

//1ms ver
class Solution {
    public int[] findErrorNums(int[] nums) {
        boolean[] visited = new boolean[10001];
        int duplicate = 0, sum = 0, n = nums.length;
        for (int i: nums) {
            if (visited[i]) {
                duplicate = i;
            }
            visited[i] = true;
            sum += i;
        }
        int nsum =  (n * (n+1)) / 2;
        return new int[] {duplicate, duplicate + nsum - sum};
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{1, 2, 2, 4}, {1, 1}, {2, 2}, {3, 2, 2}, {1, 3, 3}, {3, 2, 3, 4, 6, 5}};
        Solution solution = new Solution();
        for (int[] input : inputs) {
            System.out.println(Arrays.toString(solution.findErrorNums(input)));
            System.out.println("==========");
        }
    }
}
