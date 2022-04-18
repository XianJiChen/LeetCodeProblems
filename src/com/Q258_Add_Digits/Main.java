package com.Q258_Add_Digits;


class Solution {
    public int addDigits(int num) {
        if(num<10){
            return num;
        }
        else{
            int tmp = 0;
            while(num!=0){
                tmp += num%10;
                num /= 10;
            }
            return addDigits(tmp);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addDigits(38));
        System.out.println(solution.addDigits(0));
    }
}
