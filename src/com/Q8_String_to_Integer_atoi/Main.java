package com.Q8_String_to_Integer_atoi;

class Solution {
    public int myAtoi(String s) {
        char[] arr = s.toCharArray();
        int ans=0;
        int idx;
        int pop;
        int positive = 1;
        boolean already_digit = false;
        for(idx=0;idx<arr.length; idx++){
            if(arr[idx]==' ') continue;

            switch (arr[idx]){
                case '+':
                    if(already_digit) return ans*positive;
                    else{
                        already_digit = true;
                    }
                    break;
                case '-':
                    if(already_digit) return ans*positive;
                    else{
                        positive = -1;
                        already_digit = true;
                    }
                    break;
                default:
                    System.out.println(arr[idx]);
                    if(arr[idx]==48&&already_digit==false){
                        already_digit = true;
                    }
                    else if(arr[idx]>=48 && arr[idx]<=57){
                        already_digit = true;
                        pop = (int) arr[idx]-48;
                        if (ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) return (positive==1) ? Integer.MAX_VALUE:Integer.MIN_VALUE;
                        ans = ans*10 + pop;
                    }
                    else{
                        return ans*positive;
                    }
                    break;
            }
            System.out.println(ans);
            System.out.println("-----------------");
        }
        return ans*positive;
    }
}

public class Main {
    public static void main(String[] args) {
        String[] inputs = {"42","   -42","4193 with words","words and 987", "-91283472332", "+-12", "00000-42a1234", "  -0012a42", "-5-", "21474836460"};
        int[] answers = {42, -42, 4193, 0, -2147483648, 0, 0, -12, -5, 2147483647};
        int t;
        Solution tt = new Solution();
        for(int i=0; i<inputs.length; i++){
            t = tt.myAtoi(inputs[i]);
            if(t==answers[i]) System.out.printf("Test Case %d Passed!!\n",i);
            else{
                System.out.println("Input:");
                System.out.println(inputs[i]);
                System.out.println("My Answer:");
                System.out.println(t);
                System.out.println("Correct Answer:");
                System.out.println(answers[i]);
            }
            System.out.println("===============");
        }
    }
}
