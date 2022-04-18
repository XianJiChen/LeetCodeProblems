package com.Q257_Binary_Tree_Paths;

import com.TreeNode.TreeNode;
import com.BinaraTreeConstructor.*;


import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        ans.clear();
        myBinaryTreePaths(root, "");
        return ans;
    }

    public void myBinaryTreePaths(TreeNode root, String route){
        if(root.left==null && root.right==null){
            ans.add(route + root.val);
        }
        else{
            if(root.left!=null){
                myBinaryTreePaths( root.left, route + root.val + "->");
            }
            if(root.right!=null){
                myBinaryTreePaths(root.right, route + root.val + "->");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {

        List<List<Integer>> inputs = new ArrayList<>();
        inputs.add(new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
            add(null);
            add(5);
        }});
        inputs.add(new ArrayList<>(){{
            add(1);
        }});

        BinaryTreeConstructor btc = new BinaryTreeConstructor();
        Solution solution = new Solution();
        List<String> ans;
        for(List<Integer> input : inputs){
            btc.construct(input);
            ans = solution.binaryTreePaths(btc.getRoot());
            for(String str : ans){
                System.out.println(str);
            }
            System.out.println("--------------------");
        }
    }
}
