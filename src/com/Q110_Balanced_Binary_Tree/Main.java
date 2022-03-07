package com.Q110_Balanced_Binary_Tree;
import com.BinaraTreeConstructor.*;
import com.TreeNode.*;

import java.util.ArrayList;
import java.util.List;

//1ms ver
class Solution {

    public int getLevel(TreeNode root){
        if(root.left==null && root.right==null){
            return 1;
        }
        else{
            int leftMaxHeight = (root.left==null) ? 0 : getLevel(root.left);
            int rightMaxHeight = (root.right==null) ? 0 : getLevel(root.right);
            return Math.max(leftMaxHeight,rightMaxHeight)+1;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        else if (root.left==null && root.right==null){
            return true;
        }
        else if(root.left==null){
            return (this.getLevel(root.right)<=1);

        }
        else if(root.right==null){
            return (this.getLevel(root.left)<=1);
        }
        else{
            return (this.isBalanced(root.left) && this.isBalanced(root.right) && Math.abs(this.getLevel(root.left)-this.getLevel(root.right))<=1);
        }
    }
}

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
            add(2);
            add(2);
            add(3);
            add(3);
            add(null);
            add(null);
            add(4);
            add(4);
        }});
        inputs.add(new ArrayList<>(){{
            add(1);
            add(2);
        }});
        inputs.add(new ArrayList<>(){{
            add(1);
            add(2);
            add(2);
            add(3);
            add(null);
            add(null);
            add(3);
            add(4);
            add(null);
            add(null);
            add(4);
        }});
        BinaryTreeConstructor bt = new BinaryTreeConstructor();
        Solution tt = new Solution();
        for(List<Integer> input : inputs){
            TreeNode tn = bt.newConstruct(input);

            System.out.println(bt.inorderTraversal(tn));
            System.out.println("----------------------------");
            System.out.println(tt.isBalanced(tn));
            System.out.println("========================");
        }
    }
}
