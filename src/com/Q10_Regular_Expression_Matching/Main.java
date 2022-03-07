//package com.Q10_Regular_Expression_Matching;
///*
//class Solution {
//    public char[] str;
//    public char[] reg;
//    public boolean isMatch_sub(int i, int j){
//
//    }
//    public boolean isMatch(String s, String p) {
//        str = s.toCharArray();
//        reg = p.toCharArray();
//        int i, j;
//        for(i=0, j=0; i<str.length && j<reg.length; i++, j++){
//            System.out.println("<<<<<<<<<<<<<<");
//            System.out.printf("Str: %dth position: %c\n", i,str[i]);
//            System.out.printf("Reg: %dth position: %c\n", j,reg[j]);
//            System.out.println("--------------");
//            if(j!= reg.length-1){
//                switch (reg[j+1]){
//                    case '*':
//                        if(reg[j]=='.'){
//                            if(j+1 == reg.length-1) return true;//while(i<str.length) i++;//when the * character is at the end of reg
//                            else for(;i<str.length && str[i] != reg[j+2];i++) {
//                                if(this.isMatch_sub())
//                            }
//                        }
//                        else{
//                            if(str[i] == reg[j]){
//                                while(i<str.length && str[i] == reg[j]) i++;
//                            }
//                            if((j+1<reg.length && reg[j+1]==reg[j]) || (j+2<reg.length && reg[j+2]==reg[j] && reg[j+1]=='*')){
//                                while(j+1<reg.length || j+2<reg.length) {
//                                    if(reg[j+2]==reg[j] && reg[j+1]=='*') j+=2;
//                                    else if(reg[j+1]==reg[j]) j++;
//                                    else break;
//                                }
//                                j-=1;
//                            }
//                        }
//                        j++;
//                        i--;
//                        //if(i==str.length) i--;
//                        break;
//                    case '.':
//                        if(str[i] != '.' && str[i] != reg[j]) return  false;
//                        else{
//                            i++;
//                            j++;
//                        }
//                        break;
//                    default:
//                        if(str[i] != '.' && str[i] != reg[j]) return  false;
//                        break;
//                }
//            }
//            else{
//                if(reg[j]=='.') return (i==str.length-1);
//                else if(str[i] != reg[j]) return  false;
//            }
//            System.out.println(">>>>>>>>>>>>>>");
//        }
//        if()
//            return (i>=str.length && j>=reg.length)? true : false;
//    }
//}
//*/
//    /*
//    public boolean isMatch(String s, String p) {
//        str = s.toCharArray();
//        reg = p.toCharArray();
//        int i, j;
//        for(i=0, j=0; i<str.length && j<reg.length; i++, j++){
//            System.out.println("<<<<<<<<<<<<<<");
//            System.out.printf("Str: %dth position: %c\n", i,str[i]);
//            System.out.printf("Reg: %dth position: %c\n", j,reg[j]);
//            System.out.println("--------------");
//            if(j!= reg.length-1){
//                switch (reg[j+1]){
//                    case '*':
//                        if(reg[j]=='.'){
//                            if(j+1 == reg.length-1) return true;//while(i<str.length) i++;//when the * character is at the end of reg
//                            else while(i<str.length && str[i] != reg[j+2]) i++;
//                        }
//                        else{
//                            if(str[i] == reg[j]){
//                                while(i<str.length && str[i] == reg[j]) i++;
//                            }
//                            if((j+1<reg.length && reg[j+1]==reg[j]) || (j+2<reg.length && reg[j+2]==reg[j] && reg[j+1]=='*')){
//                                while(j+1<reg.length || j+2<reg.length) {
//                                    if(reg[j+2]==reg[j] && reg[j+1]=='*') j+=2;
//                                    else if(reg[j+1]==reg[j]) j++;
//                                    else break;
//                                }
//                                j-=1;
//                            }
//                        }
//                        j++;
//                        i--;
//                        //if(i==str.length) i--;
//                        break;
//                    case '.':
//                        if(str[i] != '.' && str[i] != reg[j]) return  false;
//                        else{
//                            i++;
//                            j++;
//                        }
//                        break;
//                    default:
//                        if(str[i] != '.' && str[i] != reg[j]) return  false;
//                        break;
//                }
//            }
//            else{
//                if(reg[j]=='.') return (i==str.length-1);
//                else if(str[i] != reg[j]) return  false;
//            }
//            System.out.println(">>>>>>>>>>>>>>");
//        }
//        if()
//        return (i>=str.length && j>=reg.length)? true : false;
//    }
//     */
//}
//
///*
//class Solution {
//    public boolean isMatch(String s, String p) {
//        char[] str = s.toCharArray();
//        char[] reg = p.toCharArray();
//        int i, j;
//        for(i=0, j=0; i<str.length && j<reg.length; i++, j++) {
//            if(reg[j] == '*'){
//                if(reg[j-1]=='.') {
//                    while(i+1<str.length){
//                        if(j+1<reg.length && str[i+1]==reg[j+1]) break;
//                        else i++;
//                    }
//                }
//                else {
//                    while(i<str.length && str[i]==reg[j-1]) i++;
//                    if(i==str.length) i--;
//                }
//            }
//            else if(reg[j]=='.'){
//                continue;
//            }
//            else{
//                if(str[i]!=reg[j]) return false;
//            }
//        }
//        return (i==str.length && j==reg.length) ? true : false;
//    }
//}
//*/
//
//public class Main {
//    public static void main(String[] args) {
//        String[] inputs1 = {"aa", "aa","ab", "aab", "mississippi","mississippi","aaa","aaa", "aaa"};//aaaabc,
//        String[] inputs2 = {"a", "a*", ".*", "c*a*b", "mis*is*ip*.", "mis*is*p*.", "a.a", "a*a", "ab*a*c*a"};//.*aabc
//        Solution tt = new Solution();
//
//        for(int i=0; i<inputs1.length; i++){
//            System.out.println(inputs1[i]);
//            System.out.println(inputs2[i]);
//            System.out.println(tt.isMatch(inputs1[i],inputs2[i]));
//            System.out.println("==============================");
//        }
////        int i = inputs1.length-1;
////        System.out.println(inputs1[i]);
////        System.out.println(inputs2[i]);
////        System.out.println(tt.isMatch(inputs1[i],inputs2[i]));
//    }
//}
