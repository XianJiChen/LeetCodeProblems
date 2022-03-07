package com.Q29_Divide_Two_Integers;
//Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
//no * / % ==> only + -
class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==0) return 0;
        else if(dividend==divisor) return 1;
        long end, sor, k=0;
        boolean same;
        if(dividend>0&&divisor>0){
            same = true;
            end = dividend;
            sor = divisor;
        }
        else {
            same = (dividend<0&&divisor<0) ? true : false;
            end = Math.abs((long)dividend);
            sor = Math.abs((long)divisor);
        }
        System.out.println(end);
        System.out.println(sor);
        System.out.println("------------------");
        if(sor==1) {
            k=end;
            System.out.println("AAAAAAAAAAAAAAAAA");
        }
        else if(end>=sor){
            for(long sum=0; sum+sor<=end; sum+=sor){
                k++;
//                System.out.println(sum);
//                System.out.println("------------------");
            }
        }
        else{
            System.out.println("CCCCCCCCCCCCCCC");
        }

        k = (same) ? k : k*-1;
        if(k<Integer.MIN_VALUE) k = Integer.MIN_VALUE;
        else if(k>Integer.MAX_VALUE) k = Integer.MAX_VALUE;
        return (int)k;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] ends = {10,7,-1,-2147483648,10,-1010369383};
        int[] sors = {3,-3,-1,-1,-10,-2147483648};
        Solution tt = new Solution();
        for(int i=0; i<ends.length; i++){
            System.out.println(tt.divide(ends[i], sors[i]));
            System.out.println("==================");
        }
    }
}
