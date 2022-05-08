package com.Q434_Number_of_Segments_in_a_String;

class Solution {
    public int countSegments(String s) {
        if(s.isEmpty()){
            return 0;
        }
        else{
            int cnt = 0;
            for(String str : s.split(" ", -1)){
                if(!str.isEmpty()){
                    cnt++;
                }
            }
            return cnt;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        String[] inputs = {"Hello, my name is John", ", , , ,        a, eaefa"};
        Solution solution = new Solution();
        for(String str : inputs){
            System.out.println(solution.countSegments(str));
        }
    }
}
