package com.Q144_Binary_Tree_Preorder_Traversal;

import com.BinaraTreeConstructor.*;
import com.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import com.BinaraTreeConstructor.*;


class Solution {
    public void myPreorderTraversal(List<Integer> result, TreeNode node){
        result.add(node.val);
        if(node.left!=null){
            myPreorderTraversal(result, node.left);
        }
        if(node.right!=null){
            myPreorderTraversal(result, node.right);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root!=null){
            myPreorderTraversal(result, root);
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> inputs = new ArrayList<>();
        inputs.add(new ArrayList<>(){{
            add(1);
            add(null);
            add(2);
            add(3);
        }});
        inputs.add(new ArrayList<>());
        inputs.add(new ArrayList<>(){{
            add(1);
        }});
        inputs.add(new ArrayList<>(){{
            add(3);
            add(1);
            add(2);
        }});

        BinaryTreeConstructor btc = new BinaryTreeConstructor();
        Solution solution = new Solution();
        for(List<Integer> input : inputs){
            TreeNode head = btc.construct(input);
            System.out.println(solution.preorderTraversal(head));
        }
    }
}
