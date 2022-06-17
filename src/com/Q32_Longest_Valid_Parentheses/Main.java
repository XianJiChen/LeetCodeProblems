package com.Q32_Longest_Valid_Parentheses;


class Solution {
    public int longestValidParentheses(String s) {
        int leftCnt = 0;
        int rightCnt = 0;
        int currentRightCnt = 0;
        int prevCnt = 0;
        int maxCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    leftCnt++;
                    currentRightCnt = 0;
                    break;
                case ')':
                    if (leftCnt > rightCnt) {
                        rightCnt++;
                        currentRightCnt++;
                        if (leftCnt == rightCnt) {
                            prevCnt += leftCnt * 2;
                            leftCnt = 0;
                            rightCnt = 0;
                            currentRightCnt = 0;
                            maxCnt = Math.max(maxCnt, prevCnt);
                        } else {
                            maxCnt = Math.max(maxCnt, 2 * currentRightCnt);
                        }
                    } else {
                        leftCnt = 0;
                        rightCnt = 0;
                        currentRightCnt = 0;
                        prevCnt = 0;
                    }
                    break;
            }
        }
        return maxCnt;
    }
}


/*
class Solution {
    public int longestValidParentheses(String s) {
        Queue<Character> parentheses = new LinkedList<>();
        int maxCnt = 0;
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            switch (s.charAt(i)){
                case '(':
                    parentheses.add('(');
                    break;
                case ')':
                    if(parentheses.size()!=0 && parentheses.peek()=='('){
                        parentheses.poll();
                        cnt+=2;
                    }
                    else{
                        parentheses.clear();
                        cnt = 0;
                    }
                    break;
            }
        }
        return maxCnt;
    }
}
*/

public class Main {
    public static void main(String[] args) {
        String[] inputs = {"(()", ")()())", "", "()(()", "(()(()", "(()()"};
        Solution solution = new Solution();
        for (String input : inputs) {
            System.out.println(solution.longestValidParentheses(input));
            System.out.println("===============");
        }
    }
}
