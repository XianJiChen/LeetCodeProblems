package com.Q155_Min_Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//7ms ver
/*
class MinStack {
    private Stack<Integer> stack;
    private int min;
    public MinStack() {
        this.stack = new Stack<Integer>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        this.stack.push(val);
        this.min = (this.min<val) ? this.min : val;
    }

    public void pop() {
        int tmp = this.stack.pop();
        if(tmp==this.min){
            this.min = Integer.MAX_VALUE;
            for(int val:this.stack){
                this.min = (this.min<val) ? this.min : val;
            }
        }
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        return this.min;
    }
}
*/
//5ms ver
/*
class MinStack {
    private List<Integer> stack;
    // private int cnt;
    private int min;
    public MinStack() {
        this.stack = new ArrayList<Integer>();
        // this.cnt = 0;
        this.min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        this.stack.add(val);
        // this.cnt++;
        this.min = (this.min<val) ? this.min : val;
    }

    public void pop() {
        int tmp = this.stack.get(this.stack.size()-1);
        this.stack.remove(this.stack.size()-1);
        if(tmp==this.min){
            this.min = Integer.MAX_VALUE;
            for(int val:this.stack){
                this.min = (this.min<val) ? this.min : val;
            }
        }
    }

    public int top() {
        return  this.stack.get(this.stack.size()-1);
    }

    public int getMin() {
        return this.min;
    }
}
*/
//2ms ver
class MinStack {
    private int[] stack;
    private int cnt;
    private int min;
    public MinStack() {
        this.stack = new int[10];
        this.cnt = 0;
        this.min = Integer.MAX_VALUE;
    }

    private boolean isFull(){
        return (this.stack.length==this.cnt);
    }

    public void doubleArr(){
        int[] newStack = new int[this.cnt*2];
        System.arraycopy(this.stack, 0 , newStack, 0, this.cnt);
        this.stack = newStack;
    }

    public void push(int val) {
        if(this.isFull()){
            this.doubleArr();
        }
        this.stack[this.cnt++] = val;
        this.min = (this.min<val)? this.min : val;
    }

    public void pop() {
        this.cnt--;
        if(this.stack[this.cnt]==this.min){
            this.min = Integer.MAX_VALUE;
            for(int i=0; i<this.cnt; i++){
                this.min = (this.min<this.stack[i])? this.min : this.stack[i];
            }
        }
    }

    public int top() {
        return this.stack[this.cnt-1];
    }

    public int getMin() {
        return this.min;
    }
}
public class Main {
    public static void main(String[] args) {

    }
}
