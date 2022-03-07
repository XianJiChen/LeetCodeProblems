package com.Q118_Pascals_Triangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


//another approach
//also 0ms ver
//Using LinkedList is more efficient than an ArrayList in this case as don't really need O(1) retrieval of an ArrayList. ArrayList internal resizing is avoided.
/*
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> prev = Collections.singletonList(1);
        result.add(prev);
        for(int i = 2; i <= numRows; i++) {
            List<Integer> curr = new LinkedList<>();
            curr.add(1);
            for(int j = 1; j < prev.size(); j++) {
                curr.add(prev.get(j - 1) + prev.get(j));
            }
            curr.add(1);
            prev = curr;
            result.add(prev);
        }

        return result;
    }
}
 */

//0ms ver
class Solution {
    public List<List<Integer>> generate(int numRows) {
        int[][] tmp = new int[numRows][numRows];
        int num;
        int val;
        int numOfNumbersInTheRow;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentRow;
        for(int rowNumber=0; rowNumber<numRows; rowNumber++){
            numOfNumbersInTheRow = rowNumber+1;
            num = (int) Math.ceil((double) (rowNumber+1)/2);
            for(int idx=0; idx<num; idx++){
                if(rowNumber==0){
                    val = 1;
                }
                else{
                    val = (idx==0) ? 1 : (tmp[rowNumber-1][idx-1] + tmp[rowNumber-1][idx]);
                }
                tmp[rowNumber][idx] = val;
                tmp[rowNumber][(numOfNumbersInTheRow-1)-idx] = val;
            }
            currentRow = new ArrayList<>();
            for(int idx=0; idx<numOfNumbersInTheRow; idx++){
                currentRow.add(tmp[rowNumber][idx]);
            }
            result.add(currentRow);
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution tt = new Solution();
        System.out.println(tt.generate(30).get(29).toString());
    }
}
