package com.Q566_Reshape_the_Matrix;

import java.util.Arrays;

//0ms ver
/*
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat.length * mat[0].length != r*c){
            return mat;
        }
        else{
            int[][] reshapedMat = new int[r][c];
            int i=0;
            int j=0;
            for(int m=0; m<mat.length; m++){
                for(int n=0; n<mat[m].length; n++){
                    reshapedMat[i][j++] = mat[m][n];
                    if(j==c){
                        j=0;
                        i++;
                    }
                }
            }
            return reshapedMat;
        }
    }
}
*/

//0ms ver
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat.length * mat[0].length != r*c){
            return mat;
        }
        else{
            int[] oneRow = new int[r*c];
            int originalRowLength = mat[0].length;
            for(int i=0, j=0; i<mat.length; i++){
                System.arraycopy(mat[i],0,oneRow, i*originalRowLength, originalRowLength);
            }
            int[][] reshapedMat = new int[r][c];
            for(int i=0; i<r; i++){
                System.arraycopy(oneRow, i*c, reshapedMat[i], 0, c);
            }
            return reshapedMat;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[][][] inputs = {{{1,2},{3,4}}, {{1,2},{3,4}}};
        int[] rs = {1,2};
        int[] cs = {4,4};
        Solution solution = new Solution();
        for(int i=0; i<inputs.length; i++){
            System.out.print("[");
            for(int[] mat : solution.matrixReshape(inputs[i], rs[i], cs[i])){
                System.out.print(Arrays.toString(mat));
            }
            System.out.println("]");
            System.out.println("============");
        }
    }
}
