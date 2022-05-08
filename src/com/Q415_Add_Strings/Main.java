package com.Q415_Add_Strings;

//7ms
/*
class Solution {
    public String addStrings(String num1, String num2) {
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        StringBuilder sb = new StringBuilder();
        int tmp;
        boolean carry = false;
        for(int i=arr1.length-1, j=arr2.length-1;i>=0||j>=0||carry;){
            tmp = 0;

            if(i>=0){
                tmp += ((int)arr1[i--])-48;
            }

            if(j>=0){
                tmp += ((int)arr2[j--])-48;
            }

            if(carry){
                tmp += 1;
            }

            carry = (tmp>=10) ? true : false;
            tmp = (tmp>=10) ? tmp-10 : tmp;

            sb.insert(0,String.valueOf(tmp));
        }
        return sb.toString();
    }
}
*/

//3ms ver
/*
class Solution {
    public String addStrings(String num1, String num2) {
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        StringBuilder sb = new StringBuilder();
        int tmp;
        boolean carry = false;
        for(int i=arr1.length-1, j=arr2.length-1;i>=0||j>=0||carry;){
            tmp = 0;

            if(i>=0){
                tmp += ((int)arr1[i--])-48;
            }

            if(j>=0){
                tmp += ((int)arr2[j--])-48;
            }

            if(carry){
                tmp += 1;
            }

            carry = (tmp>=10) ? true : false;
            tmp = (tmp>=10) ? tmp-10 : tmp;

            sb.append(tmp);
        }
        return sb.reverse().toString();
    }
}
 */


//2ms ver
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int maxLen = Math.max(num1.length(), num2.length());
        char[] ans = new char[maxLen+1];
        int tmp;
        boolean carry = false;
        for(int i=num1.length()-1, j=num2.length()-1, k=maxLen;i>=0||j>=0||carry||k>=0;k--){
            tmp = 0;

            if(i>=0){
                tmp += num1.charAt(i--)-48;
            }

            if(j>=0){
                tmp += num2.charAt(j--)-48;
            }

            if(carry){
                tmp += 1;
            }

            carry = (tmp>=10) ? true : false;
            tmp = (tmp>=10) ? tmp-10 : tmp;

            ans[k] = (char) ('0'+tmp);
        }

        return (ans[0]=='0') ? String.valueOf(ans,1,maxLen) : String.valueOf(ans);
    }
}


public class Main {
    public static void main(String[] args) {
        String[] num1s = {"11","456","0","1"};
        String[] num2s = {"123","77","0","9"};
        Solution solution = new Solution();
        for(int i=0; i< num1s.length; i++){
            System.out.println(solution.addStrings(num1s[i],num2s[i]));
            System.out.println("============");
        }
    }
}
