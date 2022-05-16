package com.Q506_Relative_Ranks;

import java.util.*;

class Athlete {
    private int score;
    private int index;
    private String title;

    public Athlete(int index, int score) {
        this.index = index;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public int getIndex() {
        return index;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString(){
        return "Index: " + index + " Score: " + score + " Title: " + title;
    }

    public static class ScoreComparator implements Comparator<Athlete> {
        @Override
        public int compare(Athlete athlete1, Athlete athlete2) {
            return (athlete1.getScore()>athlete2.getScore()) ? -1 : 1;
        }
    }

    public static class IndexComparator implements Comparator<Athlete> {
        @Override
        public int compare(Athlete athlete1, Athlete athlete2) {
            return (athlete1.getIndex()<athlete2.getIndex()) ? -1 : 1;
        }
    }
}

class Solution {

    public String[] findRelativeRanks(int[] score) {
        List<Athlete> athletes = new LinkedList<Athlete>();
        for(int i=0; i<score.length; i++){
            athletes.add(new Athlete(i, score[i]));
        }

        Collections.sort(athletes,new Athlete.ScoreComparator());

        for(int i=0; i<athletes.size(); i++){
            switch (i){
                case 0:
                    athletes.get(i).setTitle("Gold Medal");
                    break;
                case 1:
                    athletes.get(i).setTitle("Silver Medal");
                    break;
                case 2:
                    athletes.get(i).setTitle("Bronze Medal");
                    break;
                default:
                    athletes.get(i).setTitle(String.valueOf(i+1));
                    break;
            }
        }

        Collections.sort(athletes, new Athlete.IndexComparator());

        String[] ans = new String[athletes.size()];

        for(int i=0; i<athletes.size(); i++){
            ans[i] = athletes.get(i).getTitle();
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] scoress = {{5,4,3,2,1},{10,3,8,9,4}};
        Solution solution = new Solution();
        for (int[] scores : scoress){
            System.out.println(Arrays.toString(solution.findRelativeRanks(scores)));
        }
    }
}
