package com.Q12_Integer_to_Roman;

//3ms 100%

class Solution {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int[] div = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < div.length;) {
            if (num >= div[i]) {
                result.append(roman[i]);
                num -= div[i];
            }
            else i++;
        }

        return result.toString();
    }
}

//13ms
/*
class Solution {
    public String intToRoman(int num) {
        //StringBuilder sb = new StringBuilder();
        String s = "";
        int tmp;
        while(num>=1000){
            num-=1000;
            //sb.append("M");
            s+="M";
        }

        if(num>=900){
            num-=900;
            //sb.append("CM");
            s+="CM";
        }
        else if(num>=500){
            //sb.append("D");
            s+="D";
            for(tmp=0; tmp<(num-500)/100; tmp++) s+="C";//sb.append("C");
            num%=100;
        }
        else if(num>=400){
            //sb.append("CD");
            s+="CD";
            num-=400;
        }
        else if(num>=100){
            for(tmp=0; tmp<num/100; tmp++) s+="C";//sb.append("C");
            num%=100;
        }

        if(num>=90){
            num-=90;
            //sb.append("XC");
            s+="XC";
        }
        else if(num>=50){
            //sb.append("L");
            s+="L";
            for(tmp=0; tmp<(num-50)/10; tmp++) s+="X";//sb.append("X");
            num%=10;
        }
        else if(num>=40){
            //sb.append("XL");
            s+="XL";
            num-=40;
        }
        else if(num>=10){
            for(tmp=0; tmp<num/10; tmp++) s+="X";//sb.append("X");
            num%=10;
        }

        if(num>=9){
            num-=9;
            //sb.append("IX");
            s+="IX";
        }
        else if(num>=5){
            //sb.append("V");
            s+="V";
            for(tmp=0; tmp<(num-5); tmp++) s+="I";//sb.append("I");
            num%=10;
        }
        else if(num>=4){
            //sb.append("IV");
            s+="IV";
            num-=40;
        }
        else if(num>=1){
            for(tmp=0; tmp<num; tmp++) s+="I";//sb.append("I");
            num%=10;
        }
    return s;//sb.toString();
    }
}
*/
public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 58, 1994};
        Solution tt = new Solution();
        for(int a: arr){
            System.out.println(tt.intToRoman(a));
            System.out.println("=============");
        }
    }
}
