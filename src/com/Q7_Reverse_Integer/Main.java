package com.Q7_Reverse_Integer;
import java.util.*;


//1ms & 96% mem ver
class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
//1ms 85% mem ver
/*
class Solution {
    public int reverse(int x) {
        long reverse = 0;
        while(x!=0){
            int last_digit = x%10;
            reverse=reverse*10+last_digit;
            x=x/10;
        }
        if(reverse<Integer.MIN_VALUE || reverse>Integer.MAX_VALUE){
            return 0;
        }
        return (int)reverse;
    }
}
*/

//2ms ver
/*
class Solution {
    public int reverse(int x) {
        long ans=0;
        long a = Math.abs(x);
        int t = (x<0) ? -1:1;
        int num, cnt =0;
        int digits=0;
        while(x>0){
            x/=10;
            digits++;
        }

        while(a>0){
            if(digits==9)
            cnt++;
            ans*=10l;
            ans += a%10l;
            a/=10;
            if(ans>(long)Integer.MAX_VALUE) return 0;
            System.out.println(a);
            System.out.println(ans);
            System.out.println("--------------------");
        }
        return (int)ans*t;
    }
}
*/
public class Main {
    public static void main(String[] args) {
        int[] inputs = {123,-123,120,1534236469,-2147483412};
        Solution tt = new Solution();
        for(int i=0; i< inputs.length; i++){
            System.out.println(tt.reverse(inputs[i]));
            System.out.println("=================");
        }
    }
}
