package com.Q507_Perfect_Number;

import java.util.LinkedList;
import java.util.stream.Collectors;

//532ms ver
/*
class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num==1){
            return false;
        }
        LinkedList<Integer> divisors = new LinkedList<Integer>();
        divisors.add(1);
        int bound = num/2+1;
        for(int i=2; i<bound; i++){
            if(num%i==0){
                divisors.add(i);
                divisors.add(num/i);
                bound = num/i;
            }
        }
        System.out.println(divisors.toString());
        int tmp = divisors.stream().collect(Collectors.summingInt(i->i));
        return (tmp==num);
    }
}
 */
/*
class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num==1){
            return false;
        }
        LinkedList<Integer> divisors = new LinkedList<Integer>();
        divisors.add(1);
        int bound = num/2+1;

        for(int i=(num%2==1) ? 3:2; i<bound; i+=2){
            if(num%i==0){
                divisors.add(i);
                divisors.add(num/i);
                bound = num/i;
            }
        }
        System.out.println(divisors.toString());
        int tmp = divisors.stream().collect(Collectors.summingInt(i->i));
        return (tmp==num);
    }
}
*/
/*
class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num==1){
            return false;
        }
        LinkedList<Integer> divisors = new LinkedList<Integer>();
        divisors.add(1);
        int bound = (int) Math.sqrt(num)+1;

        for(int i=(num%2==1) ? 3:2; i<bound; i+=2){
            if(num%i==0){
                divisors.add(i);
                divisors.add(num/i);
                bound = num/i;
            }
        }
        System.out.println(divisors.toString());
        int tmp = divisors.stream().collect(Collectors.summingInt(i->i));
        return (tmp==num);
    }
}

 */
class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num==1){
            return false;
        }
        int sum=1;
        int bound = (int) Math.sqrt(num) +1;
        for(int i=(num%2==1) ? 3:2; i<bound; i+=2){
            if(num%i==0){
                sum+= (i + num/i);
            }
        }

        return (sum==num);
    }
}
//1ms ver
public class Main {
    public static void main(String[] args) {
        int[] inputs = {28, 7, 1, 6};
        Solution solution = new Solution();
        for(int input : inputs){
            System.out.println(solution.checkPerfectNumber(input));
            System.out.println("=================");
        }
    }
}
