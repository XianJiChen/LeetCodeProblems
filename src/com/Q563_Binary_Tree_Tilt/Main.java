package com.Q563_Binary_Tree_Tilt;

import com.BinaraTreeConstructor.BinaryTreeConstructor;
import com.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//0ms ver
class Solution {
    private int tilt;
    public int findTilt(TreeNode root) {
        this.tilt = 0;
        findSingleTilt(root);
        return this.tilt;
    }

    public int findSingleTilt(TreeNode root){
        if(root==null){
            return 0;
        }
        else{
            int left = findSingleTilt(root.left);
            int right = findSingleTilt(root.right);
            this.tilt += Math.abs(left - right);
            return left + right + root.val;
        }
    }
}




public class Main {
    public static void main(String[] args) {
        List<List<Integer>> inputs = new ArrayList<>();

        Integer[][] inputArrs = {{1,2,3},{4,2,9,3,5,null,7},{21,7,14,1,1,2,2,3,3}};

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
            System.out.println(solution.findTilt(btc.getRoot()));
            System.out.println("=============");
        }
    }
}
