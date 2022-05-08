package com.Q441_Arranging_Coins_UNDONE;

class Solution {
    private int getAggregate(int n){
        return (1+n) * n /2;
    }

    public int arrangeCoins(int n) {
        int level = 1;
        while(getAggregate(level+1)<=n){
            level++;
        }
        /*
        if(n<getAggregate(level)){
            level--;
        }
        */
        return level;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] inputs = {5,8,3};
        Solution solution = new Solution();
        for(int input : inputs){
            System.out.println(solution.arrangeCoins(input));
            System.out.println("========");
        }
    }
}
