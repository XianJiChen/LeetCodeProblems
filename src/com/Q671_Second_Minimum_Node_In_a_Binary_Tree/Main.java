package com.Q671_Second_Minimum_Node_In_a_Binary_Tree;

import com.BinaraTreeConstructor.BinaryTreeConstructor;
import com.TreeNode.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    private int min;
    private int secondMin;
    boolean added;
    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;
        secondMin = Integer.MAX_VALUE;
        added = false;
        myFind(root.left);
        myFind(root.right);
        return (added) ? secondMin : -1;
    }

    private void myFind(TreeNode root){
        if(root==null){
            return;
        }
        else{
            if(root.val<=secondMin){
                if(root.left==null){
                    if(root.val != min){
                        secondMin = Math.min(secondMin, root.val);
                        added = true;
                    }
                }
                else {
                    myFind(root.left);
                    myFind(root.right);
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Integer[][] inputs = {{2,2,5,null,null,5,7},{2,2,2},{1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1}};
        BinaryTreeConstructor btc = new BinaryTreeConstructor();
        Solution solution = new Solution();

        for(Integer[] input : inputs){
            btc.construct(Arrays.asList(input));
            System.out.println(solution.findSecondMinimumValue(btc.getRoot()));
            System.out.println("==========");
        }
    }
}
