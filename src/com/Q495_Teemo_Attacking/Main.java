package com.Q495_Teemo_Attacking;

//2ms ver
/*
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int poisonedDuration = 0;
        for(int i=0; i<timeSeries.length-1; i++){
            poisonedDuration += Math.min(duration, timeSeries[i+1]-timeSeries[i]);
        }
        poisonedDuration += duration;
        return poisonedDuration;
    }
}
*/

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int poisonedDuration = duration*timeSeries.length;
        int tmp;
        for(int i=1; i<timeSeries.length; i++){
            tmp = timeSeries[i]-timeSeries[i-1];
            if(tmp<duration){
                poisonedDuration -= (duration-tmp);
            }
        }
        return poisonedDuration;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] timeSeries = {{1,4},{1,2}};
        int[] durations = {2,2};
        Solution solution = new Solution();
        for(int i=0; i<timeSeries.length; i++){
            System.out.println(solution.findPoisonedDuration(timeSeries[i],durations[i]));
            System.out.println("===========");
        }
    }
}
