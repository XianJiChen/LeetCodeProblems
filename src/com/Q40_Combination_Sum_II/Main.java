package com.Q40_Combination_Sum_II;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//other solutions
//https://leetcode.com/problems/combination-sum-ii/discuss/1213780/3-backtracking-variations-Java-beats-100

//3ms ver
class Solution {
    private List<List<Integer>> ans;
    private boolean[] isAvailableDigit;
    private int[] tmpAns;
    private int tmpAnsIdx;
    private int[] myCandidates;
    private int myTarget;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ans = new LinkedList<>();
        isAvailableDigit = new boolean[200];
        tmpAns = new int[150];
        tmpAnsIdx = 0;
        myCandidates = candidates;
        myTarget = target;
        findCombinations(0, 0);
        return ans;
    }

    private void findCombinations(int idx, int sum) {
        if (sum == this.myTarget) {
            addToAns();
        } else if (sum > this.myTarget || idx == this.myCandidates.length) {
            return;
        } else {
            if (sum + myCandidates[idx] == myTarget) {
                //System.out.println("BBB");
                tmpAns[tmpAnsIdx++] = myCandidates[idx];
                addToAns();
                tmpAns[--tmpAnsIdx] = 0;
            } else if (sum + myCandidates[idx] < myTarget) {
                tmpAns[tmpAnsIdx++] = myCandidates[idx];
                findCombinations(idx + 1, sum + myCandidates[idx]);
                tmpAns[--tmpAnsIdx] = 0;
            }
            while (idx < myCandidates.length - 1 && myCandidates[idx] == myCandidates[idx + 1]) {
                idx++;
            }
            findCombinations(idx + 1, sum);
        }
    }

    private void addToAns() {
        List<Integer> tmpList = new LinkedList<>();
        for (int i = 0; i < 150 && tmpAns[i] != 0; i++) {
            tmpList.add(tmpAns[i]);
        }
        ans.add(tmpList);
    }

}


public class Main {
    public static void main(String[] args) {

    }
}
