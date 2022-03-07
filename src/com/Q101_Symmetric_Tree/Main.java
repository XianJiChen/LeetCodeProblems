package com.Q101_Symmetric_Tree;

import com.BinaraTreeConstructor.BinaryTreeConstructor;
import com.TreeNode.*;

import java.util.ArrayList;
import java.util.List;

//0ms ver
class Solution {
    public boolean isSymmetric1(TreeNode leftRoot, TreeNode rightRoot){
        if(leftRoot==null&&rightRoot==null){
            return true;
        }
        else if(leftRoot==null^rightRoot==null){
            return false;
        }
        else if(leftRoot.val!=rightRoot.val){
            return false;
        }
        else{
            return (isSymmetric1(leftRoot.left,rightRoot.right)&&isSymmetric1(leftRoot.right,rightRoot.left));
        }
    }
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric1(root.left,root.right);
    }
}

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> inputs = new ArrayList<>();
        inputs.add(new ArrayList<>(){{
            add(1);
            add(2);
            add(2);
            add(3);
            add(4);
            add(4);
            add(3);
        }});
        inputs.add(new ArrayList<>(){{
            add(1);
            add(2);
            add(2);
            add(null);
            add(3);
            add(null);
            add(3);
        }});
        BinaryTreeConstructor bt = new BinaryTreeConstructor();
        Solution tt = new Solution();
        for(List<Integer> input:inputs){
            TreeNode tn = bt.newConstruct(input);
            System.out.println(bt.inorderTraversal(tn));
            System.out.println("---------------");
            System.out.println(tt.isSymmetric(tn));
            System.out.println("==============================");
        }
    }
}
