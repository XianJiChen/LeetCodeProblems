package com.Q19_Remove_Nth_Node_From_End_of_List;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode construct(int[] arr){
        ListNode ptr=null;
        for(int i=arr.length-1; i>=0; i--){
            ptr = new ListNode(arr[i],ptr);
        }
        return ptr;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int cnt=0;
        ListNode ptr = head,prev=null;
        if(head.next==null) return null;
        while(ptr!=null){
            cnt++;
            ptr = ptr.next;
        }
        //n%=cnt;
        n = cnt-n;//(cnt-1)-(n-1)
        System.out.println("n:");
        System.out.println(n);
        ptr = head;
        for(int i=0;i<n;i++){
            prev = ptr;
            ptr = ptr.next;
        }
        if(prev==null){
            head = ptr.next;
        }
        else{
           prev.next = prev.next.next;
        }
        return head;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{1, 2, 3, 4, 5}, {1}, {1, 2}, {1,2}};
        int[] n = {2, 1, 1, 2};
        Solution tt = new Solution();
        for (int i = 0; i < inputs.length; i++) {
            ListNode head = tt.construct(inputs[i]);
            ListNode ptr = head;
            while (ptr != null) {
                System.out.println(ptr.val);
                ptr = ptr.next;
            }
            head = tt.removeNthFromEnd(head, n[i]);
            System.out.println("------------");
            ptr = head;
            while (ptr != null) {
                System.out.println(ptr.val);
                ptr = ptr.next;
            }
            System.out.println("====================");
        }
    }
}
