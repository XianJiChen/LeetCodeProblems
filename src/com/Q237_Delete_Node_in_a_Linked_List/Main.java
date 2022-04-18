package com.Q237_Delete_Node_in_a_Linked_List;

import com.ListNode.LinkedListConstructor;
import com.ListNode.ListNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}


public class Main {
    public static void main(String[] args) {
        List<List<Integer>> inputs = new ArrayList<>();
        inputs.add(new ArrayList<>(){{
            add(4);
            add(5);
            add(1);
            add(9);
        }});
        inputs.add(new ArrayList<>(){{
            add(4);
            add(5);
            add(1);
            add(9);
        }});

        int[] nodes = {5,1};

        LinkedListConstructor llc = new LinkedListConstructor();
        Solution solution = new Solution();
        ListNode head;
        ListNode node;
        for(int i=0; i<inputs.size(); i++){
            List<Integer> input = inputs.get(i);
            llc.construct(input);
            head = llc.getHead();
            node = llc.getNodeByVal(nodes[i]);
            solution.deleteNode(node);
            for(ListNode cur = head; cur!=null; cur = cur.next){
                System.out.println(cur.val);
            }
            System.out.println("============");
        }

    }
}
