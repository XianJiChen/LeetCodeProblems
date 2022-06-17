package com.Q653_Two_Sum_IV_Input_is_a_BST;

import com.BinaraTreeConstructor.BinaryTreeConstructor;
import com.TreeNode.TreeNode;

import java.util.Arrays;

class Solution {
    boolean[] shows = new boolean[20001];

    public boolean findTarget(TreeNode root, int k) {
        if (k > 2 * 10000 || k < -2 * 10000) {
            return false;
        } else {
            return findTargetAfterFirst(root, k);
        }
    }

    public boolean findTargetAfterFirst(TreeNode root, int k) {
        if (root == null) {
            return false;
        } else {
//            System.out.println(root.val);
//            System.out.println(k - root.val + 10000);
//            System.out.println("--------");
            if ((k - root.val + 10000) >= 0 && (k - root.val + 10000) < shows.length && shows[k - root.val + 10000]) {
                return true;
            } else {
                shows[root.val + 10000] = true;
                return (findTarget(root.left, k) || findTarget(root.right, k));
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Integer[][] inputs = {{5, 3, 6, 2, 4, null, 7}, {5, 3, 6, 2, 4, null, 7}, {1299, 11, 3101, null, 82, 2148, 5004, null, 1032, null, null, 4772, 5138, null, null, 3764}};
        int[] ks = {9, 28, 10142};
        Solution solution = new Solution();
        BinaryTreeConstructor btc = new BinaryTreeConstructor();
        for (int i = 0; i < inputs.length; i++) {
            btc.construct(Arrays.asList(inputs[i]));
            System.out.println(solution.findTarget(btc.getRoot(), ks[i]));
            System.out.println("============");
        }
    }
}
