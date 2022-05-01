package com.Q401_Binary_Watch_UNDONE;

import java.util.*;


//16ms ver
/*
class Solution {
    final int[] hours = {1,2,4,8};
    final int[] minutes = {1,2,4,8,16,32};

    public List<String> readBinaryWatch(int turnedOn) {
        Set<String> ans = new LinkedHashSet<>();
        if(turnedOn<=8){
            List<String> possibleHours = new ArrayList<>();
            List<String> possibleMinutes = new ArrayList<>();

            for(int i=0; i<=Math.min(3,turnedOn); i++){
                possibleHours.clear();
                possibleMinutes.clear();

                possibleHours.addAll(getHour(i,0,0));

                if(turnedOn-i<=5){
                    possibleMinutes.addAll(getMinute(turnedOn-i,0,0));
                }

                for(String hour : possibleHours){
                    for(String minute : possibleMinutes){
                        ans.add(hour + ":" + minute);
                        //System.out.println(hour + ":" + minute);
                    }
                }
            }
        }
        return ans.stream().toList();
    }

    private List<String> getHour(final int num2Take, int idx, int sum){
        List<String> possibleHours = new LinkedList<>();

        if(num2Take==0 && sum<12){
            possibleHours.add(String.valueOf(sum));
        }
        else if(num2Take>0 && idx<hours.length && sum+hours[idx]<12) {
            //does not take hours[idx]
            possibleHours.addAll(getHour(num2Take, idx+1, sum));
            //takes hours[idx]
            possibleHours.addAll(getHour(num2Take-1, idx+1, sum+hours[idx]));
        }

        return possibleHours;
    }

    private List<String> getMinute(final int num2Take, int idx, int sum){
        List<String> possibleMinutes = new LinkedList<>();

        if(num2Take==0 && sum<60){
            if(sum<10){
                possibleMinutes.add("0" + String.valueOf(sum));
            }
            else{
                possibleMinutes.add(String.valueOf(sum));
            }
        }
        else if(num2Take>0 && idx< minutes.length && sum+minutes[idx]<60) {
            //does not take minutes[idx]
            possibleMinutes.addAll(getMinute(num2Take, idx+1, sum));
            //takes minutes[idx]
            possibleMinutes.addAll(getMinute(num2Take-1, idx+1, sum+minutes[idx]));
        }

        return possibleMinutes;
    }

}
*/

//1ms ver
class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> allPossibleTimes = new ArrayList();

        for(int hour=0;hour<12;hour++){
            for(int minute=0;minute<60;minute++){
                if(Integer.bitCount(hour)+Integer.bitCount(minute) == turnedOn){
                    StringBuilder time = new StringBuilder();
                    time.append(hour).append(":");
                    if(minute<10){
                        time.append("0");
                    }
                    time.append(minute);
                    allPossibleTimes.add(time.toString());
                }
            }
        }
        return allPossibleTimes;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] inputs = {1,0};
        Solution solution = new Solution();

        for(int input : inputs){
            System.out.println(solution.readBinaryWatch(input));
            System.out.println("===============");
        }
    }
}
