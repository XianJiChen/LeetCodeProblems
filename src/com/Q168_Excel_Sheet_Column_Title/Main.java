package com.Q168_Excel_Sheet_Column_Title;

//
/*
class Solution {
    public String convertToTitle(int columnNumber) {
        int tmp;
        boolean flag = false;
        String ans = "";
        while(columnNumber>26){
            tmp = columnNumber%26;
            tmp = (tmp==0) ? 26 : tmp;
            ans =  (char) (64+tmp) + ans;
//            System.out.println("<<<");
//            System.out.println((char) (64+tmp));
//            System.out.println(64+tmp);
//            System.out.println(">>>");
            columnNumber/=26;
            columnNumber = (tmp==26) ? columnNumber-1 : columnNumber;
        }
        ans = (char)(64+columnNumber) + ans;
        return ans;
    }
}
*/
//0ms ver
//just simply change the use of String to StringBuilder
class Solution {
    public String convertToTitle(int columnNumber) {
        int tmp;
        StringBuilder sb = new StringBuilder();
        while(columnNumber>26){
            tmp = columnNumber%26;
            tmp = (tmp==0) ? 26 : tmp;
            sb.append((char)(64+tmp));
            columnNumber/=26;
            columnNumber = (tmp==26) ? columnNumber-1 : columnNumber;
        }
        sb.append((char)(64+columnNumber));
        return sb.reverse().toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println((int)'A');//65
//        System.out.println((int)'Z');//90
        System.out.println(solution.convertToTitle(1));
        System.out.println(solution.convertToTitle(28));
        System.out.println(solution.convertToTitle(701));
        System.out.println(solution.convertToTitle(52));
        System.out.println(solution.convertToTitle(702));

    }
}
