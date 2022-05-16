package com.Q501_Find_Mode_in_Binary_Search_Tree;

import java.awt.*;
import java.util.*;
import java.util.List;

import com.BinaraTreeConstructor.*;
import com.TreeNode.TreeNode;

//41ms ver
/*
class Solution {
    private int[] cnt;

    public int[] findMode(TreeNode root) {
         cnt = new int[200001];
         myFindMode(root);
         List<Integer> ans = new LinkedList<>();
         int maxCnt = 0;
         for(int i=0; i<cnt.length; i++){
             if(cnt[i]<maxCnt){
                 continue;
             }
             else if(cnt[i]==maxCnt){
                 ans.add(i-100000);
             }
             else{
                 ans.clear();
                 ans.add(i-100000);
                 maxCnt = cnt[i];
             }
         }
         int[] aa = new int[ans.size()];
         for(int i=0; i<aa.length; i++){
             aa[i] = ans.get(i);
         }
         //return ans.stream().mapToInt(Integer::intValue).toArray();
        return aa;
    }

    private void myFindMode(TreeNode root){
        if(root!=null){
            cnt[root.val+100000]++;
            myFindMode(root.left);
            myFindMode(root.right);
        }
    }
}
*/
//9ms ver
/*
class Solution {
    private HashMap<Integer,Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        map.clear();
        myFindMode(root);
        List<Integer> ans = new LinkedList<>();
        int maxCnt = 0;
        for(Integer key : map.keySet()){
            if(map.get(key)<maxCnt){
                continue;
            }
            else if(map.get(key)==maxCnt){
                ans.add(key);
            }
            else{
                ans.clear();
                ans.add(key);
                maxCnt = map.get(key);
            }
        }
        int[] aa = new int[ans.size()];
        for(int i=0; i<aa.length; i++){
            aa[i] = ans.get(i);
        }
        //return ans.stream().mapToInt(Integer::intValue).toArray();
        return aa;
    }

    private void myFindMode(TreeNode root){
        if(root!=null){
            if(map.containsKey(root.val)){
                map.replace(root.val, map.get(root.val)+1);
            }
            else{
                map.put(root.val,1);
            }
            myFindMode(root.left);
            myFindMode(root.right);
        }
    }
}
*/

//1ms ver
class Solution {
    int pre=0;
    int curCount = 0;
    int maxCount = 0;
    List<Integer> res;
    public int[] findMode(TreeNode root)
    {
        res = new ArrayList<>();
        inorder(root);
        int[] result  = new int[res.size()];
        int k =0;
        for(int i: res)
            result[k++]=i;
        return result;
    }

    public void inorder(TreeNode root)
    {
        if(root==null)
            return;
        inorder(root.left);
        if(root.val == pre)
            curCount++;
        else
        {
            pre = root.val;
            curCount = 1;
        }
        if(curCount > maxCount)
        {
            maxCount = curCount;
            res.clear();
            res.add(root.val);
        }
        else if(curCount==maxCount)
            res.add(root.val);
        inorder(root.right);
    }
}

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> inputs = new ArrayList<>();
        inputs.add(new ArrayList<>(){{
            add(1);
            add(null);
            add(2);
            add(2);
        }});
        inputs.add(new ArrayList<>(){{
            add(0);
        }});
        inputs.add(new ArrayList<>(){{
            add(-2);
            add(-2);
            add(-2);
        }});
        inputs.add(new ArrayList<>(){{
            add(1);
            add(null);
            add(2);
        }});

        Solution solution = new Solution();
        BinaryTreeConstructor btc = new BinaryTreeConstructor();
        TreeNode root;
        for(List<Integer> input : inputs){
            btc.construct(input);
            root = btc.getRoot();
            System.out.println(Arrays.toString(solution.findMode(root)));
            System.out.println("======");
        }

    }
}
