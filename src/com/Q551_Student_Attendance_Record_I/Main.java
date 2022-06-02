package com.Q551_Student_Attendance_Record_I;

class Solution {
    public boolean checkRecord(String s) {
        int absentCnt = 0;
        for(int i=0; i<s.length(); i++){
            switch (s.charAt(i)){
                case 'A':
                    absentCnt++;
                    if (absentCnt>2){
                        return false;
                    }
                    break;
                case'L':
                    if(i<s.length()-2){
                        if(s.charAt(i+1)=='L' && s.charAt(i+2)=='L'){
                            return false;
                        }
                    }
                    break;
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        String[] records = {"PPALLP", "PPALLL"};
        Solution solution = new Solution();
        for(String record : records){
            System.out.println(solution.checkRecord(record));
            System.out.println("================");
        }
    }
}
