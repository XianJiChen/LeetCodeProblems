package com.Q6_Zigzag_Conversion;
import com.sun.security.jgss.GSSUtil;

import java.util.*;
/*
    Using String is much slower than using char array
*/
//2ms ver
class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        int x = 2 * (numRows-1); // distance between pipes |/|/|...
        int len = s.length();
        char[] c = new char[len];
        char[] arr = s.toCharArray();
        //String ans="";
        int k =0;
        int stp;
        for(int i=0; i < numRows; i++)
        {
            stp = (numRows-1-i)*2;
            for(int j=i;j<len;j=j+x)
            {
                //c[k++] = s.charAt(j);
                c[k++] = arr[j];//s.charAt(j);
                if(stp != 0 && stp != x && j+stp<len)
                {
                    //c[k++] = s.charAt(j+x-2*i); // extra character between pipes
                    c[k++] = arr[j+stp];//s.charAt(j+stp);
                }
            }
        }
        return new String(c);//ans;
    }
}

//4ms ver(by simply changing the use of string into char array
/*
class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1||s.length()==1) return s;
        int len = s.length();
        char[] arr = s.toCharArray();
        char[] ans = new char[len];
        int margin_step = 2*(numRows-1);
        int[] steps = {0,0};
        int idx=0;
        int flip;
        int k=0;
        while(idx<len){
            ans[k++] = arr[idx];
            idx+= margin_step;
        }
        for(int i=1; i<numRows-1; i++){
            idx = i;
            steps[0] = 2*(numRows-(i+1));
            steps[1] = margin_step-steps[0];
            flip =0;
            while(idx<len){
                ans[k++] = arr[idx];
                idx+= steps[flip];
                flip = flip^1;
            }
        }
        idx = numRows-1;
        while(idx<len){
            ans[k++] = arr[idx];
            idx+= margin_step;
        }
        return new String(ans);
    }
}
*/

//25ms ver
/*
class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1||s.length()<=numRows) return s;
        char[] arr = s.toCharArray();
        String ans = "";
        int margin_step = 2*(numRows-1);
        int[] steps = {0,0};
        int len = s.length();
        int idx=0;
        int flip;
        while(idx<len){
            System.out.println(idx);
            ans += String.valueOf(arr[idx]);
            idx+= margin_step;
        }
        System.out.println("<<<<<<<<<<<<<<");
        for(int i=1; i<numRows-1; i++){
            idx = i;
            steps[0] = 2*(numRows-(i+1));
            steps[1] = margin_step-steps[0];
            flip =0;
            while(idx<len){
                ans += String.valueOf(arr[idx]);
                System.out.printf("%c",arr[idx]);
                idx+= steps[flip];
                flip = flip^1;
            }
            System.out.println("\n-------------\n");
        }
        System.out.println("<<<<<<<<<<<<<<<<");
        idx = numRows-1;
        while(idx<len){
            System.out.println(idx);
            ans += String.valueOf(arr[idx]);
            idx+= margin_step;
        }
        return ans;
    }
}
*/

/*
class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;

        int max=0, len = s.length();
        char[] s1 = s.toCharArray();
        String[] arr = new String[numRows];
        String ans = "";
        for(int i=0, index=0, dir=1; i<len; i++){
            if(index==0) dir =1;
            else if(index==numRows-1) dir=-1;
            if(arr[index]==null) arr[index] = String.valueOf(s1[i]);
            else arr[index]+= s1[i];
//            System.out.println(arr[index]);
//            System.out.println("-------------");
            index += dir;
        }
        for(int i=0;i<numRows; i++){
            if(arr[i]!=null) ans += arr[i];
        }
        return ans;
    }
}
*/

public class Main {
    public static void main(String[] args) {
        String[] inputs = {"PAYPALISHIRING","PAYPALISHIRING","A"};
        String[] answers = {"PAHNAPLSIIGYIR","PINALSIGYAHRPI","A"};
        String str;
        int[] nums = {3, 4, 1};
        Solution tt = new Solution();
        for(int i=0; i< nums.length; i++){
            str = tt.convert(inputs[i],nums[i]);
            if(!str.equals(answers[i])){
                System.out.println("My Answer:");
                System.out.println(str);
                System.out.println("Correct Answer:");
                System.out.println(answers[i]);
            }
            else{
                System.out.printf("Test Case %d Correct!!\n",i);
            }

            System.out.println("================");
        }
    }
}
