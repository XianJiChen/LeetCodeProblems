package com.Q235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;
import com.BinaraTreeConstructor.*;
import com.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;



//7ms ver
/*
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode leftResult;
        TreeNode rightResult;
        if(root==null){
            return null;
        }
        else{
            leftResult = (root.left==null) ? null : lowestCommonAncestor(root.left,p,q);
            rightResult =  (root.right==null) ? null : lowestCommonAncestor(root.right,p,q);

            if(root!=p && root!=q){
                if(leftResult!=null&&rightResult!=null){
                    return root;
                }
                else if(leftResult!=null){
                    return leftResult;
                }
                else{
                    return rightResult;
                }
            }
            else { //root is either p or q
                return root;
            }
        }
    }
}
*/
/*
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==p || root==q){
            return root;
        }
        else{
            TreeNode leftResult;
            TreeNode rightResult;
            leftResult = (root.left==null) ? null : lowestCommonAncestor(root.left,p,q);
            rightResult =  (root.right==null) ? null : lowestCommonAncestor(root.right,p,q);
            if(leftResult!=null&&rightResult!=null){
                return root;
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
*/


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val>p.val && root.val>q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        else if(root.val<p.val && root.val<q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        else{
            return root;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> inputs = new ArrayList<>();
        inputs.add(new ArrayList<>(){{
            //6,2,8,0,4,7,9,null,null,3,5
            add(6);
            add(2);
            add(8);
            add(0);
            add(4);
            add(7);
            add(9);
            add(null);
            add(null);
            add(3);
            add(5);
        }});

        inputs.add(new ArrayList<>(){{
            //6,2,8,0,4,7,9,null,null,3,5
            add(6);
            add(2);
            add(8);
            add(0);
            add(4);
            add(7);
            add(9);
            add(null);
            add(null);
            add(3);
            add(5);
        }});

        inputs.add(new ArrayList<>(){{
            add(2);
            add(1);
        }});

        int[] ps = {2,2,2};
        int[] qs = {8,4,1};


        Solution solution = new Solution();
        BinaryTreeConstructor btc = new BinaryTreeConstructor();
        TreeNode root;
        TreeNode p;
        TreeNode q;
        for(int i=0; i<inputs.size(); i++){
            List<Integer> input = inputs.get(i);
            btc.construct(input);
            root = btc.getRoot();
            p = btc.getNode(ps[i]);
            q = btc.getNode(qs[i]);
//            System.out.println(root.val);
//            System.out.println(p.val);
//            System.out.println(q.val);
//            System.out.println("------");
            System.out.println(solution.lowestCommonAncestor(root, p, q).val);
        }

    }
}
