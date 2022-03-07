package com.Q24_Swap_Nodes_in_Pairs;

class Solution {
    public ListNode construct(int[] arr){
        ListNode ptr=null;
        for(int i=arr.length-1; i>=0; i--){
            ptr = new ListNode(arr[i],ptr);
        }
        return ptr;
    }
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode ptr1, ptr2;
        int tmp;
        for(ptr1=head,ptr2=head.next; ptr1!=null&&ptr2!=null;){
            tmp = ptr1.val;
            ptr1.val = ptr2.val;
            ptr2.val = tmp;

            ptr1 = ptr2.next;
            ptr2 = (ptr1==null) ? null : ptr1.next;
        }
        return head;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{1,2,3,4},{},{1}};
        Solution tt = new Solution();
        ListNode ptr, head;
        for(int[] input:inputs){
            head = ptr = tt.construct(input);
            while(ptr!=null){
                System.out.println(ptr.val);
                ptr = ptr.next;
            }
            System.out.println("--------------");
            ptr = tt.swapPairs(head);
            while(ptr!=null){
                System.out.println(ptr.val);
                ptr = ptr.next;
            }
            System.out.println("=============");
        }
    }
}
