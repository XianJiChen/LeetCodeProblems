package com.Q121_Best_Time_to_Buy_and_Sell_Stock;

import java.util.*;


//8ms 5%...
/*
class Solution {
    private boolean isNeverRising(int[] prices, int len){
        for(int i=1; i<len; i++){
            if(prices[i]>prices[i-1]){
                return false;
            }
        }
        return true;
    }

    public int maxProfit(int[] prices) {
        int plen = prices.length;
        if(plen<=1 || isNeverRising(prices,plen)){
            return 0;
        }
        List<Integer> lowValues = new ArrayList<>();
        List<Integer> lowValuesIndexes = new ArrayList<>();
        List<Integer> highValues = new ArrayList<>();
        List<Integer> highValuesIndexes = new ArrayList<>();

//        Map<Integer, Integer> lows = new HashMap<>();
//        Map<Integer, Integer> highs = new HashMap<>();

//        lowValues.add(prices[0]);
//        lowValuesIndexes.add(0);
        int max = 0;//prices[plen-1];
        int min = Integer.MAX_VALUE;//prices[0];
        for(int i=0; i<plen-1; i++){
            if(prices[i]>=prices[i+1]) {
                continue;
            }
            else{
                if(prices[i]<min){
                    //lows.put(i,prices[i]);
                    lowValuesIndexes.add(i);
                    lowValues.add(prices[i]);
                    min = prices[i];
                }
            }
//            lows.add(i);
        }



//        highValues.add(prices[plen-1]);
//        highValuesIndexes.add(plen-1);
        for(int i=plen-1; i>0; i--){
            if(prices[i-1]>=prices[i]){
              continue;
            }
            else{
                if(prices[i]>max){
                    highValuesIndexes.add(i);
                    highValues.add(prices[i]);
                    max = prices[i];
                }
            }
//            highs.add(i-1);
        }

        int maxProf = 0;

        int highLen = highValues.size();
        int lowLen = lowValues.size();

        int buyPrice;
        int sellPrice;
        int buyDate;
        int sellDate;
//        System.out.println(highValues.toString());
//        System.out.println(lowValues.toString());
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        for(int i=0; i<lowLen; i++){
            for(int j=0; j<highLen; j++){
                buyPrice = lowValues.get(i);
                sellPrice = highValues.get(j);
                buyDate = lowValuesIndexes.get(i);
                sellDate = highValuesIndexes.get(j);
//                System.out.println(buyPrice);
//                System.out.println(sellPrice);
//                System.out.println("------------------");
                if(sellDate<buyDate){
                    break;
                }
                else{
                    maxProf = Math.max(sellPrice-buyPrice, maxProf);
                }
            }
        }
        return maxProf;
    }
}
*/
//1ms ver
/*
class Solution {
    public int maxProfit(int[] prices) {
        int maximumProfit=0;
        int currentPrice=prices[0];
        int pLen = prices.length;
        int currentProfit;
        for(int i=1; i<pLen; i++){
            currentProfit =  prices[i] - currentPrice;
            maximumProfit = Math.max(currentProfit,maximumProfit);
            currentPrice = (currentProfit<0) ? prices[i] : currentPrice;
        }
        return maximumProfit;
    }
}
*/

//5ms ver
class Solution {
    public int maxProfit(int[] prices) {
        int maxProf = 0;
        int currentPrice = prices[0];
        int pLen = prices.length;
        for(int i=0, j=0; i<pLen && j<pLen;){
            while(i<pLen-1 && prices[i]>=prices[i+1]){
                i++;
            }
            currentPrice = (currentPrice<prices[i]) ? currentPrice : prices[i];
            j = i;
            while(j<pLen-1 && prices[j]<=prices[j+1]){
                j++;
            }
            maxProf = (maxProf > prices[j]-currentPrice) ? maxProf : prices[j] - currentPrice;
            i = j+1;
            j = i+1;
        }
        return maxProf;
    }
}
public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{7,1,5,3,6,4},{7,6,4,3,1},{0,9,3,5,3,1,5,1,0,7}};
        Solution solution = new Solution();
        for(int[] input : inputs){
            System.out.println(solution.maxProfit(input));
            System.out.println("=====================");
        }
    }
}
