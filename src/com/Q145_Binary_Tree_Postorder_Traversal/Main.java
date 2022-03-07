package com.Q145_Binary_Tree_Postorder_Traversal;

import java.util.ArrayList;
import java.util.List;
import com.TreeNode.*;
import com.BinaraTreeConstructor.*;


class Solution {
    public void myPostorderTraversal(List<Integer> result, TreeNode node){
        if(node.left!=null){
            myPostorderTraversal(result, node.left);
        }
        if(node.right!=null){
            myPostorderTraversal(result, node.right);
        }
        result.add(node.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root!=null){
            myPostorderTraversal(result, root);
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
        BinaryTreeConstructor btc = new BinaryTreeConstructor();
        Solution solution = new Solution();
        for(List<Integer> input : inputs){
            TreeNode head = btc.construct(input);
            System.out.println(solution.postorderTraversal(head));
        }
    }
}
