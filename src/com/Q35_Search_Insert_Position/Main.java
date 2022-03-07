package com.Q35_Search_Insert_Position;

class Solution {
    private int[] arr;
    private int target;
    public int binarySearch(int left, int right){
//        System.out.println(left);
//        System.out.println(right);
//        System.out.println("----------------------");
        if(this.target<this.arr[left]){
            return left;
        }
        else if(this.target>this.arr[right]){
            return right+1;
        }
//        else if(this.target==this.arr[left]) {
//            return left;
//        }
//        else if(this.target==this.arr[right]) {
//            return right;
//        }
        else{
            int mid = (left+right)/2;
            if(this.target==this.arr[mid]){
                return mid;
            }
            else if(this.target<this.arr[mid]){
                return binarySearch(left,mid-1);
            }
            else if(this.target>this.arr[mid]){
                return binarySearch(mid+1, right);
            }
        }
        return -1;
    }
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        this.arr = nums;
        this.target = target;
        return binarySearch(0,len-1);
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{1,3,5,6},{1,3,5,6},{1,3,5,6},{1,3}};
        int[] targets = {5,2,7,2};
        Solution tt = new Solution();
        for(int i=0; i<inputs.length; i++){
            System.out.println(tt.searchInsert(inputs[i], targets[i]));
            System.out.println("======================================");
        }
    }
}
