package com.Q572_Subtree_of_Another_Tree;

import com.BinaraTreeConstructor.BinaryTreeConstructor;
import com.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

//4ms ver
/*
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null){
            return false;
        }
        else if(myCheckSubTree(root, subRoot)){
            return true;
        }
        else{
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }

    public boolean myCheckSubTree(TreeNode root, TreeNode subRoot){
        if(root!=null && subRoot!=null){
            if(root.val != subRoot.val){
                return false;
            }
            else{
                return myCheckSubTree(root.left, subRoot.left) && myCheckSubTree(root.right, subRoot.right);
            }
        }
        else{
            return (root==null && subRoot==null);
        }
    }
}
*/

//3ms ver
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null || subRoot==null){
            return root==null && subRoot==null;
        }else if(isSameTree(root,subRoot)){
            return true;
        }else{
            return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
        }
    }
    public boolean isSameTree(TreeNode root,TreeNode subRoot){
        if(root==null || subRoot==null){
            return root==null && subRoot==null;
        }else if(root.val==subRoot.val){
            return isSameTree(root.left,subRoot.left) && isSameTree(root.right,subRoot.right);
        }else{
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> roots = new ArrayList<>();
        Integer[][] inputsRoot = {{3,4,5,1,2},{3,4,5,1,2,null,null,null,null,0}};

        for(Integer[] inputArr : inputsRoot){
            roots.add(new ArrayList<>(){{
                for(Integer integer : inputArr){
                    add(integer);
                }
            }});
        }

        List<List<Integer>> subRoots = new ArrayList<>();
        Integer[][] Sub = {{4,1,2},{4,1,2}};

        for(Integer[] inputArr : Sub){
            subRoots.add(new ArrayList<>(){{
                for(Integer integer : inputArr){
                    add(integer);
                }
            }});
        }

        Solution solution = new Solution();
        BinaryTreeConstructor btc = new BinaryTreeConstructor();
        TreeNode root;
        TreeNode subRoot;

        for(int i=0; i<roots.size(); i++){
            btc.construct(roots.get(i));
            root = btc.getRoot();
            btc.construct(subRoots.get(i));
            subRoot = btc.getRoot();
            System.out.println(solution.isSubtree(root,subRoot));
            System.out.println("===============");
        }
    }
}
