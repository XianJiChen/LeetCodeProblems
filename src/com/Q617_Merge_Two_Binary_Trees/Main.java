package com.Q617_Merge_Two_Binary_Trees;

import com.TreeNode.TreeNode;

//1ms
/*
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode root = new TreeNode();
        root.val = getValueOfTreeNode(root1) + getValueOfTreeNode(root2);
        root.left = mergeTrees(getLeftNode(root1), getLeftNode(root2));
        root.right = mergeTrees(getRightNode(root1), getRightNode(root2));
        return root;
    }

    public int getValueOfTreeNode(TreeNode node) {
        return (node == null) ? 0 : node.val;
    }

    public TreeNode getLeftNode(TreeNode node) {
        return (node == null) ? null : node.left;
    }

    public TreeNode getRightNode(TreeNode node) {
        return (node == null) ? null : node.right;
    }
}
*/

//0ms ver
class Solution {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        TreeNode new_node = new TreeNode(t1.val + t2.val);

        new_node.left = mergeTrees(t1.left, t2.left);
        new_node.right = mergeTrees(t1.right, t2.right);

        return new_node;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
