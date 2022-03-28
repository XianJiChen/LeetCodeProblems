package com.ListNode;
import com.ListNode.*;

import java.util.List;


public class LinkedListConstructor {
    private ListNode head;
    private ListNode tail;
    public ListNode construct(int[] input){
        this.head = this.tail = null;
        if(input.length==0){
            return null;
        }

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
}
