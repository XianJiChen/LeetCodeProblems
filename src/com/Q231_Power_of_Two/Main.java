package com.Q231_Power_of_Two;


//16 ms
/*
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<1){
            return false;
        }

        while(n>1){
            System.out.println(n);
            if(n%2==1){
                return false;
            }
            n/=2;
        }
        return true;
    }
}
*/
//0ms ver
/*
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<1){
            return false;
        }
        int tmp = 1;
        for(tmp=1; tmp<n && tmp<Integer.MAX_VALUE/2; tmp*=2){

        }
        return (tmp==n);
    }
}

*/

class Solution{
    public boolean isPowerOfTwo(int n) {
        if(n < 1) return false;
        return (0 == ((n - 1) & n));
    }
}

public class Main {
    public static void main(String[] args) {
        int[] inputs = {1,16,3};
        Solution solution = new Solution();
        for(int input : inputs){
            System.out.println(solution.isPowerOfTwo(input));
            System.out.println("----------");
        }
    }
}
