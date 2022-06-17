package com.Q657_Robot_Return_to_Origin;

class Solution {
    public boolean judgeCircle(String moves) {
        int vertical = 0;
        int horizontal = 0;
        for (char move : moves.toCharArray()) {
            switch (move) {
                case 'U':
                    vertical++;
                    break;
                case 'D':
                    vertical--;
                    break;
                case 'L':
                    horizontal--;
                    break;
                case 'R':
                    horizontal++;
                    break;
            }
        }
        return horizontal == 0 && vertical == 0;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
