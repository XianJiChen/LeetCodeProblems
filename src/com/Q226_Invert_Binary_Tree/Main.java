package com.Q226_Invert_Binary_Tree;


import com.BinaraTreeConstructor.BinaryTreeConstructor;
import com.TreeNode.*;

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode tmp;
        tmp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = tmp;
        return root;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{4,2,7,1,3,6,9},{2,1,3},{}};
        BinaryTreeConstructor btc = new BinaryTreeConstructor();
        TreeNode head;
        Solution solution = new Solution();
        for(int[] input : inputs){
            head = btc.construct(input);
            head = solution.invertTree(head);
            System.out.println(btc.inorderTraversal(head));
            System.out.println("-----------------------");
        }
    }
}
