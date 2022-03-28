package com.Q206_Reverse_Linked_List;

import com.ListNode.*;

import java.awt.*;
import java.util.List;

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode prev = null;
        ListNode ptr = head;
        ListNode next = ptr.next;


        //ver 1
//        do{
//            ptr.next = prev;
//            prev = ptr;
//            ptr = next;
//            next = (next==null) ? null : next.next;
//        }
//        while(ptr!=null);
//        return  prev;

        while(next!=null){
            ptr.next = prev;
            prev = ptr;
            ptr = next;
            next = next.next;
        }
        ptr.next = prev;
        return ptr;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{1,2,3,4,5},{1,2},{}};
        LinkedListConstructor llc = new LinkedListConstructor();
        Solution solution = new Solution();
        for(int[] input : inputs){
            llc.construct(input);
            ListNode head = llc.getHead();
            head = solution.reverseList(head);
            while(head!=null){
                System.out.println(head.val);
                head = head.next;
            }
            System.out.println("-------------------");
        }
    }
}
