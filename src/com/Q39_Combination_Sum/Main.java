package com.Q39_Combination_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//3ms ver
class Solution {
    private List<List<Integer>> ans;
    private boolean[] isAvailableDigit;
    private int[] tmpAns;
    private int tmpAnsIdx;
    private int[] myCandidates;
    private int myTarget;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        if (sum > this.myTarget || idx == this.myCandidates.length) {
            return;
        } else {
            if (sum + myCandidates[idx] == myTarget) {
                //System.out.println("BBB");
                tmpAns[tmpAnsIdx++] = myCandidates[idx];
                addToAns();
                tmpAns[--tmpAnsIdx] = 0;
            } else if (sum + myCandidates[idx] < myTarget) {
                tmpAns[tmpAnsIdx++] = myCandidates[idx];
                findCombinations(idx, sum + myCandidates[idx]);
                tmpAns[--tmpAnsIdx] = 0;
            }
            findCombinations(idx + 1, sum);
        }
    }

    private void addToAns() {
        List<Integer> tmpList = new LinkedList<>();
        for(int i=0; i<150 && tmpAns[i]!=0; i++){
            tmpList.add(tmpAns[i]);
        }
        ans.add(tmpList);
    }

}

//4ms ver
/*
class Solution {
    private List<List<Integer>> ans = new LinkedList<>();
    private boolean[] isAvailableDigit = new boolean[200];
    private int[] tmpAns = new int[150];


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans.clear();
        findCombinations(candidates, target, 0, 0, new LinkedList<>());
        return ans;
    }

    private void findCombinations(int[] candidates, int target, int i, int sum, List<Integer> list) {
        if (sum == target) {
            ans.add(new ArrayList<>(list));
        } else if (sum > target || i == candidates.length) {
            return;
        } else {
            if (sum + candidates[i] <= target) {
                System.out.println(candidates[i]);
                list.add(candidates[i]);
                System.out.println(list);
                System.out.println(sum + candidates[i]);
                System.out.println("----");
                findCombinations(candidates, target, i, sum + candidates[i], list);
                if (sum + candidates[i] < sum) {
                    findCombinations(candidates, target, i + 1, sum + candidates[i], list);
                }
                list.remove(list.size() - 1);
            }
            findCombinations(candidates, target, i + 1, sum, list);
        }
    }
}
*/

public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{2, 3, 6, 7}, {2, 3, 5}};
        int[] targets = {7, 8};
        Solution solution = new Solution();
        for (int i = 0; i < inputs.length; i++) {
            System.out.println(solution.combinationSum(inputs[i], targets[i]));
            System.out.println("=========");
        }
    }
}
