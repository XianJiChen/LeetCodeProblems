package com.BinarySearchTree;

public class BinarySearchTreeNode {
    public int val;
    public BinarySearchTreeNode left;
    public BinarySearchTreeNode right;
    public int maxHeight;
    public int leftMaxHeight;
    public int rightMaxHeight;
    public BinarySearchTreeNode(int val) { this.val = val; }
    public BinarySearchTreeNode(int val, BinarySearchTreeNode left, BinarySearchTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.maxHeight = 1;
        this.leftMaxHeight = 0;
        this.rightMaxHeight = 0;
    }

    public void updateHeight(){
        this.leftMaxHeight = (this.left==null) ? 0 : this.left.maxHeight;
        this.rightMaxHeight = (this.right==null) ? 0 : this.right.maxHeight;
        this.maxHeight = Math.max(leftMaxHeight,rightMaxHeight)+1;
    }
}
