package com.Q111_Minimum_Depth_of_Binary_Tree;

import com.BinaraTreeConstructor.BinaryTreeConstructor;
import com.BinarySearchTree.BinarySearchTreeNode;
import com.TreeNode.*;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//6ms ver
/*
class Solution {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        else if(root.left!=null && root.right!=null){
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            return (left < right) ? left+1 : right+1;
        }
        else if(root.left==null && root.right==null){
            return 1;
        }
        else if(root.left==null){
            return minDepth(root.right)+1;
        }
        else if(root.right==null){
            return minDepth(root.left)+1;
        }
        else{
            return 0;
        }
    }
}
*/
//12 ms ver
/*
class Solution {

    public int minDepth1(TreeNode root){
//        System.out.println(root.val);
//        System.out.println(">>>");
        if(root==null){
            System.out.println("INT MAX");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");
            return Integer.MAX_VALUE;
        }
        else{
            int val =  Math.min(minDepth1(root.left),minDepth1(root.right));
            System.out.println((val==Integer.MAX_VALUE) ? 1 : val+1);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");
            return (val==Integer.MAX_VALUE) ? 1 : val+1;
        }
    }
    public int minDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        else{
            return minDepth1(root);
        }
    }
}
 */
//1ms ver
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 1;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                if (curr.left == null && curr.right == null) {
                    return depth;
                }
                if (curr.left != null) {
                    //queue.offer(curr.left);
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    //queue.offer(curr.right);
                    queue.add(curr.right);
                }
            }
            depth++;
        }
        return depth;
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
            add(2);
            add(null);
            add(3);
            add(null);
            add(4);
            add(null);
            add(5);
            add(null);
            add(6);
        }});
        BinaryTreeConstructor btc = new BinaryTreeConstructor();
        Solution tt = new Solution();
        for(List<Integer> input : inputs){
            TreeNode tn = btc.newConstruct(input);
            System.out.println(tt.minDepth(tn));
            System.out.println("==========================");
        }

    }
}
