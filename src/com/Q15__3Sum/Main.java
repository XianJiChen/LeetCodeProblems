package com.Q15__3Sum;

import java.util.*;


class Solution {
    public List < List < Integer >> threeSum(int[] nums) {
        List < List < Integer >> result = new ArrayList <> ();
        // Sort the given array
        if(nums.length<3) return result;
        Arrays.sort(nums);
        int len = nums.length;
        if((nums[0]<0 && nums[len-1]<0)||(nums[0]>0 && nums[len-1]>0)) return result;
        Map<Integer, Integer> arr= new HashMap<Integer, Integer>();
        for(int num:nums)

        for (int num1Idx = 0; num1Idx + 2 < len; num1Idx++) {

            if(nums[num1Idx]>0) break;

            int num2Idx = num1Idx + 1;
            int num3Idx = len - 1;
            while (num2Idx < num3Idx) {
                int sum = nums[num2Idx] + nums[num3Idx] + nums[num1Idx];
                if (sum == 0) {
                    // Add triplet to result
                    result.add(Arrays.asList(nums[num1Idx], nums[num2Idx], nums[num3Idx]));

                    num3Idx--;

                    // Skip all duplicates from right
                    while (num2Idx < num3Idx && nums[num3Idx] == nums[num3Idx + 1]) num3Idx--;
                } else if (sum > 0) {
                    // Decrement num3Idx to reduce sum value
                    num3Idx--;
                } else {
                    // Increment num2Idx to increase sum value
                    num2Idx++;
                }
            }
            while(num1Idx+1<len && nums[num1Idx] == nums[num1Idx+1]) num1Idx++;
        }
        return result;
    }
}

//16ms 98% ver
/*
class Solution {
    public List < List < Integer >> threeSum(int[] nums) {
        List < List < Integer >> result = new ArrayList <> ();
        // Sort the given array
        if(nums.length<3) return result;
        Arrays.sort(nums);
        if((nums[0]<0 && nums[nums.length-1]<0)||(nums[0]>0 && nums[nums.length-1]>0)) return result;

        for (int num1Idx = 0; num1Idx + 2 < nums.length; num1Idx++) {
            // Skip all duplicates from left
            // num1Idx>0 ensures this check is made only from 2nd element onwards
            if (num1Idx > 0 && nums[num1Idx] == nums[num1Idx - 1]) {
                continue;
            }
            if(nums[num1Idx]>0) break;

            int num2Idx = num1Idx + 1;
            int num3Idx = nums.length - 1;
            while (num2Idx < num3Idx) {
                int sum = nums[num2Idx] + nums[num3Idx] + nums[num1Idx];
                if (sum == 0) {
                    // Add triplet to result
                    result.add(Arrays.asList(nums[num1Idx], nums[num2Idx], nums[num3Idx]));

                    num3Idx--;

                    // Skip all duplicates from right
                    while (num2Idx < num3Idx && nums[num3Idx] == nums[num3Idx + 1]) num3Idx--;
                } else if (sum > 0) {
                    // Decrement num3Idx to reduce sum value
                    num3Idx--;
                } else {
                    // Increment num2Idx to increase sum value
                    num2Idx++;
                }
            }
        }
        return result;
    }
}
*/
//class Solution {
//    static int partition(int arr[], int low, int high)
//    {
//        int pivot = arr[high];
////        System.out.println("In partition");
////        System.out.printf("low: %d high: %d\n",low, high);
////        System.out.println("-----------------");
//        // index of smaller element
//        int i = (low - 1);
////        System.out.println("i: ");
////        System.out.println(i);
//        int temp = 0;
//        for (int j = low; j <= high - 1; j++) {
//            // If current element is smaller than or
//            // equal to pivot
//            if (arr[j] <= pivot) {
//                i++;
////                System.out.println("<<<<<<<<<<<<<");
////                System.out.println(arr[i]);
////                System.out.println(">>>>>>>>>>>>>");
//                // swap arr[i] and arr[j]
//                if(i!=j){
//                    temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
//
//        // swap arr[i+1] and arr[high] (or pivot)
//        temp = arr[i + 1];
//        arr[i + 1] = arr[high];
//        arr[high] = temp;
//
//        return i + 1;
//    }
//
//    /* A[] --> Array to be sorted,
//   l  --> Starting index,
//   h  --> Ending index */
//    static void quickSortIterative(int arr[], int l, int h)
//    {
//        System.out.printf("l: %d, h: %d\n",l,h);
//        // Create an auxiliary stack
//        int[] stack = new int[h - l + 1];
//
//        // initialize top of stack
//        int top = -1;
//
//        // push initial values of l and h to stack
//        stack[++top] = l;
//        stack[++top] = h;
//
//        // Keep popping from stack while is not empty
//        while (top >= 0) {
//            // Pop h and l
//            h = stack[top--];
//            l = stack[top--];
//
//            // Set pivot element at its correct position
//            // in sorted array
//            int p = partition(arr, l, h);
//
//            // If there are elements on left side of pivot,
//            // then push left side to stack
//            if (p - 1 > l) {
//                stack[++top] = l;
//                stack[++top] = p - 1;
//            }
//
//            // If there are elements on right side of pivot,
//            // then push right side to stack
//            if (p + 1 < h) {
//                stack[++top] = p + 1;
//                stack[++top] = h;
//            }
//        }
//    }
//    public List<List<Integer>> threeSum(int[] nums) {
//        int len = nums.length;
//        List<List<Integer>> ans = new ArrayList<List<Integer>>();
//
//        if(len>2){
////            int min = nums[0];
////            int max = nums[0];
//            int l,r;
//            int t;
//            quickSortIterative(nums, 0, len-1);
//            Map<Integer,Integer> cnt = new HashMap<Integer,Integer>();
//            //Map<Integer,List<Integer>> arr = new HashMap<Integer, List<Integer>>();
//            for(int i=0; i<len; i++){
//                t=1;
//                while(i+t<len && nums[i+t-1]==nums[i+t]){
//                    t++;
//                }
//                cnt.put(nums[i], t);
//                i = i+t-1;
//            }
//            //Integer[] newarr = cnt.keySet().toArray(new Integer[cnt.keySet().size()]);
//            int[] newarr = new int[cnt.keySet().size()];
//            int q=0;
//            for(Integer n:cnt.keySet()){
//                newarr[q] = n;
//                q++;
//            }
//            if(newarr.length>=2) quickSortIterative(newarr, 0, newarr.length-1);
////            System.out.println(">>>>>>>>>>>");
////            for(int it:newarr){
////                System.out.println(it);
////                System.out.println(cnt.get(it));
////                System.out.println("---------");
////            }
////            System.out.println("<<<<<<<<<<<");
//            l = 0;
//            int nlen = newarr.length;
//            int to_find;
//            int layer=0;
//            for(int i=0; i<nlen; i++){
//                for(int j=i; j<nlen; j++){
//                    //System.out.printf("newarr[i]: %d, newarr[j]: %d\n", newarr[i], newarr[j]);
//                    if(i==j && cnt.get(newarr[i])<2) continue;
//                    to_find = 0-newarr[i]-newarr[j];
////                    System.out.println(to_find);
//                    if(to_find<newarr[j]){
////                        System.out.println("Case1");
//                        continue;
//                    }
//                    if(cnt.get(to_find)==null){
////                        System.out.println("Case2");
//                        continue;
//                    }
//                    else{
//                        if(i==j && newarr[j]==to_find && cnt.get(to_find)<3){
////                            System.out.println("Case3");
//                            continue;
//                        }
//                        else if((newarr[i]==to_find && cnt.get(to_find)<2) || (newarr[j]==to_find && cnt.get(to_find)<2)){
////                            System.out.println("Case4");
//                            continue;
//                        }
//                        else {
////                            System.out.println("Bingo!!");
////                            System.out.printf("newarr[i]: %d, newarr[j]: %d, to_find: %d\n", newarr[i], newarr[j], to_find);
//                            ans.add(new ArrayList<>());
//                            ans.get(layer).add(newarr[i]);
//                            ans.get(layer).add(newarr[j]);
//                            ans.get(layer).add(to_find);
//                            layer++;
////                            System.out.println(ans);
//                        }
//                    }
////                    System.out.println("--------------");
//                }
//            }
//            /*
//            for(int i=1; i<len; i++){
//                max = (max>nums[i]) ? max : nums[i];
//                min = (min<nums[i]) ? min : nums[i];
//            }
//            boolean[] exist = new boolean[max-min+1];
//            int[][] arr = new int[max-min+1][len-1];
//            int[] idx = new int[max-min+1];
//            for(int i=0; i<len; i++) exist[nums[i]-min] = true;
//            for(int i=0; i<len-1; i++){
//                for(int j=i+1; j<len; j++){
//                    if(exist[-1*(nums[i]+nums[j])-min]){
//
//                    }
//                }
//            */
//        }
//        return ans;
//    }
//
//}

public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{-1,0,1,2,-1,-4}, {}, {0}, {0,0,0}};
        Solution tt = new Solution();
        for(int[] input : inputs){
            System.out.println(tt.threeSum(input));
            System.out.println("==================");
        }
    }
}
