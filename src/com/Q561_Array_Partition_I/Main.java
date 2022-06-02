package com.Q561_Array_Partition_I;

import java.util.Arrays;

//36ms ver
/*
class Solution {
    public int[] Mergesort(int[] arr, int l, int r) {
        if (l == r) {
            return new int[]{arr[l]};
        }
        int mid = (l + r) / 2;
        int[] leftArr = Mergesort(arr, l, mid);
        int[] rightArr = Mergesort(arr, mid + 1, r);
        int[] ans = new int[leftArr.length + rightArr.length];
        int i = 0;
        int j = 0;
        int k = 0;
        for (; i < leftArr.length && j < rightArr.length; k++) {
            ans[k] = (leftArr[i] <= rightArr[j]) ? leftArr[i++] : rightArr[j++];
        }
        if (i!=leftArr.length){
            System.arraycopy(leftArr,i,ans,k,leftArr.length-i);
        }
        else{
            System.arraycopy(rightArr,j,ans,k,rightArr.length-j);
        }
        return ans;
    }

    public int arrayPairSum(int[] nums) {
        nums = Mergesort(nums, 0, nums.length-1);
        int sum = 0;
        for(int i=0; i<nums.length; i+=2){
            sum += nums[i];
        }

        return sum;
    }
}
*/

//13ms ver
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for(int itr = 0; itr < nums.length; itr += 2){
            result += nums[itr];
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{1, 4, 3, 2}, {6, 2, 6, 5, 1, 2}};
        Solution solution = new Solution();
        for (int[] input : inputs) {
            //System.out.println(Arrays.toString(solution.Mergesort(input, 0, input.length - 1)));
            System.out.println(solution.arrayPairSum(input));
            System.out.println("=========");
        }
    }
}
