package com.Q463_Island_Perimeter;

class Solution {
    public int islandPerimeter(int[][] grid) {
        int cnt = 0;
        int m = grid.length-1;
        int n = grid[0].length-1;
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(grid[i][j]==1){
                    //System.out.println("--------------------");
                    //System.out.println("i: " + i + " j: " + j);

                        //check up
                    if(i==0){
                        //System.out.println("Top Edge");
                        cnt++;
                    }
                    else if(grid[i-1][j]==0){
                        //System.out.println("Top");
                        cnt++;
                    }

                    //check down
                    if(i==m){
                        //System.out.println("Bottom Edge");
                        cnt++;
                    }
                    else if(grid[i+1][j]==0){
                        //System.out.println("Bottom");
                        cnt++;
                    }

                    //check left
                    if(j==0){
                        //System.out.println("Left Edge");
                        cnt++;
                    }
                    else if(grid[i][j-1]==0){
                        //System.out.println("Left");
                        cnt++;
                    }
                    //check right

                    if(j==n){
                        //System.out.println("Right Edge");
                        cnt++;
                    }
                    else if(grid[i][j+1]==0){
                        //System.out.println("Right");
                        cnt++;
                    }
                    //System.out.println("cnt: " + cnt);
                }
            }
        }
        return cnt;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][][] grids = {{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}},{{1}},{{1,0}}};
         Solution solution = new Solution();
         for(int[][] grid : grids){
             System.out.println(solution.islandPerimeter(grid));
             System.out.println("===============");
         }

    }
}
