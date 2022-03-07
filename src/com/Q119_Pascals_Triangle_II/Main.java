package com.Q119_Pascals_Triangle_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//2ms ver
/*
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        List<Integer> prev = ans;
        for(int row=0; row<rowIndex; row++){
            ans = new ArrayList<>();
            ans.add(1);
            for(int i=1;i<prev.size();i++){
                ans.add(prev.get(i-1)+prev.get(i));
            }
            ans.add(1);
            prev = ans;
        }
        return ans;
    }
}
*/

//2ms ver
/*
class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] ans = new int[rowIndex+1];
        ans[0] = 1;
        for(int row=1; row<=rowIndex; row++){
            ans[row]=1;
            for(int i=row-1; i>0; i--){
                ans[i] = ans[i-1] + ans[i];
            }
        }
        return Arrays.stream(ans).boxed().collect(Collectors.toList());
    }
}
*/
//0m
class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] ans = new int[rowIndex+1];
        ans[0] = 1;
        for(int row=1; row<=rowIndex; row++){
            ans[row]=1;
            for(int i=row-1; i>0; i--){
                ans[i] = ans[i-1] + ans[i];
            }
        }
        List<Integer> arr = new ArrayList();
        for(int i=0; i<=rowIndex; i++){
            arr.add(ans[i]);
        }
        return arr;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution tt = new Solution();
        System.out.println(tt.getRow(5).toString());
    }
}
