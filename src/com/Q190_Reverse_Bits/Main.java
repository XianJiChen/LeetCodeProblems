package com.Q190_Reverse_Bits;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        System.out.printf("%d\n",n);
        System.out.println(Integer.toBinaryString(n));
        String str = new StringBuilder(Integer.toBinaryString(n)).reverse().toString();
//        char[] arr = Integer.toBinaryString(n).toCharArray();
//        int len = arr.length;
//        char tmp;
//        for(int i=0, j=len-1; i<j; i++, j--){
//            tmp = arr[i];
//            arr[i] = arr[j];
//            arr[j] = tmp;
//        }
//        String str = String.valueOf(arr);
//        System.out.println(str);
//        System.out.println(str);
//        System.out.println(str.length());
//        //str = str + "0".repeat(32-str.length());
//        System.out.println(str);
        System.out.println(Integer.parseInt(str,2));
        return Integer.parseInt(str,2);
    }
}
*/

//class Solution {
//
//    public int reverseBits(int num) {
//
//        num = ((num & 0xffff0000) >>> 16) | ((num & 0x0000ffff) << 16);
//        num = ((num & 0xff00ff00) >>> 8) | ((num & 0x00ff00ff) << 8);
//        num = ((num & 0xf0f0f0f0) >>> 4) | ((num & 0x0f0f0f0f) << 4);
//        num = ((num & 0xcccccccc) >>> 2) | ((num & 0x33333333) << 2);
//        num = ((num & 0xaaaaaaaa) >>> 1) | ((num & 0x55555555) << 1);
//
//        return num;
//
//    }
//}
/*
class Solution {
    public int reverseBits(int num) {
        StringBuilder sb = new StringBuilder();
        while(num>0){
            sb.append((num%2==0)? 0:1);
            num/=2;
        }
        String str = sb.toString();
        if(str.length()<32){
            str += "0".repeat(32-str.length());
        }
        return Integer.parseInt(str,2);
    }
}
*/

class Solution {
    public int reverseBits(int n) {
        return Integer.reverse(n);
    }
}


/*
964176192
----------------------
-1073741825
----------------------
 */

public class Main {
    public static void main(String[] args) {
        int[] inputs = {43261596,-3};//4294967293};
        Solution solution = new Solution();
        for(int input:inputs){
            System.out.println(solution.reverseBits(input));
            System.out.println("----------------------");
        }
    }
}
