package com.Q404_Sum_of_Left_Leaves;


import com.BinaraTreeConstructor.*;
import com.TreeNode.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

//0ms ver
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null){
            return 0;
        }
        else{
            return leftLeaf(root.left) + rightLeaf(root.right);
        }
    }

    public int leftLeaf(TreeNode root){
        if(root==null){
            return 0;
        }
        else if(root.left==null && root.right==null){
            return root.val;
        }
        else{
            return leftLeaf(root.left) + rightLeaf(root.right);
        }
    }

    public int rightLeaf(TreeNode root){
        if(root==null){
            return 0;
        }
        else{
            return leftLeaf(root.left) + rightLeaf(root.right);
        }
    }
}

//Another 0ms ver
/*
class Solution {

    public int sumOfLeftLeaves(TreeNode root) {

        if(root == null)
            return 0;

        if(root.left != null && root.left.left == null && root.left.right == null)
            return root.left.val + sumOfLeftLeaves(root.right);

        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
 */

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> inputs = new ArrayList<>();
        inputs.add(new ArrayList<>(){{
            add(3);
            add(9);
            add(20);
            add(null);
            add(null);
            add(15);
            add(7);
        }});
        inputs.add(new ArrayList<>(){{
            add(1);
        }});

        TreeNode head;

        BinaryTreeConstructor btc = new BinaryTreeConstructor();
        Solution solution = new Solution();

        for(List<Integer> input : inputs){
            btc.construct(input);
            head = btc.getRoot();
            System.out.println(solution.sumOfLeftLeaves(head));
            System.out.println("=========");
        }

    }
}
