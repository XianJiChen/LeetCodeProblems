package com.Q606_Construct_String_from_Binary_Tree;

import com.TreeNode.TreeNode;
import com.sun.source.tree.Tree;


class Solution {
    StringBuilder sb;
    public String tree2str(TreeNode root) {
        sb = new StringBuilder();
        sb.append(root.val);
        myTree2str(root.left);
        myTree2str(root.right);
        return sb.toString();
    }

    public void myTree2str(TreeNode root){
        sb.append("(");
        sb.append(root.val);
        myTree2str(root.left);
        myTree2str(root.right);
        sb.append(")");
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
