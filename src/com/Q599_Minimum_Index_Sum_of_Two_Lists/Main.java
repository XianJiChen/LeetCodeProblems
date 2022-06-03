package com.Q599_Minimum_Index_Sum_of_Two_Lists;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        String commonRestaurantWithLeastIndexSum;
        int minIndexSum = Integer.MAX_VALUE;
        int tmp;
        HashSet<String> set1 = new HashSet<String>(List.of(list1));
        HashSet<String> set2 = new HashSet<String>(List.of(list2));
        set1.retainAll(set2);
        for(String str : set1){

        }
        return new String[2];
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
