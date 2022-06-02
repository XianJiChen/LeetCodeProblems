package com.Q530_Minimum_Absolute_Difference_in_BST;

import com.BinaraTreeConstructor.*;
import com.TreeNode.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
class Solution {
    private List<Integer> nums = new LinkedList<>();
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        getNums(root);
        for(int i=1; i<nums.size(); i++){
            min = Math.min(min, Math.abs(nums.get(i)-nums.get(i-1)));
        }
        return min;
    }
    private void getNums(TreeNode root){
        if(root.left!=null){
            getNums(root.left);
        }
        nums.add(root.val);
        if(root.right!=null){
            getNums(root.right);
        }
    }
}
*/

/*
if a-(b-c)<(b-c)

*/


class Solution {
    private int prevVal = Integer.MAX_VALUE;
    private int minDiff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root == null)
            return 0;

        getMinimumDifference(root.right);
        minDiff = Math.min(minDiff, prevVal-root.val);
        prevVal = root.val;
        getMinimumDifference(root.left);

        return minDiff;
    }
}

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> inputs = new ArrayList<>();
        inputs.add(new ArrayList<>(){{
            add(4);
            add(2);
            add(6);
            add(1);
            add(3);
        }});
        inputs.add(new ArrayList<>(){{
            add(1);
            add(0);
            add(4);
            add(8);
            add(null);
            add(null);
            add(12);
            add(49);
        }});

        BinaryTreeConstructor btc = new BinaryTreeConstructor();
        Solution solution = new Solution();
        for(List<Integer> input : inputs){
            btc.construct(input);
            System.out.println(solution.getMinimumDifference(btc.getRoot()));
            System.out.println("======");
        }
    }
}
