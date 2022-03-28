package com.Q225_Implement_Stack_using_Queues;


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


//0ms ver
/*
class MyStack {

    //private final Queue<Integer> queue;
    private final Deque<Integer> deque;
    public MyStack() {
        //this.queue = new LinkedList<>();
        this.deque = new LinkedList<>();
    }

    public void push(int x) {
        //this.queue.add(x);
        this.deque.push(x);
    }

    public int pop() {
        return this.deque.pop();
    }

    public int top() {
        return this.deque.peek();
    }

    public boolean empty() {
        return this.deque.isEmpty();
    }
}
*/

//another oms ver
class MyStack {

    private int size;
    private int[] arr;
    private int idx;
    private boolean isFull(){
        return (this.arr.length==this.size);
    }

    private void doubleArr(){
        int[] newArr = new int[this.size*2];
        System.arraycopy(this.arr,0,newArr,0,this.size);
        this.arr = newArr;
        this.size*=2;
    }

    public MyStack() {
        this.size = 5;
        this.arr = new int[this.size];
        this.idx = 0;
    }

    public void push(int x) {
        if(isFull()){
            doubleArr();
        }
        this.arr[this.idx++] = x;
    }

    public int pop() {
        return this.arr[--this.idx];
    }

    public int top() {
        return this.arr[this.idx-1];
    }

    public boolean empty() {
        return (this.idx==0);
    }
}

public class Main {
    public static void main(String[] args) {
        String[] inputCmd = {"MyStack", "push", "push", "top", "pop", "empty"};
        int[][] inputArgs = {{}, {1}, {2}, {}, {}, {}};
        MyStack myStack = new MyStack();
        for(int i=0; i<inputCmd.length; i++){
            String cmd = inputCmd[i];
            switch (cmd){
                case "MyStack" ->{
                    myStack = new MyStack();
                }
                case "push" -> {
                    myStack.push(inputArgs[i][0]);
                }
                case "top" -> {
                    System.out.println(myStack.top());
                }
                case "pop" -> {
                    System.out.println(myStack.pop());
                }
                case "empty" -> {
                    System.out.println(myStack.empty());
                }
            }
            System.out.println("------");
        }
    }
}
