package com.Q104_Maximum_Depth_of_Binary_Tree;

import com.BinaraTreeConstructor.BinaryTreeConstructor;
import com.TreeNode.*;

import java.util.ArrayList;
import java.util.List;


//0ms ver
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        else{
            return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
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
            add(null);
            add(2);
        }});
        BinaryTreeConstructor bt = new BinaryTreeConstructor();
        Solution tt = new Solution();
        for(List<Integer> input : inputs){
            TreeNode tn = bt.newConstruct(input);
            System.out.println(tt.maxDepth(tn));
            System.out.println("===================================");
        }
    }
}
