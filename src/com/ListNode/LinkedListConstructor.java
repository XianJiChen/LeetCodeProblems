package com.ListNode;
import com.ListNode.*;

import java.util.List;


public class LinkedListConstructor {
    private ListNode head;
    private ListNode tail;
    private int count;
    public ListNode construct(int[] input){
        this.head = this.tail = null;
        this.count = 0;
        if(input.length==0){
            return null;
        }
        this.count = input.length;

        head = tail = new ListNode(input[0]);
        for(int i=1; i<input.length; i++){
            tail.next = new ListNode(input[i]);
            if(i!=input.length-1){
                tail = tail.next;
            }
        }
        return head;
    }
    public void construct(List<Integer> input){
        if(input.size()==0){
            tail = head = null;
        }
        else{
            head = tail = new ListNode(input.get(0));
            for(int i=1; i<input.size(); i++){
                tail.next = new ListNode(input.get(i));
                if(i!=input.size()-1){
                    tail = tail.next;
                }
            }
        }
    }

    public ListNode getHead(){
        return this.head;
    }
    public ListNode getTail(){
        return this.tail;
    }

    public ListNode getNodeByIndex(int index){
        if(index<0|| index>this.count){
            return null;
        }
        ListNode cur = this.head;
        for(int i=0; i<index; i++){
            cur = cur.next;
        }
        return cur;
    }

    public ListNode getNodeByVal(int val){
        for(ListNode cur = this.head; cur!=null; cur = cur.next){
            if(cur.val==val){
                return cur;
            }
        }
        return null;
    }
}
