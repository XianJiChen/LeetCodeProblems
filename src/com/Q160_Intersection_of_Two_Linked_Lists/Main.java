package com.Q160_Intersection_of_Two_Linked_Lists;

import com.LinkedListConstructor;
import com.ListNode.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


//21ms 8% ver...
/*
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> nodesOfA = new HashSet<>();
        HashSet<ListNode> nodesOfB = new HashSet<>();
        while(headA!=null && headB!=null){
            if(nodesOfB.contains(headA)){
                return headA;
            }
            nodesOfA.add(headA);
            headA = headA.next;
            if(nodesOfA.contains(headB)){
                return headB;
            }
            nodesOfB.add(headB);
            headB = headB.next;
        }
        if(headA!=null){
            while(headA!=null) {
                if (nodesOfB.contains(headA)) {
                    return headA;
                }
                headA = headA.next;
            }
        }
        else if(headB!=null){
            while(headB!=null) {
                if (nodesOfA.contains(headB)) {
                    return headB;
                }
                headB = headB.next;
            }
        }
        else{
            return null;
        }
        return null;
    }
}
*/
//1ms ver
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        int len1 = 0, len2 = 0;
        while (p1 != null) {
            p1 = p1.next;
            len1++;
        }
        while (p2 != null) {
            p2 = p2.next;
            len2++;
        }
        p1 = headA;
        p2 = headB;
        if (len1 > len2) {
            for (int i = 0;i < len1 - len2; i++) {
                p1 = p1.next;
            }
        } else {
            for (int i = 0;i < len2 - len1; i++) {
                p2 = p2.next;
            }
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
public class Main {
    public static void main(String[] args) {
//        int[][] listAs = {{4,1,8,4,5},{1,9,1,2,4},{2,6,4}};
//        int[][] listBs = {{5,6,1,8,4,5},{3,2,4},{1,5}};
//        int[] skipAs = {2,3,3};
//        int[] skipBs = {3,1,2};

        List<List<Integer>> listAs = new ArrayList<>();
        List<List<Integer>> listBs = new ArrayList<>();
        List<Integer> skipAs = new ArrayList<>();
        List<Integer> skipBs = new ArrayList<>();
        //testcase 1
        listAs.add(new ArrayList<Integer>(){{
            add(4);
            add(1);
            add(8);
            add(4);
            add(5);
        }});
        listBs.add(new ArrayList<Integer>(){{
            add(5);
            add(6);
            add(1);
            add(8);
            add(4);
            add(5);
        }});
        skipAs.add(2);
        skipBs.add(3);

        //test case 2
        listAs.add(new ArrayList<Integer>(){{
            add(1);
            add(9);
            add(1);
            add(2);
            add(4);
        }});
        listBs.add(new ArrayList<Integer>(){{
            add(3);
            add(2);
            add(4);
        }});
        skipAs.add(3);
        skipBs.add(1);

        //test case 3
        listAs.add(new ArrayList<Integer>(){{
            add(2);
            add(6);
            add(4);
        }});
        listBs.add(new ArrayList<Integer>(){{
            add(1);
            add(5);
        }});
        skipAs.add(3);
        skipBs.add(2);


        LinkedListConstructor llc = new LinkedListConstructor();
        Solution solution = new Solution();
        for(int i=0; i< listAs.size(); i++){
            llc.construct(listAs.get(i).subList(0,skipAs.get(i)));
            ListNode headA = llc.getHead();
            ListNode tailA = llc.getTail();
            llc.construct(listBs.get(i).subList(0,skipBs.get(i)));
            ListNode headB = llc.getHead();
            ListNode tailB = llc.getTail();
            llc.construct(listAs.get(i).subList(skipAs.get(i),listAs.get(i).size()));
            tailA.next = tailB.next = llc.getHead();
            ListNode ans = solution.getIntersectionNode(headA,headB);
            System.out.println((ans==null) ? "NULL" : ans.val);
            System.out.println("==================================");

        }
    }
}
