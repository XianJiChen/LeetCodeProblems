package com.BinaraTreeConstructor;

import java.util.*;
import com.TreeNode.*;

public class BinaryTreeConstructor {
    public int start;

    public BinaryTreeConstructor() {
        this.start = 0;
    }

    public TreeNode construct(List<Integer> arr){
        if(arr.isEmpty()){
            return null;
        }
        this.start = 0;
        Queue<Integer> values= new LinkedList<Integer>();
        values.addAll(arr);
        Queue<TreeNode> nodesToHandle= new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(values.poll());
        nodesToHandle.add(root);
        ConstructTree(values,nodesToHandle);
        return root;
    }

    private void ConstructTree(Queue<Integer> values, Queue<TreeNode> nodesToHandle){
        TreeNode node;
        TreeNode newNode;
        Integer val;
        while(!nodesToHandle.isEmpty()){
            node = nodesToHandle.poll();
            if(values.isEmpty()){
                return;
            }
            val = values.poll();
            node.left = (val==null) ? null : new TreeNode(val);
            if(val!=null){
                nodesToHandle.add(node.left);
            }
            if(values.isEmpty()){
                return;
            }
            val = values.poll();
            node.right = (val==null) ? null : new TreeNode(val);
            if(val!=null){
                nodesToHandle.add(node.right);
            }
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return new ArrayList<Integer>();
        }
        else{
            List<Integer> ans = new ArrayList<>();
            ans.addAll(inorderTraversal(root.left));
            ans.add(root.val);
            ans.addAll(inorderTraversal(root.right));
            return ans;
        }
    }
}
