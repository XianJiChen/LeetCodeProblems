package com.Q278_First_Bad_Version;

//12 ms ver
/*
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        int mid;
        while(l<=r){
            mid = l/2 + r/2;
            mid += (l%2==1 && r%2==1) ? 1 : 0;
            if(isBadVersion(mid)){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }
}
*/

public class Main {
    public static void main(String[] args) {

    }
}
