package com.Q234_Palindrome_Linked_List;

import com.ListNode.*;

import java.util.List;
import java.util.Stack;

//23ms ver
/*
class Solution {
    public boolean isPalindrome(ListNode head) {
        int cnt = 0;
        Stack<Integer> stack = new Stack<Integer>();
        ListNode cur = head;
        while(cur!=null){
            cnt++;
            cur = cur.next;
        }
        for(int i=0; i<cnt/2; i++){
            stack.add(head.val);
            head = head.next;
        }
        if(cnt%2==1){
            head = head.next;
        }
        for(int i=0; i<cnt/2; i++){
            if(stack.pop()!=head.val){
                return false;
            }
            else {
                head = head.next;
            }
        }
        return true;
    }
}
*/

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }

        ListNode oneStepPrev = null;
        ListNode oneStepNode = head;
        ListNode oneStepNext = head.next;
        ListNode twoStepNode = head.next;

        while(twoStepNode!=null && twoStepNode.next!=null){
            oneStepNode.next = oneStepPrev;
            oneStepPrev = oneStepNode;
            oneStepNode = oneStepNext;
            oneStepNext = oneStepNext.next;
            twoStepNode = twoStepNode.next.next;
        }


        if(twoStepNode==null) {
            oneStepNode = oneStepPrev;
        }
        else{
            oneStepNode.next = oneStepPrev;
        }

        twoStepNode = oneStepNext;

        while(oneStepNode!=null && twoStepNode!=null){
            System.out.println(oneStepNode.val);
            System.out.println(twoStepNode.val);
            if(oneStepNode.val != twoStepNode.val){
                return false;
            }
            oneStepNode = oneStepNode.next;
            twoStepNode = twoStepNode.next;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{1,2,2,1},{1,2},{1,0,0}};
        Solution solution = new Solution();
        LinkedListConstructor llc = new LinkedListConstructor();
        for(int[] input : inputs){
            llc.construct(input);
            System.out.println(solution.isPalindrome(llc.getHead()));
            System.out.println("------------------------------");
        }
    }
}
