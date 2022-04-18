package com.Q374_Guess_Number_Higher_or_Lower;

class GuessGame {
    private int target;
    GuessGame(int target){
        this.target = target;
    }

    protected int guess(int num){
        if(num==target){
            return 0;
        }
        else{
            return (num<target) ? 1 : -1;
        }
    }
}

class Solution extends GuessGame {

    public Solution(int target){
        super(target);
    }

    public int guessNumber(int n) {
        int l=1;
        int r=n;
        int mid;
        int ans;
        do{
            mid = l/2 + r/2 + ((l%2==1 && r%2==1) ? 1 : 0);
            ans = guess(mid);
            if(ans==1){
                l = mid+1;
            }
            else if(ans==-1){
                r = mid-1;
            }
        }
        while(ans!=0);
        return mid;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] inputsN = {10, 1 ,2};
        int[] inputsP = {6, 1, 1};

        for(int i=0; i<inputsN.length; i++){
            Solution solution = new Solution(inputsP[i]);
            System.out.println(solution.guessNumber(inputsN[i]));
            System.out.println("====");
        }
    }
}
