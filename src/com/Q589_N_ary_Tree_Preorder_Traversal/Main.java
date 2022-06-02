package com.Q589_N_ary_Tree_Preorder_Traversal;

import com.N_ary_TreeNode.*;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


//1ms ver
class Solution {
    //public List<Integer> ans = new LinkedList<>();
    public List<Integer> ans = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        ans.clear();
        myPreorder(root);
        return ans;
    }

    public void myPreorder(Node root) {
        if(root!=null){
            this.ans.add(root.val);
            for(Node node : root.children){
                myPreorder(node);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        //Done
    }
}
