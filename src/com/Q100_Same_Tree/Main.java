package com.Q100_Same_Tree;
import com.BinaraTreeConstructor.*;
import com.TreeNode.*;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
        else if (p == null ^ q == null) {
            return false;
        }
        else {
            if(p.val==q.val){
                return (isSameTree(p.left,q.left)&&isSameTree(p.right,q.right));
            }
            else{
                return false;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> ps = new ArrayList<>();
        ps.add(new ArrayList<>(){{
                add(1);
                add(2);
                add(3);
        }});
        ps.add(new ArrayList<>(){{
                add(1);
                add(2);
        }});
        ps.add(new ArrayList<>(){{
                add(1);
                add(2);
                add(1);
        }});
        List<List<Integer>> qs = new ArrayList<>();
        qs.add(new ArrayList<>(){{
                add(1);
                add(2);
                add(3);
        }});
        qs.add(new ArrayList<>(){{
                add(1);
                add(null);
                add(2);
        }});
        qs.add(new ArrayList<>(){{
                add(1);
                add(1);
                add(2);
        }});
        BinaryTreeConstructor bt = new BinaryTreeConstructor();
        Solution tt = new Solution();
        for(int i=0; i<ps.size(); i++){
            TreeNode tnp = bt.construct(ps.get(i));
            System.out.println(bt.inorderTraversal(tnp));
            System.out.println("/////////////////////");
            TreeNode tnq = bt.construct(qs.get(i));
            System.out.println(bt.inorderTraversal(tnq));
            System.out.println("/////////////////////");
            System.out.println(tt.isSameTree(tnp, tnq));
            System.out.println("==========================");
        }

    }
}
