package com.Q476_Number_Complement;


//9ms ver
/*
class Solution {
    public int findComplement(int num) {

        String str = Integer.toBinaryString(num);
        System.out.println(str);
        str = str.replaceAll("1","2");
        str = str.replaceAll("0","1");
        str = str.replaceAll("2","0");
        System.out.println(str);



        int n = Integer.parseInt(str,2);
        System.out.println(n);
        return n;
    }
}
*/

class Solution {
    public int findComplement(int num) {

//        System.out.println(num);
        int msb = 32 - Integer.numberOfLeadingZeros(num);
//        System.out.println("msb:");
//        System.out.println(msb);
//        System.out.println("(1<<msb)");
//        System.out.println((1<<msb));
        int inverse = ~num & ((1 << msb)-1);
        //System.out.println(inverse);
        return inverse;
    }
}

public class Main {
    public static void main(String[] args) {

        int[] inputs = {5,1,8};
        Solution solution = new Solution();
        for(int input : inputs){
            System.out.println(solution.findComplement(input));
            System.out.println("-----------");
        }

    }
}
