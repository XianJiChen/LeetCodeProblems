package com.BinarySearchTree;

import java.util.List;

public class BinarySearchTree {
    private BinarySearchTreeNode root;

    public BinarySearchTree(int[] values){
        this.root = null;
        for(int value : values){
            this.add(this.root, value);
        }
    }


    public void add(BinarySearchTreeNode node,int val){
        if(this.root==null){
            this.root = new BinarySearchTreeNode(val);
        }
        else{
            if(val>node.val){
                if(node.right == null){
                    node.right = new BinarySearchTreeNode(val);
                    node.rightMaxHeight++;
                }
                else{
                    add(node.right, val);
                }
            }
            else{
                if(node.left == null){
                    node.left = new BinarySearchTreeNode(val);
                    node.leftMaxHeight++;
                }
                else{
                    add(node.left, val);
                }
            }
            node.updateHeight();
        }
    }


    public BinarySearchTree(List<Integer> arr){

    }
}
