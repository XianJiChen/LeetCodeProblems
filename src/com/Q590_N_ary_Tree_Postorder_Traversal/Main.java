package com.Q590_N_ary_Tree_Postorder_Traversal;

import com.N_ary_TreeNode.Node;

import java.util.ArrayList;
import java.util.List;

//1ms ver
class Solution {
    //public List<Integer> ans = new LinkedList<>();
    public List<Integer> ans = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        ans.clear();
        myPostOrder(root);
        return ans;
    }

    public void myPostOrder(Node root) {
        if(root!=null){
            for(Node node : root.children){
                myPostOrder(node);
            }
            this.ans.add(root.val);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        //Done
    }
}
