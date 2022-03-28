package com.Q202_Happy_Number;


import java.util.HashSet;


/*
class Solution {
    public boolean isHappy(int n) {
        int cnt = n;
        HashSet<Integer> appearedNums = new HashSet<>();
        while(cnt!=1){
            int ttl = 0;
            while(cnt>0){
                ttl += Math.pow(cnt%10,2);
                cnt/=10;
            }
            cnt = ttl;
            System.out.println(cnt);
            if(appearedNums.contains(cnt)){
                return false;
            }
            else{
                appearedNums.add(cnt);
            }
        }
        return true;
    }
}
*/

class Solution {
    public int compute(int n){
        int s = 0;
        while(n != 0){
            s += (n%10)*(n%10);
            n = n/10;
        }
        return s;
    }

    public boolean isHappy(int n) {
        int s = n, f = n; // slow , fast

        do {
            s = compute(s); // slow computes only once
            f = compute(compute(f)); // fast computes 2 times

            if (s == 1) return true; // if we found 1 then happy indeed !!!
        } while (s != f); // else at some point they will meet in the cycle

        return false; // it's a cycle , not happy at all !!!
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inputs = {19, 2, 15};
        for(int input : inputs){
            System.out.println(solution.isHappy(input));
            System.out.println("----------------------");
        }
    }
}
