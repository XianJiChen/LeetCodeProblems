package com.Q67_Add_Binary;

import java.util.Arrays;

//13ms ver
/*
class Solution {
    public String addBinary(String a, String b) {
        int idxA, idxB, lenA, lenB;
        char[] arrayA, arrayB;
        arrayA = a.toCharArray();
        arrayB = b.toCharArray();
        lenA = arrayA.length;
        lenB = arrayB.length;
        String ans = "";
        char carry = '0';
        for(idxA= arrayA.length-1, idxB=arrayB.length-1; idxA>=0 && idxB>=0; idxA--, idxB--){
            if(arrayA[idxA]=='1'&&arrayB[idxB]=='1'){
                ans = carry + ans;
                carry = '1';
            }
            else if(arrayA[idxA]=='0'&&arrayB[idxB]=='0'){
                ans = carry + ans;
                carry = '0';
            }
            else{
                if(carry=='1'){
                    ans = '0' + ans;
                }
                else if(carry=='0'){
                    ans = '1' + ans;
                }
            }
        }
        while(idxA>=0){
            if(arrayA[idxA]=='0'){
                ans = carry + ans;
                carry = '0';
            }
            else{
                if(carry=='1'){
                    ans = '0' + ans;
                }
                else if(carry=='0'){
                    ans = '1' + ans;
                }
            }
            idxA--;
        }
        while(idxB>=0){
            if(arrayB[idxB]=='0'){
                ans = carry + ans;
                carry = '0';
            }
            else{
                if(carry=='1'){
                    ans = '0' + ans;
                }
                else if(carry=='0'){
                    ans = '1' + ans;
                }
            }
            idxB--;
        }
        if(carry=='1'){
            ans = '1'+ans;
        }
        return ans;
    }
}
*/
//4ms ver
/*
class Solution {
    public String addBinary(String a, String b) {
        int idxA, idxB, lenA, lenB;
        char[] arrayA, arrayB;
        arrayA = a.toCharArray();
        arrayB = b.toCharArray();
        lenA = arrayA.length;
        lenB = arrayB.length;
        StringBuilder SB = new StringBuilder();
        int carry = 0;
        for(idxA= arrayA.length-1, idxB=arrayB.length-1; idxA>=0 && idxB>=0; idxA--, idxB--){
            if(arrayA[idxA]=='1'&&arrayB[idxB]=='1'){
                SB.insert(0, carry);
                carry = 1;
            }
            else if(arrayA[idxA]=='0'&&arrayB[idxB]=='0'){
                SB.insert(0, carry);
                carry = 0;
            }
            else{
                SB.insert(0, 1-carry);
            }
        }
        while(idxA>=0){
            if(arrayA[idxA]=='0'){
                SB.insert(0,carry);
                carry = 0;
            }
            else{
                SB.insert(0, 1-carry);
            }
            idxA--;
        }
        while(idxB>=0){
            if(arrayB[idxB]=='0'){
                SB.insert(0,carry);
                carry = 0;
            }
            else{
                SB.insert(0, 1-carry);
            }
            idxB--;
        }
        if(carry==1){
            SB.insert(0,1);
        }
        return SB.toString();
    }
}
*/
//1ms ver
/*
class Solution {
    public String addBinary(String a, String b) {
        int maxLength = Math.max(a.length(),b.length());
        int aIndex = a.length()-1;
        int bIndex = b.length()-1;
        int carry = 0;
        StringBuilder invertedSum = new StringBuilder();
        while(aIndex>=0 || bIndex>=0) {
            int av = 0;
            if(aIndex>=0) { av = a.charAt(aIndex--)-'0'; }

            int bv = 0;
            if(bIndex>=0) { bv = b.charAt(bIndex--)-'0'; }

            int tmpSum = av + bv + carry;
            if(tmpSum<=1) {
                invertedSum.insert(0,tmpSum);
                carry=0;
            } else if(tmpSum==2) {
                invertedSum.insert(0,0);
                carry=1;
            } else if(tmpSum==3) {
                invertedSum.insert(0,1);
            }

        }

        if(carry!=0) {
            invertedSum.insert(0,carry);
        }

        return invertedSum.toString();
    }
}
*/
//modified version of the above version
/*
class Solution {
	public String addBinary(String a, String b) {
        int lenA, lenB;
        lenA = a.length();
        lenB = b.length();
        int maxLength = (lenA>lenB) ? lenA:lenB;
        int aIndex = lenA-1;
        int bIndex = lenB-1;
        int carry = 0;
        StringBuilder invertedSum = new StringBuilder();
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();
        int av, bv, tmpSum;
        while(aIndex>=0 || bIndex>=0) {
            av = (aIndex>=0) ? arrA[aIndex--]-'0' : 0;
            bv = (bIndex>=0) ? bv = arrB[bIndex--]-'0' : 0;

            tmpSum = av + bv + carry;
            if(tmpSum<=1) {
                invertedSum.insert(0,tmpSum);
                carry=0;
            } else if(tmpSum==2) {
                invertedSum.insert(0,0);
                carry=1;
            } else if(tmpSum==3) {
                invertedSum.insert(0,1);
            }

        }

        if(carry!=0) {
            invertedSum.insert(0,carry);
        }

        return invertedSum.toString();
    }
}
 */
//another 1ms version(mostly 2ms or 1ms)
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        int sum;
        while(i >= 0 || j >= 0){
            sum = carry;
            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';
            carry = sum > 1 ? 1 : 0;
            res.append(sum % 2);
            //res.insert(0, sum%2);
        }
        if(carry != 0) res.append(carry);
        //if(carry != 0) res.insert(0,carry);
        return res.reverse().toString();
        //return res.toString();
    }
}
public class Main {
    public static void main(String[] args) {
        String[] input1s = {"11","1010"};
        String[] input2s = {"1","1011"};
        Solution tt= new Solution();
        for(int i=0; i<input1s.length; i++){
            System.out.println(tt.addBinary(input1s[i], input2s[i]));
            System.out.println("===================");
        }
    }
}
