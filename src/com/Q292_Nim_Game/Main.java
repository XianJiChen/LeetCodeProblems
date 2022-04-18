package com.Q292_Nim_Game;

class Solution {
    public boolean canWinNim(int n) {
        System.out.println("Nim:" + n);
        if(n<=3){
            return true;
        }
        else{
            if(n>=7){
                return canWinFriend(n-3);
            }
            else{
                return ((!canWinFriend(n-1)) && (!canWinFriend(n-2)) && (!canWinFriend(n-3)));
            }
        }
//        switch (n){
//            case 4->{
//                return false;
//            }
//            case 5->{
//                return canWinFriend(4);
//            }
//            case 6->{
//                return ((!canWinFriend(4)) && (!canWinFriend(5)));
//            }
//            default -> {
//                return (canWinFriend(n-3));
//            }
//        }
    }

    private boolean canWinFriend(int n){
        System.out.println("Friend:" + n);
        if(n<=3){
            return true;
        }
        else{
            if(n>=7){
                return canWinNim(n-3);
            }
            else{
                return ((!canWinNim(n-1)) && (!canWinNim(n-2)) && (!canWinNim(n-3)));
            }
        }
//        switch (n){
//            case 4->{
//                return false;
//            }
//            case 5->{
//                return canWinNim(4);
//            }
//            case 6->{
//                return canWinNim(4)||canWinNim(5);
//            }
//            default -> {
//                return (canWinNim(n-3));
//            }
//        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] inputs = {4,1,2,8,10};
        //ans: false, true, true, false, true
        Solution solution = new Solution();
        for(int input : inputs) {
            System.out.println(solution.canWinNim(input));
            System.out.println("====");
        }
    }
}
