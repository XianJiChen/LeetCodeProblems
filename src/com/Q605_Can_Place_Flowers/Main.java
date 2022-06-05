package com.Q605_Can_Place_Flowers;

//1ms ver
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int prevOne = -2;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                System.out.println((i - prevOne - 2));
                n -= (i - prevOne - 2) / 2;
                prevOne = i;
            }
        }
        if (flowerbed[flowerbed.length - 1] != 1) {
            n -= (flowerbed.length + 1 - prevOne - 2) / 2;
            System.out.println((flowerbed.length + 1 - prevOne - 2));
        }
        System.out.println(n);
        return n <= 0;
    }
}
//another 1ms ver
/*
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i = 0; i < flowerbed.length && count < n; i++) {
            if(flowerbed[i] == 0) {
	     //get next and prev flower bed slot values. If i lies at the ends the next and prev are considered as 0.
               int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
               int prev = (i == 0) ? 0 : flowerbed[i - 1];
               if(next == 0 && prev == 0) {
                   flowerbed[i] = 1;
                   count++;
               }
            }
        }

        return count == n;
    }
}
 */
public class Main {
    public static void main(String[] args) {
        int[][] flowerBeds = {{1, 0, 0, 0, 1}, {1, 0, 0, 0, 1}, {1, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 1}, {1, 0, 0, 0, 1, 0, 0}};
        int[] ns = {1, 2, 2, 1, 2};
        Solution solution = new Solution();
        for (int i = 0; i < ns.length; i++) {
            System.out.println(solution.canPlaceFlowers(flowerBeds[i], ns[i]));
            System.out.println("============");
        }
    }
}
