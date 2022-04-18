package com.Q232_Implement_Queue_using_Stacks;

import javax.xml.transform.SourceLocator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class MyQueue {

    private List<Integer> arr;

    public MyQueue() {
        arr = new LinkedList<Integer>();
    }

    public void push(int x) {
        arr.add(x);
    }

    public int pop() {
        return arr.remove(0);
    }

    public int peek() {
        return arr.get(0);
    }

    public boolean empty() {
        return (arr.size()==0);
    }
}

public class Main {
    public static void main(String[] args) {
        String[] cmds  = {"MyQueue", "push", "push", "peek", "pop", "empty"};
        int[][] nums = {{}, {1}, {2}, {}, {}, {}};
        MyQueue myQueue = null;
        String toShow = null;
        for(int i=0; i<cmds.length; i++){
            switch (cmds[i]){
                case "MyQueue": {
                    myQueue = new MyQueue();
                    toShow = null;
                    break;
                }
                case "push": {
                    myQueue.push(nums[i][0]);
                    toShow = null;
                    break;
                }
                case "peek": {
                    toShow = String.valueOf(myQueue.peek());
                    break;
                }
                case "pop" : {
                    toShow = String.valueOf(myQueue.pop());
                    break;
                }
                case "empty" : {
                    toShow = String.valueOf(myQueue.empty());
                    break;
                }
            }
            System.out.println(toShow);
            System.out.println("------------------");
        }
    }
}
