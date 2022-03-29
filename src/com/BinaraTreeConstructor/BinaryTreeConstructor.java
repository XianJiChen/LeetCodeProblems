package com.BinaraTreeConstructor;

import java.util.*;
import com.TreeNode.*;

public class BinaryTreeConstructor {
    private int start;
    private TreeNode root;

    public BinaryTreeConstructor() {
        this.start = 0;
    }

    public void construct(List<Integer> arr){
        this.root=null;
        this.start = 0;
        if(arr.isEmpty()){
            return;
        }
        Queue<Integer> values= new LinkedList<Integer>();
        values.addAll(arr);
        Queue<TreeNode> nodesToHandle= new LinkedList<TreeNode>();
        this.root = new TreeNode(values.poll());
        nodesToHandle.add(root);
        ConstructTree(values,nodesToHandle);
    }

    public void construct(int[] nums){
        List<Integer> arr = Arrays.stream(nums).boxed().toList();
        this.construct(arr);
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

    public TreeNode getRoot() {
        return root;
    }

    public TreeNode getNode(int val){
        return getNode(this.root,val);
    }

    private TreeNode getNode(TreeNode root, int val){
        if(root==null){
            return null;
        }
        else {
            if(root.val==val){
                return root;
            }
            else{
                TreeNode leftResult = (root.left==null) ? null : getNode(root.left,val);
                TreeNode rightResult = (root.right==null) ? null: getNode(root.right,val);
                if(leftResult==null&&rightResult==null){
                    return null;
                }
                else if(leftResult!=null){
                    return leftResult;
                }
                else{
                    return rightResult;
                }
            }
        }
    }
}
