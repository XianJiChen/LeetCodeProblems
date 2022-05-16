package com.Q492_Construct_the_Rectangle;

import java.util.Arrays;


//37ms ver
/*
class Solution {
    public int[] constructRectangle(int area) {
        int[] ans = new int[2];
        ans[0] = (int) Math.sqrt(area);
        if(Math.pow(ans[0],2)==area){
            ans[1] = ans[0];
        }
        else{
            int val;
            for(int i=ans[0], j= ans[0]+1; i>=1 && j<=area;){
                val = i*j;
                if(val==area){
                    ans[0] = j;
                    ans[1] = i;
                    break;
                }
                else if(val<area){
                    j++;
                }
                else if(val>area){
                    i--;
                }
            }
        }
        return ans;
    }
}
*/

//0ms ver
class Solution {
    public int[] constructRectangle(int area) {
        int[] ans = new int[2];
        for(int root = (int)Math.sqrt(area); root>0; root--){
            if(area%root==0){
                ans[0] = root;
                ans[1] = area/root;
                break;
            }
        }
        if(ans[0]<ans[1]){
            int tmp = ans[0];
            ans[0] = ans[1];
            ans[1] = tmp;
        }
        return ans;
    }
}


public class Main {
    public static void main(String[] args) {
        int[] inputs = {4,37,122122};
        Solution solution = new Solution();
        for(int input : inputs){
            System.out.println(Arrays.toString(solution.constructRectangle(input)));
            System.out.println("======");
        }
    }
}
