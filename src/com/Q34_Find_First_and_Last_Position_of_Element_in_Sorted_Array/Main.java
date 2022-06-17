package com.Q34_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

import java.util.Arrays;

//1ms ver
/*
class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findStart(nums, target, 0, nums.length - 1), findEnd(nums, target, 0, nums.length - 1)};
    }

    private int findStart(int[] nums, int target, int l, int r) {
        if (l > r) {
            return -1;
        } else if (l == r) {
            return (nums[l] == target) ? l : -1;
        }

        int mid = (l + r) / 2;

        if (nums[mid] == target) {
            if (mid == 0 || nums[mid - 1] != target) { //
                return mid;
            } else {
                return findStart(nums, target, l, r - 1);
            }
        } else if (nums[mid] < target) {
            return findStart(nums, target, mid + 1, r);
        } else {
            return findStart(nums, target, l, mid - 1);
        }
    }

    private int findEnd(int[] nums, int target, int l, int r) {
        if (l > r) {
            return -1;
        } else if (l == r) {
            return (nums[l] == target) ? l : -1;
        }

        int mid = (l + r) / 2;

        if (nums[mid] == target) {
            if (mid == nums.length - 1 || nums[mid + 1] != target) { //
                return mid;
            } else {
                return findEnd(nums, target, mid + 1, r);
            }
        } else if (nums[mid] < target) {
            return findEnd(nums, target, mid + 1, r);
        } else {
            return findEnd(nums, target, l, mid - 1);
        }
    }

}
*/

//0ms ver
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private int findFirst(int[] nums, int target) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            if (nums[mid] == target) idx = mid;
        }
        return idx;
    }

    private int findLast(int[] nums, int target) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            if (nums[mid] == target) idx = mid;
        }
        return idx;
    }

}

public class Main {
    public static void main(String[] args) {
        int[][] numss = {{5, 7, 7, 8, 8, 10}, {5, 7, 7, 8, 8, 10}, {}, {2, 2}};
        int[] targets = {8, 6, 0, 2};

        Solution solution = new Solution();
        for (int i = 0; i < numss.length; i++) {
            System.out.println(Arrays.toString(solution.searchRange(numss[i], targets[i])));
            System.out.println("===================");
        }
    }
}
