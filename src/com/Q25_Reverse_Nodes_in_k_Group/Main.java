package com.Q25_Reverse_Nodes_in_k_Group;

import com.ListNode.ListNode;


//othere's 0ms ver
class Solution {
    public ListNode construct(int[] arr){
        ListNode ptr=null;
        for(int i=arr.length-1; i>=0; i--){
            ptr = new ListNode(arr[i],ptr);
        }
        return ptr;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k==1) return head;
        ListNode next = null;
        ListNode curr = head;
        ListNode prev = null;
        int t=k;
        if(check(head,k)){
            while(--k>=0 && curr!=null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            head.next = reverseKGroup(next,t);
            return prev;
        }
        return head;
    }
    private boolean check(ListNode node,int k){
        while(--k>=0 && node!=null){
            node = node.next;
        }
        return (k==-1)? true:false;
    }
}

//my own 0ms ver
/*
class Solution {
public ListNode construct(int[] arr){
        ListNode ptr=null;
        for(int i=arr.length-1; i>=0; i--){
            ptr = new ListNode(arr[i],ptr);
        }
        return ptr;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k==1) return head;
        ListNode ptr,prev,next,prev_list_end,cur_list_head, cur_list_tail;
        prev_list_end = null;
        boolean at_head = true;
        int tmp;
        for(ptr = head; ptr!=null; prev_list_end = cur_list_head){
            cur_list_head = ptr;
            for(tmp=k-2, cur_list_tail = ptr.next;tmp>0 && cur_list_tail!=null;tmp--){
                cur_list_tail = cur_list_tail.next;
            }
            if(cur_list_tail==null) break;
            for(tmp=k,prev=cur_list_tail.next; tmp>0; tmp--){;
                next = ptr.next;
                ptr.next = prev;
                prev = ptr;
                ptr = next;
            }
            if(prev_list_end==null) {
                head = prev;
            }
            else{
                prev_list_end.next = prev;
            }
            prev_list_end = cur_list_head;
        }
        return head;
    }
}
*/

//1ms ver
/*
class Solution {
    public ListNode construct(int[] arr){
        ListNode ptr=null;
        for(int i=arr.length-1; i>=0; i--){
            ptr = new ListNode(arr[i],ptr);
        }
        return ptr;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ///整個中間都要翻過來!!
        if(head==null || head.next==null || k==1) return head;
        ListNode ptr1=head, ptr2=ptr1.next;
        int tmp;
        if(k<=3){
            for(; ptr1!=null; ptr1 = ptr2.next){
                ptr2 = ptr1.next;
                for(int i=0; ptr2!=null && i<k-2; i++){
                    ptr2 = ptr2.next;
                }
                if(ptr2==null)break;
                tmp = ptr1.val;
                ptr1.val = ptr2.val;
                ptr2.val = tmp;
            }
        }
        else{
            ListNode rv=null,prev=null,ptr,next;
            for(; ptr1!=null; ptr1 = ptr2.next){
                ptr2 = ptr1.next;
                for(int i=0; ptr2!=null && i<k-2; i++){
                    ptr2 = ptr2.next;
                }
                if(ptr2==null)break;
                tmp = ptr1.val;
                ptr1.val = ptr2.val;
                ptr2.val = tmp;
                for(ptr = ptr1.next, prev = ptr2, next = ptr.next; ptr!=ptr2; ptr = next, next = next.next){
//                    System.out.println(ptr.val);
//                    System.out.println("___________");
                    ptr.next = prev;
                    prev = ptr;
                }
                ptr1.next = prev;
            }
        }
//        System.out.println("+++++++++++++");
        return head;
    }
}
*/
public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2},{1,2,3,4}};
        int[] ks = {2,3,1,2,4};
        Solution tt = new Solution();
        ListNode ptr, head;
        for(int i=0;i<inputs.length; i++){
            head = ptr = tt.construct(inputs[i]);
            while(ptr!=null){
                System.out.println(ptr.val);
                ptr = ptr.next;
            }
            System.out.println("--------------");
            ptr = tt.reverseKGroup(head, ks[i]);
            while(ptr!=null){
                System.out.println(ptr.val);
                ptr = ptr.next;
            }
            System.out.println("=============");
        }
    }
}
