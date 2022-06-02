package com.Q543_Diameter_of_Binary_Tree;

import com.BinaraTreeConstructor.BinaryTreeConstructor;
import com.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private int passingMax;
    public int diameterOfBinaryTree(TreeNode root) {
        passingMax = 0;
        int rootLeft = (root.left==null) ? 0 : myDiameterOfBinaryTree(root.left) + 1;
        int rootRight = (root.right==null) ? 0 : myDiameterOfBinaryTree(root.right) + 1;
        return Math.max(rootLeft + rootRight, passingMax);
    }

    private int myDiameterOfBinaryTree(TreeNode root) {
        if(root.left==null && root.right==null){
            return 0;
        }
        else if(root.left==null){
            return myDiameterOfBinaryTree(root.right) + 1;
        }
        else if(root.right==null){
            return myDiameterOfBinaryTree(root.left) + 1;
        }
        else{
            int left = myDiameterOfBinaryTree(root.left);
            int right = myDiameterOfBinaryTree(root.right);
            passingMax = Math.max(passingMax, left+ right + 2);
            return Math.max(left,right) + 1;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> inputs = new ArrayList<>();

        Integer[][] inputArrs = {{1,2,3,4,5},{1,2},{37,-34,-48,null,-100,-100,48,null,null,null,null,-54,null,-71,-22,null,null,null,8},{-64,12,18,-4,-53,null,76,null,-51,null,null,-93,3,null,-31,47,null,3,53,-81,33,4,null,-51,-44,-60,11,null,null,null,null,78,null,-35,-64,26,-81,-31,27,60,74,null,null,8,-38,47,12,-24,null,-59,-49,-11,-51,67,null,null,null,null,null,null,null,-67,null,-37,-19,10,-55,72,null,null,null,-70,17,-4,null,null,null,null,null,null,null,3,80,44,-88,-91,null,48,-90,-30,null,null,90,-34,37,null,null,73,-38,-31,-85,-31,-96,null,null,-18,67,34,72,null,-17,-77,null,56,-65,-88,-53,null,null,null,-33,86,null,81,-42,null,null,98,-40,70,-26,24,null,null,null,null,92,72,-27,null,null,null,null,null,null,-67,null,null,null,null,null,null,null,-54,-66,-36,null,-72,null,null,43,null,null,null,-92,-1,-98,null,null,null,null,null,null,null,39,-84,null,null,null,null,null,null,null,null,null,null,null,null,null,-93,null,null,null,98}};

        for(Integer[] inputArr : inputArrs){
            inputs.add(new ArrayList<>(){{
                for(Integer integer : inputArr){
                    add(integer);
                }
            }});
        }

        BinaryTreeConstructor btc = new BinaryTreeConstructor();
        Solution solution = new Solution();
        for(List<Integer> input : inputs){
            btc.construct(input);
            System.out.println(btc.inorderTraversal(btc.getRoot()));
            System.out.println(solution.diameterOfBinaryTree(btc.getRoot()));
            System.out.println("=============");
        }
    }
}
