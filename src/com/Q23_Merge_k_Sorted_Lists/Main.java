package com.Q23_Merge_k_Sorted_Lists;

//Time limit existed ver
/*
class Solution {
    public ListNode construct(int[] arr){
        ListNode ptr=null;
        for(int i=arr.length-1; i>=0; i--){
            ptr = new ListNode(arr[i],ptr);
        }
        return ptr;
    }
    public ListNode[] construct1(int[][] arr){
        ListNode[] ptrs = new ListNode[arr.length];
        for(int i=0; i<arr.length; i++){
            ptrs[i] = construct(arr[i]);
        }
        return ptrs;
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
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if(len==0) return null;
        else if(len==1) return lists[0];
        boolean odd = (len%2==1) ? true : false;
        int max_step = len/2;
        System.out.printf("len: %d, max_step: %d\n", len, max_step);
        for(int step=1; step<=max_step; step*=2){
            for(int i=0; i+step<len; i+=(2*step)){
                lists[i] = mergeTwoLists(lists[i], lists[i+step]);
            }
        }
        if(odd) mergeTwoLists(lists[0],lists[len-1]);
        return lists[0];
    }
}
*/
import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public ListNode construct(int[] arr){
        ListNode ptr=null;
        for(int i=arr.length-1; i>=0; i--){
            ptr = new ListNode(arr[i],ptr);
        }
        return ptr;
    }
    public ListNode[] construct1(int[][] arr){
        ListNode[] ptrs = new ListNode[arr.length];
        for(int i=0; i<arr.length; i++){
            ptrs[i] = construct(arr[i]);
        }
        return ptrs;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists){
            while (node!=null){
                queue.add(node);
                node = node.next;
            }
        }

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
        }
        tail.next = null;
        return dummy.next;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][][] inputs = {{{1,4,5},{1,3,4},{2,6}},{},{{}},{{},{1}},{{-2,-1,-1,-1},{}}};
        Solution tt = new Solution();
        ListNode[] ptr;
        ListNode ans;
        for(int[][] input:inputs){
            ptr = tt.construct1(input);
//            for(ListNode p:ptr){
//                while(p!=null){
//                    System.out.println(p.val);
//                    p = p.next;
//                }
//                System.out.println("-----------------");
//            }
//            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
            ans = tt.mergeKLists(ptr);
            while(ans!=null){
                System.out.println(ans.val);
                ans = ans.next;
                System.out.println("-----------------");
            }
            System.out.println("========================");

        }
    }
}
