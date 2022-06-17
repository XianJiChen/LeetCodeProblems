package com.Q38_Count_and_Say;

class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            String prevString = countAndSay(n - 1);
            StringBuilder sb = new StringBuilder();
            int prev;
            for (int i = 0; i < prevString.length(); i++) {
                prev = i;
                while (i < prevString.length() - 1 && prevString.charAt(i) == prevString.charAt(i + 1)) {
                    i++;
                }
                sb.append(i - prev + 1);
                sb.append(prevString.charAt(i));
            }
            return sb.toString();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] inputs = {1, 4, 5};
        Solution solution = new Solution();
        for (int input : inputs) {
            System.out.println(solution.countAndSay(input));
            System.out.println("============");
        }
    }
}
