package com.Q599_Minimum_Index_Sum_of_Two_Lists;

import java.util.*;

//8ms ver
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int min = Integer.MAX_VALUE;
        int indexSum;
        List<String> ans = new LinkedList<>();
        HashMap<String, Integer> list1Idx = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            list1Idx.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            indexSum = i + list1Idx.getOrDefault(list2[i], Integer.MAX_VALUE-i);
            if (indexSum == min) {
                min = indexSum;
                ans.add(list2[i]);
            }
            else if(indexSum < min){
                ans.clear();
                ans.add(list2[i]);
                min = Math.min(min, indexSum);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}

public class Main {
    public static void main(String[] args) {
        String[][] list1s = {{"Shogun", "Tapioca Express", "Burger King", "KFC"}, {"Shogun", "Tapioca Express", "Burger King", "KFC"}};
        String[][] list2s = {{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"}, {"KFC", "Shogun", "Burger King"}};
        Solution solution = new Solution();
        for (int i = 0; i < list1s.length; i++) {
            System.out.println(solution.findRestaurant(list1s[i], list2s[i])[0]);
            System.out.println("======");
        }
    }
}
