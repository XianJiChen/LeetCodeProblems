package com.Q412_Fizz_Buzz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


//2ms ver
/*
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new LinkedList<>();
        for(int i=1; i<=n; i++ ){
            if(i%3==0 && i%5==0){
                ans.add("FizzBuzz");
            }
            else if(i%3==0){
                ans.add("Fizz");
            }
            else if(i%5==0){
                ans.add("Buzz");
            }
            else{
                ans.add(String.valueOf(i));
            }
        }
        return ans;
    }
}
 */

class Solution {
    public List<String> fizzBuzz(int n) {
        String[] ans = new String[n];
        for(int i=1; i<=n; i++ ){
            if(i%3==0 && i%5==0){
                ans[i-1]="FizzBuzz";
            }
            else if(i%3==0){
                ans[i-1]="Fizz";
            }
            else if(i%5==0){
                ans[i-1]="Buzz";
            }
            else{
                ans[i-1]=String.valueOf(i);
            }
        }
        return Arrays.stream(ans).toList();
    }
}

public class Main {
    public static void main(String[] args) {
        int[] inputs = {3,5,15};
        Solution solution = new Solution();
        for(int input : inputs){
            System.out.println(solution.fizzBuzz(input));
            System.out.println("-------------");
        }
    }
}
