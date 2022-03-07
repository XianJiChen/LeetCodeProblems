package com.Q83_Remove_Duplicates_from_Sorted_List;
import com.ListNode.*;

import java.util.List;


//0ms ver
/*
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null) {
            if (node.next != null && node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}
 */
//1ms ver
class Solution {
    public ListNode construct(int[] arr){
        ListNode ptr=null;
        for(int i=arr.length-1; i>=0; i--){
            ptr = new ListNode(arr[i],ptr);
        }
        return ptr;
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode ptr1 = head;
        ListNode ptr2 = head.next;
        while (ptr1 != null) {
            while(ptr2!=null && ptr2.val==ptr1.val){
                ptr2 = ptr2.next;
            }
            ptr1.next = ptr2;
            ptr1 = ptr2;
            ptr2 = (ptr2==null) ? null : ptr2.next;
        }
        return head;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{1,1,2},{1,1,2,3,3}};
        Solution tt = new Solution();
        for(int[] input : inputs){
            ListNode head;
            ListNode ptr;
            head = ptr = tt.construct(input);
            while(ptr!=null){
                System.out.println(ptr.val);
                ptr = ptr.next;
            }
            System.out.println("--------------");
            ptr = head;
            ptr = tt.deleteDuplicates(ptr);
            while(ptr!=null){
                System.out.println(ptr.val);
                ptr = ptr.next;
            }
            System.out.println("=============");
        }
    }
}
