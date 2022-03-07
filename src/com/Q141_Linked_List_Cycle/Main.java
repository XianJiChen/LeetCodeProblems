package com.Q141_Linked_List_Cycle;

import com.ListNode.*;

import java.util.HashSet;
import java.util.List;

//0ms ver
class Solution {
    public boolean hasCycle(ListNode head) {
        while(head!=null){
            if(head.val==Integer.MIN_VALUE){
                return true;
            }
            else{
                head.val = Integer.MIN_VALUE;
            }
            head = head.next;
        }
        return false;
    }
}

//9ms ver
/*
class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> traversed = new HashSet<>();
        ListNode ptr = head;
        while(ptr!=null){
            if(traversed.contains(ptr)){
                return true;
            }
            else{
                traversed.add(ptr);
            }
            ptr = ptr.next;
        }
        return false;
    }
}
*/
public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode ptr = head;
        ListNode tt;
        tt = ptr.next = new ListNode(2);
        ptr = ptr.next;
        ptr.next = new ListNode(0);
        ptr = ptr.next;
        ptr.next = new ListNode(4);
        ptr = ptr.next;
        ptr.next = tt;


        Solution solution = new Solution();
        System.out.println(solution.hasCycle(head));
    }
}
