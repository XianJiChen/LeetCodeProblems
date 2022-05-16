package com.Q504_Base_7;

class Solution {
    public String convertToBase7(int num) {
        int num1 = Math.abs(num);
        StringBuilder sb = new StringBuilder();


        do{
            sb.append(num1%7);
            num1/=7;
        }
        while(num1!=0);

        if(num<0){
            sb.append("-");
        }

        return sb.reverse().toString();
    }
}

public class Main {
    public static void main(String[] args) {
        int[] inputs = {100,-7};
        Solution solution = new Solution();
        for(int input : inputs){
            System.out.println(solution.convertToBase7(input));
            System.out.println("=============");
        }
    }
}
