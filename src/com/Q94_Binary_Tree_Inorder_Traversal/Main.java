package com.Q94_Binary_Tree_Inorder_Traversal;
import com.TreeNode.*;

import java.util.ArrayList;
import java.util.List;
import com.BinaraTreeConstructor.*;


class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return new ArrayList<Integer>();
        }
        else{
            List<Integer> ans = new ArrayList<>();
            ans.addAll(inorderTraversal(root.left));
            ans.add(root.val);
            ans.addAll(inorderTraversal(root.right));
            return ans;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> inputs = new ArrayList<>();
        inputs.add(new ArrayList<Integer>());
        inputs.get(0).add(1);
        inputs.get(0).add(null);
        inputs.get(0).add(2);
        inputs.get(0).add(3);
        inputs.add(new ArrayList<Integer>());
        inputs.add(new ArrayList<Integer>());
        inputs.get(2).add(1);
        System.out.println(inputs.get(2));
        System.out.println("-----------------");
//        inputs.clear();
//        inputs.add(new ArrayList<>());
//        inputs.get(0).add(1);
//        System.out.println(inputs.get(0));
//        System.out.println("----------------");

        BinaryTreeConstructor bt = new BinaryTreeConstructor();
        Solution tt = new Solution();
        for(List<Integer> arr : inputs){
            TreeNode tn = bt.newConstruct(arr);
            System.out.println(tt.inorderTraversal(tn).toString());
            System.out.println("==============================");
        }

    }
}
