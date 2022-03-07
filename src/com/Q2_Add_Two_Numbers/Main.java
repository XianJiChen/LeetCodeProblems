package com.Q2_Add_Two_Numbers;

import java.util.ArrayList;
import java.util.Arrays;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
//
//class Solution {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        /*
//        ArrayList<Integer> a = new ArrayList<Integer>();
//        int idx = 0, tmp;
//
//        while(l1 != null){
//            a.add(l1.val);
//            l1 = l1.next;
//        }
//        while(l2 != null){
//            tmp = a.get(idx) + l2.val;
//            if(tmp<10) a.set(idx, tmp);
//            else{
//                if(idx==a.size()-1) a.add(1);
//                else{
//                    a.set(idx+1, a.get(idx+1)+1);
//                }
//                a.set(idx, tmp-10);
//            }
//            idx++;
//        }
//        */
//        int tmp;
//        ListNode ptr = l1;
//        while(l1.next!=null && l2.next!=null){
//            tmp = l1.val + l2.val;
//            if(tmp<10) l1.val = tmp;
//            else{
//                l1.next.val += 1;
//                l1.val = tmp-10;
//            }
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//        tmp = l1.val + l2.val;
//
//        if(l1.next==null && l2.next==null){
//            if(tmp<10) l1.val = tmp;
//            else{
//                l1.val = tmp-10;
//                l1.next = new ListNode(1,null);
//            }
//            return ptr;
//        }
//        else if(l1.next == null){
//            l1.next = l2.next;
//        }
//
//        if(tmp < 10) l1.val = tmp;
//        else{
//            l1.next.val += 1;
//            l1.val = tmp-10;
//            l1 = l1.next;
//            while(l1.val>=10 && l1.next!=null){
//                l1.next.val += 1;
//                l1.val = l1.val-10;
//                l1 = l1.next;
//            }
//            if(l1.val>=10){
//                l1.val -= 10;
//                l1.next = new ListNode(1, null);
//            }
//        }
//        return ptr;
//    }
//}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tmp;
        int d = 10;
        ListNode ptr = l1;
        while(l1.next!=null && l2.next!=null){
            tmp = l1.val + l2.val;
            l1.next.val += tmp/d;
            l1.val = tmp%d;
            l1 = l1.next;
            l2 = l2.next;
        }
        tmp = l1.val + l2.val;

        if(l1.next==null && l2.next==null){
            System.out.println("HEHEHE");
            System.out.println(tmp);
            System.out.println(tmp%d);
            l1.val = tmp%d;
            if(tmp>=d) l1.next = new ListNode(1,null);
            return ptr;
        }
        else if(l1.next == null){
            l1.next = l2.next;
        }

        l1.val = tmp%d;
        l1.next.val += tmp/d;
        l1 = l1.next;

        while(l1.val>=d && l1.next!=null){
            l1.next.val += 1;
            l1.val = l1.val%=d;;
            l1 = l1.next;
        }
        if(l1.val>=d){
            l1.val %= d;
            l1.next = new ListNode(1, null);
        }
        return ptr;
    }
}

/*
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long a = 0L;
        long b = 0L;
        int cnt = 0;
        while(l1 != null){
            a += (long) l1.val* (long) Math.pow(10.0,(double)cnt);
            l1 = l1.next;
            cnt++;
        }
        cnt =0;
        while(l2 != null){
//            System.out.println((long) l2.val*(long) Math.pow(10.0,(double)cnt));
            b += (long) l2.val* (long) Math.pow(10.0,(double)cnt);
            l2 = l2.next;
            cnt++;
        }
//        System.out.println(a);
//        System.out.println(b);
        long ans = a+b;
//        System.out.println(ans);
        if( ans == 0){
            return new ListNode(0,null);
        }
        else{
            ListNode ptr = null, head = null;
            while (ans > 0) {
//                System.out.println(ans % 10L);
                if(ptr==null){
                    ptr = new ListNode((int)(ans % 10L));
                    head = ptr;
                }
                else{
                    ptr.next = new ListNode( (int)(ans % 10L), null);
                    ptr = ptr.next;
                }
                ans /= 10;
            }
            return head;
        }
    }
}
*/

public class Main {
    public static ListNode build_list(int[] arr){
        ListNode head,ptr;
        head = ptr = new ListNode(arr[0]);
        for(int i=1;i<arr.length;i++){
            ptr.next = new ListNode(arr[i]);
            ptr = ptr.next;
            if(i == arr.length-1) ptr.next = null;
        }
        return  head;
    }
    public static void main(String args[]){
        ListNode p1, p2, ptr;
        ArrayList<Integer> at = new ArrayList<Integer>();
        Solution tt = new Solution();
        int[][] l1 = {{9},{9,9,9,9,9,9,9},{0},{2,4,3},{5}};
        int[][] l2 = {{1,9,9,9,9,9,9,9,9,9},{9,9,9,9},{0},{5,6,4},{5}};
        for(int i=0; i< l1.length; i++){
            System.out.println("==========================");
            System.out.println(Arrays.toString(l1[i]));
            System.out.println(Arrays.toString(l2[i]));
            p1 = build_list(l1[i]);
            p2 = build_list(l2[i]);
            ptr = tt.addTwoNumbers(p1,p2);
            at.clear();
            while(ptr != null){
                //System.out.println(ptr.val);
                at.add(ptr.val);
                ptr = ptr.next;
            }
            System.out.println("----------------------");
            System.out.println(at.toString());
        }

    }
}
