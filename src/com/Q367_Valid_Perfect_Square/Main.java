package com.Q367_Valid_Perfect_Square;
//719ms ver
/*
class Solution {
    public boolean isPerfectSquare(int num) {
        int bound = num/2 + num%2;
        int tmp;
        for(int i=1; i<=bound; i++){
            tmp = i*i;
            if(tmp==num){
                return true;
            }
            if(tmp>num){
                return false;
            }
        }
        return false;
    }
}
*/

class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num/2 + num%2;
        int mid=1;
        while(left<right){
            mid = (left+right)/2;
//            System.out.println(left);
//            System.out.println(right);
//            System.out.println(num/mid);
//            System.out.println("----");
            if(num/mid==mid && num%mid==0){
                return true;
            }
            else if(num/mid>=mid){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return (num%left==0 && num/left==left);
    }
}

public class Main {
    public static void main(String[] args) {
        int[] inputs = {16, 14, 20, 24, 28, 36, 100, 4};
        Solution solution = new Solution();
        for(int input : inputs){
            System.out.println(solution.isPerfectSquare(input));
            System.out.println("====");
        }
    }
}
