package com.Q112_Path_Sum;

import com.TreeNode.*;
import com.BinaraTreeConstructor.*;

import java.util.ArrayList;
import java.util.List;

//0ms ver
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        else if(root.left==null && root.right==null){
            return (root.val==targetSum);
        }
        else{
            return (hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> inputs = new ArrayList<>();
        inputs.add(new ArrayList<>(){{
            add(5);
            add(4);
            add(8);
            add(11);
            add(null);
            add(13);
            add(4);
            add(7);
            add(2);
            add(null);
            add(null);
            add(null);
            add(1);
        }});
        inputs.add(new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
        }});
        inputs.add(new ArrayList<>());
        inputs.add(new ArrayList<>(){{
            add(1);
            add(2);
        }});
        List<Integer> targetSums = new ArrayList<>();
        targetSums.add(22);
        targetSums.add(5);
        targetSums.add(0);
        targetSums.add(1);
        BinaryTreeConstructor btc = new BinaryTreeConstructor();
        Solution tt = new Solution();
        for(int i=0; i<inputs.size(); i++){
            List<Integer> input = inputs.get(i);
            int targetSum = targetSums.get(i);
            TreeNode tn = btc.construct(input);
            System.out.println(input.toString());
            System.out.println(targetSum);
            System.out.println(tt.hasPathSum(tn, targetSum));
            System.out.println("==========================");
        }
    }
}
