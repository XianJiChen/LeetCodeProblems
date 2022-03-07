package com.Q70_Climbing_Stairs;

/*
class Solution {
    public long combination(int n, int k){
        k = (n-k<k) ? n-k : k;
        long a = 1, b = 1;
        for(int i=0; i<k ;i++){
            a*=(n-i);//would cause overflow
            b*=(1+i);
        }
        return a/b;
    }
    public long factorial(int n){
        long ans = 1;
        for(long i=n; i>1; i--){
            ans*=i;
        }
        return ans;
    }
    public int climbStairs(int n) {
        int numOf1Steps;
        int numOfWays = 0;
        long tmp;
        for(int numOf2Steps = n/2; numOf2Steps>=0; numOf2Steps--){
            numOf1Steps = n-2*numOf2Steps;
            System.out.println(numOf1Steps);
            System.out.println(numOf2Steps);
//            tmp = (factorial(numOf2Steps)*factorial(numOf1Steps));
//            tmp = (factorial(numOf2Steps+numOf1Steps)/tmp);
            tmp = combination(Math.max(numOf1Steps, numOf2Steps)+1, Math.min(numOf1Steps,numOf2Steps));
            System.out.println(tmp);
            System.out.println("---------------------------");
            numOfWays += tmp;
        }
        return numOfWays;
    }
}
*/
/*
class Solution {
    public long combination(int n, int k){
        k = (n-k<k) ? n-k : k;
        long a = 1, b = 1;
        for(int i=0; i<k ;i++){
            a*=(n-i);//would cause overflow
            b*=(1+i);
        }
        return a/b;
    }
    public long factorial(int n){
        long ans = 1;
        for(int i=n; i>1; i--){
            ans*=i;
        }
        return ans;
    }
    public int climbStairs(int n) {
        int numOf1Steps;
        int numOfWays = 0;
        long tmp;
        for(int numOf2Steps = n/2; numOf2Steps>=0; numOf2Steps--){
            numOf1Steps = n-2*numOf2Steps;
            System.out.println(numOf1Steps);
            System.out.println(numOf2Steps);
            System.out.println("--------------------------------");
            //tmp = combination(numOf1Steps+numOf2Steps, Math.max(numOf1Steps,numOf2Steps));
            //System.out.println(tmp);
            //tmp = tmp/factorial(Math.min(numOf1Steps,numOf2Steps));

            tmp = (factorial(numOf2Steps+numOf1Steps)/factorial(numOf2Steps))*factorial(numOf1Steps);
            numOfWays += tmp;
            System.out.println(tmp);
//            System.out.println(numOfWays);
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        }
        return numOfWays;
    }
}
 */
//0ms ver
class Solution {
    public int combination(int n, int k){
        k = (n-k<k) ? n-k : k;
        long a = 1;
        for(long i=0; i<k ;i++){
            a= a*(n-i)/(1+i);
        }
        return (int) a;
    }
    public int climbStairs(int n) {
        int numOf1Steps;
        int numOfWays = 0;
        int tmp;
        for(int numOf2Steps = n/2; numOf2Steps>=0; numOf2Steps--){
            numOf1Steps = n-2*numOf2Steps;
            tmp = combination(numOf1Steps+numOf2Steps,numOf1Steps);
//            System.out.println(numOf1Steps);
//            System.out.println(numOf2Steps);
//            System.out.println(tmp);
//            System.out.println("-----------------");
            numOfWays += tmp;
        }
        return numOfWays;
    }
}
public class Main {
    public static void main(String[] args) {
        int[] inputs = {1, 2,3, 35, 44, 45, 47};
        Solution tt = new Solution();
        for (int input:inputs){
            System.out.println(tt.climbStairs(input));
            System.out.println("==============");//=============================================================================");
        }
    }
}
