package com.Q263_Ugly_Number;

//1ms ver
/*
class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        } else if (n == 1) {
            return true;
        } else {
            if (n % 2 == 0) {
                return isUgly(n / 2);
            } else if (n % 3 == 0) {
                return isUgly(n / 3);
            } else if (n % 5 == 0) {
                return isUgly(n / 5);
            }
        }
        return false;
    }
}
*/
//0ms ver
class Solution {
    public boolean isUgly(int n) {
        if(n<=0){
            return false;
        }
        else if(n==1){
            return true;
        }
        else{
            while (n>=2){
                if(n%2==0){
                    n/=2;
                }
                else if(n%3==0){
                    n/=3;
                }
                else if(n%5==0){
                    n/=5;
                }
                else{
                    return false;
                }
            }
            return (n==1);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isUgly(1));
        System.out.println(solution.isUgly(14));
        System.out.println(solution.isUgly(6));
        System.out.println(solution.isUgly(300));
        System.out.println(solution.isUgly(813));
        System.out.println(solution.isUgly(-8));
    }
}
