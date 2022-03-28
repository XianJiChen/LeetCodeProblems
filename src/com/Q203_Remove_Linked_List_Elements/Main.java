package com.Q203_Remove_Linked_List_Elements;
import com.ListNode.*;

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode ptr = head;
        ListNode prev = head;
        while(ptr!=null){
            System.out.println(ptr.val);
            if(ptr.val == val){
                if(ptr==head){
                    head = ptr = prev = ptr.next;
                }
                else{
                    prev.next = ptr.next;
                    ptr = ptr.next;
                }
            }
            else{
                prev = ptr;
                ptr = ptr.next;
            }
        }
        return head;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{1,2,6,3,4,5,6},{},{7,7,7,7},{1,2,2,1}};
        int[] vals = {6,1,7,2};
        Solution solution = new Solution();
        LinkedListConstructor llc = new LinkedListConstructor();

        for(int i=0; i<inputs.length; i++){
            int[] input = inputs[i];
            int val = vals[i];
            llc.construct(input);
            ListNode head = llc.getHead();
            head = solution.removeElements(head,val);
            while(head!=null){
                System.out.println(head.val);
                head = head.next;
            }
            System.out.println("------------------------");
        }
    }
}
