package com.Q455_Assign_Cookies;

import java.util.Arrays;
import java.util.HashSet;

//13ms ver
/*
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int contentChildren = 0;
        g = Arrays.stream(g).sorted().toArray();
        s = Arrays.stream(s).sorted().toArray();
        System.out.println(Arrays.toString(g));
        System.out.println(Arrays.toString(s));
        for(int i=0, j=0; i<g.length && j<s.length;)
        {
            if(g[i]<=s[j]){
                i++;
                j++;
                contentChildren++;
            }
            else{
                j++;
            }
        }
        return contentChildren;
    }
}
*/

//18ms ver
/*
class Solution {
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void sort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    public int findContentChildren(int[] g, int[] s) {
        if(s.length==0){
            return 0;
        }
        sort(g, 0, g.length-1);
        sort(s, 0, s.length-1);
        System.out.println(Arrays.toString(g));
        System.out.println(Arrays.toString(s));
        return 0;
    }
}
*/



//8ms ver
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int contentChildren = 0;
        g = Arrays.stream(g).sorted().toArray();
        s = Arrays.stream(s).sorted().toArray();
        System.out.println(Arrays.toString(g));
        System.out.println(Arrays.toString(s));
        for(int i=0, j=0; i<g.length && j<s.length;)
        {
            if(g[i]<=s[j]){
                i++;
                j++;
                contentChildren++;
            }
            else{
                j++;
            }
        }
        return contentChildren;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] gs = {{1,2,3},{1,2},{10,9,8,7}};
        int[][] ss = {{1,1},{1,2,3},{5,6,7,8}};
        Solution solution = new Solution();
        for(int i=0; i<gs.length; i++){
            System.out.println(solution.findContentChildren(gs[i],ss[i]));
            System.out.println("=============");
        }
    }
}
