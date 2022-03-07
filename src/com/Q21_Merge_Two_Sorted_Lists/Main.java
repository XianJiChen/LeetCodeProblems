package com.Q21_Merge_Two_Sorted_Lists;


class Solution {
    public ListNode construct(int[] arr){
        ListNode ptr=null;
        for(int i=arr.length-1; i>=0; i--){
            ptr = new ListNode(arr[i],ptr);
        }
        return ptr;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        else if(list2==null) return list1;

        ListNode prev = null, head;
        if(list1.val>list2.val){
            prev = list2;
            list2 = list1;
            list1 = prev;
        }
        head = prev = list1;
        list1 = list1.next;
        while(list1!=null && list2!=null){
            if(list2.val < list1.val){
                prev.next = list2;
                list2 = list2.next;
            }
            else{
                prev.next = list1;
                list1 = list1.next;
            }
            prev = prev.next;
        }
        if(list1==null) prev.next = list2;
        else prev.next = list1;
        return head;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] list1 = {{1,2,4},{},{}};
        int[][] list2 = {{1,3,4},{},{0}};
        Solution tt = new Solution();
        ListNode ptr;
        for(int i=0; i<list1.length; i++){
            ptr = tt.mergeTwoLists(tt.construct(list1[i]),tt.construct(list2[i]));
            while (ptr != null) {
                System.out.println(ptr.val);
                ptr = ptr.next;
            }
            System.out.println("======================");
        }
    }
}
