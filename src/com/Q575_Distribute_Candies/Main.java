package com.Q575_Distribute_Candies;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

//65ms ver
/*
class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> distinctTypes = Arrays.stream(candyType).boxed().collect(Collectors.toSet());
        return Math.min(distinctTypes.size(), candyType.length/2);
    }
}
*/

//49ms ver
/*
class Solution {
    public int distributeCandies(int[] candyType) {
        return Math.min((int) Arrays.stream(candyType).distinct().count(), candyType.length/2);
    }
}
*/

//27ms ver
class Solution {
    public int distributeCandies(int[] candyType) {
        boolean[] typeAppeared = new boolean[200001];
        int typeCnt = 0;
        int idx;
        for(int type : candyType){
            idx = type + 100000;
            typeCnt = (typeAppeared[idx]) ? typeCnt : typeCnt+1;
            typeAppeared[idx] = true;
        }
        return (typeCnt<candyType.length/2) ? typeCnt : candyType.length/2;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{1,1,2,2,3,3},{1,1,2,3},{6,6,6,6}};

        Solution solution = new Solution();
        for(int[] input : inputs){
            System.out.println(solution.distributeCandies(input));
            System.out.println("=============");
        }
    }
}
