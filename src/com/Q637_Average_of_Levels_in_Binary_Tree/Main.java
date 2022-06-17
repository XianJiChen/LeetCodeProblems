package com.Q637_Average_of_Levels_in_Binary_Tree;

import com.BinaraTreeConstructor.BinaryTreeConstructor;
import com.TreeNode.TreeNode;

import java.util.*;

//4ms ver
/*
class Solution {
    List<Double> ans;
    List<Integer> levelCnt;

    public List<Double> averageOfLevels(TreeNode root) {
        ans = new LinkedList<Double>();
        levelCnt = new LinkedList<>();
        myAverageOfLevels(root, 0);
        for(int i=0; i<ans.size(); i++){
            ans.set(i, ans.get(i)/levelCnt.get(i));
        }
        return ans;
    }

    public void myAverageOfLevels(TreeNode root, int level) {
        if(root!=null){
            if(level>=this.ans.size()){
                ans.add((double)root.val);
                levelCnt.add(1);
            }
            else{
                ans.set(level, ans.get(level) + root.val);
                levelCnt.set(level, levelCnt.get(level)+1);
            }
            myAverageOfLevels(root.left, level+1);
            myAverageOfLevels(root.right, level+1);
        }
    }
}
*/

//1ms ver
class Solution {
    List<Double> ans;
    int cnt;
    double ttl;
    public List<Double> averageOfLevels(TreeNode root) {
        ans = new LinkedList<>();
        List<TreeNode> rootList = new LinkedList<>();
        rootList.add(root);
        myAverageOfLevels(rootList);
        return ans;
    }

    public void myAverageOfLevels(List<TreeNode> nodesToProcess) {
        if(!nodesToProcess.isEmpty()){
            ttl = 0;
            cnt = 0;
            List<TreeNode> nextLevelNodes = new LinkedList<>();
            for(TreeNode node : nodesToProcess){
                cnt++;
                ttl += node.val;
                if(node.left!=null){
                    nextLevelNodes.add(node.left);
                }
                if(node.right!=null){
                    nextLevelNodes.add(node.right);
                }
            }
            ans.add(ttl/cnt);
            if(!nextLevelNodes.isEmpty()){
                myAverageOfLevels(nextLevelNodes);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Integer[][] inputs = {{3, 9, 20, null, null, 15, 7}, {3, 9, 20, 15, 7}};
        Solution solution = new Solution();
        BinaryTreeConstructor btc = new BinaryTreeConstructor();
        for (Integer[] input : inputs) {
            btc.construct(Arrays.asList(input));
            System.out.println(solution.averageOfLevels(btc.getRoot()));
            System.out.println("==========");
        }
    }
}
