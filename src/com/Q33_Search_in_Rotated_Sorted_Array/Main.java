package com.Q33_Search_in_Rotated_Sorted_Array;

class Solution {
    int[] myNums;
    int myTarget;

    public int search(int[] nums, int target) {
        myNums = nums;
        myTarget = target;
        return mySearch(0, nums.length - 1);
    }

    private int mySearch(int l, int r) {
        if (l >= r) {
            return (myTarget == myNums[l]) ? l : -1;
        }
        int mid = (l + r) / 2;
        if (myTarget == myNums[mid]) {
            return mid;
        } else if (myTarget < myNums[mid]) {
            if (myNums[l] < myNums[r]) {
                System.out.println("AAA");
                return mySearch(l, mid - 1);
            } else {
                if ((myNums[mid] > myNums[r] && myTarget >= myNums[l]) || (myNums[mid] < myNums[l])) {
                    return mySearch(l, mid - 1);
                } else {
                    return mySearch(mid + 1, r);
                }
            }
        } else { //if(myTarget > myNums[mid]){
            if (myNums[l] < myNums[r]) {
                return mySearch(mid + 1, r);
            } else {
                if ((myNums[mid] > myNums[r]) || (myNums[mid] < myNums[l] && myTarget <= myNums[r])) {
                    return mySearch(mid + 1, r);
                } else {
                    return mySearch(l, mid - 1);
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{4, 5, 6, 7, 0, 1, 2}, {4, 5, 6, 7, 0, 1, 2}, {1}, {1, 3}};
        int[] ks = {0, 3, 0, 0};
        Solution solution = new Solution();
        for (int i = 0; i < inputs.length; i++) {
            System.out.println(solution.search(inputs[i], ks[i]));
            System.out.println("========");
        }
    }
}
