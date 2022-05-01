package com.Q405_Convert_a_Number_to_Hexadecimal;


//3ms ver
/*
class Solution {
    public String toHex(int num) {
        return String.format("%h",num);
    }
}

 */

//0ms ver
class Solution {
    public String toHex(int num) {
        if(num==0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int tmp;
        int mask = (1<<4) - 1;
        while(num!=0){
            tmp = num & mask;
            //System.out.println((int)'0');
            /*
            if(tmp>9){
                sb.insert(0, (char)(97+tmp-10));//(char)('a'+tmp-10)
            }
            else{
                sb.insert(0, tmp);
            }

             */
            sb.insert(0, (tmp>9) ? (char)('a'+tmp-10) : (char)(48 + tmp));
            num>>>=4;
        }
        return sb.toString();
    }
}

/*
class Solution {
    public String toHex(int num) {
        StringBuilder sb = new StringBuilder();
        int tmp;
        int mask = (1<<4) - 1;
        while(num!=0){
            tmp = num & mask;
            sb.insert(0, (tmp>9) ? (char)('a'+tmp-10) : (char)(48 + tmp));
            num>>>=4;
        }
        return (sb.isEmpty()) ? "0" : sb.toString();
    }
}
 */

public class Main {
    public static void main(String[] args) {
        int[] inputs = {26,-1};//-1

        Solution solution = new Solution();
        for(int input : inputs){
            System.out.println(solution.toHex(input));
            System.out.println("===================");
        }
    }
}
