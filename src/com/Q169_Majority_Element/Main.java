package com.Q169_Majority_Element;

import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;

//12ms ver
/*
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        int max = 1;
        int ans=0;
        for(int num : nums){
            if(cnt.containsKey(num)){
                int tmp = cnt.get(num)+1;
                cnt.put(num,tmp);
                if(tmp>max){
                    max = tmp;
                    ans = num;
                }
            }
            else{
                cnt.put(num,1);
                ans = (max==1) ? num : ans;
            }
        }
        return ans;
    }
}
*/
//

class Solution {
    public int majorityElement(int[] nums){
        int res = nums[0];
        int cnt = 0;
        for(int num:nums){
            if(cnt==0){
                res = num;
                cnt = 1;
            }
            else{
                if(num==res){
                    cnt++;
                }
                else{
                    cnt--;
                }
            }
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{3,2,3},{2,2,1,1,1,2,2}};
        Solution solution = new Solution();
        for(int[] input:inputs){
            System.out.println(solution.majorityElement(input));
            System.out.println("---------------");
        }
    }
}
