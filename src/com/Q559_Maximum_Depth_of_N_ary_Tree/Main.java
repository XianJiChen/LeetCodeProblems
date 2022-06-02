package com.Q559_Maximum_Depth_of_N_ary_Tree;

import com.N_ary_TreeNode.Node;

class Solution {
    int maxLevel = 0;
    int level = 0;
    public int maxDepth(Node root) {
        myMaxDepth(root);
        return maxLevel;
    }

    public void myMaxDepth(Node root){
        if(root!=null){
            level++;
            maxLevel = Math.max(maxLevel,level);
            for(Node node : root.children){
                myMaxDepth(node);
            }
            level--;
        }
    }
}

public class Main {
    public static void main(String[] args) {
    //Done
    }
}
