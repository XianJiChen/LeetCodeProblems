package com.Q13_Roman_to_Integer;

import java.util.HashMap;
import java.util.Map;

//3ms 99% ver
class Solution {
    public int romanToInt(String s) {
        int[] div = {1000, 500, 100, 50, 10, 5, 1};
        char[] roman = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};

        char[] arr = s.toCharArray();
        int ttl=0;
        int id1=0, id2=0;
        for(int i=0; i<arr.length;){
            id2 = roman.length-1;
            for(int j=0; j<roman.length; j++){
                if(arr[i]==roman[j]) id1 = j;
                if(i+1<arr.length && arr[i+1]==roman[j]) id2 = j;
            }
            if(id2<id1){
                ttl += (div[id2]-div[id1]);
                i+=2;
            }
            else{
                ttl += div[id1];
                i++;
            }
        }
        return ttl;
    }
}

//11ms 34.3% ver
/*
class Solution {
    public int romanToInt(String s) {
        int[] div = {1000, 500, 100, 50, 10, 5, 1};
        char[] roman = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        Map<Character, Integer> dict = new HashMap<Character, Integer>();
        for(int i=0; i<roman.length; i++) dict.put(roman[i],div[i]);
        div = null;
        roman = null;
        char[] arr = s.toCharArray();
        //int len = arr.length;
        int ttl=0;
        for(int i=0; i<arr.length;){
            if(i<arr.length-1 && dict.get(arr[i+1]) > dict.get(arr[i])){
                ttl += (dict.get(arr[i+1])-dict.get(arr[i]));
                i+=2;
            }
            else{
                ttl += dict.get(arr[i]);
                i++;
            }
        }
        return ttl;
    }
}
*/

public class Main {
    public static void main(String[] args) {
        String[] inputs  = {"III", "LVIII", "MCMXCIV"};
        Solution tt = new Solution();
        for(String input:inputs){
            System.out.println(tt.romanToInt(input));
            System.out.println("============");
        }
    }
}
