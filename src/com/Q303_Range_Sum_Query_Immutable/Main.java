package com.Q303_Range_Sum_Query_Immutable;

//91ms ver
/*
class NumArray {
    private int[] arr;
    public NumArray(int[] nums) {
        arr = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for(int i=left; i<=right; i++){
            sum += arr[i];
        }
        return sum;
    }
}
 */
//6ms ver
class NumArray {
    private int[] arr;
    private int[] sum;
    public NumArray(int[] nums) {
        arr = nums;
        sum = new int[arr.length];
        sum[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            sum[i] = sum[i-1] + arr[i];
        }
    }

    public int sumRange(int left, int right) {
        if(left==0){
            return sum[right];
        }
        else{
            return sum[right]-sum[left-1];
        }
    }
}

public class Main {
    public static void main(String[] args) {
        String[] cmds = {"NumArray", "sumRange", "sumRange", "sumRange"};
        int[][] inputs = {{-2, 0, 3, -5, 2, -1},{0, 2},{2,5},{0,5}};
        NumArray numArray = new NumArray(inputs[0]);
        for(int i=0; i< cmds.length; i++){
            String cmd = cmds[i];
            switch (cmd) {
                case "NumArray" -> {
                    numArray = new NumArray(inputs[i]);
                }
                case "sumRange" -> {
                    System.out.println(numArray.sumRange(inputs[i][0],inputs[i][1]));
                }
            }
            System.out.println("---------");
        }
    }
}
