package com.Q28_Implement_strStr;
//5ms 97% ver
class Solution {
    public int strStr(String haystack, String needle) {
        char[] hay = haystack.toCharArray();
        char[] nee = needle.toCharArray();
        int hlen = hay.length;
        int nlen = nee.length;

        if (nlen==0) {
            return 0;
        }
        if (hlen==0) {
            return -1;
        }

        if (nlen>hlen) {
            return -1;
        }

        int res = -1;
        int[] lps = getLps(nee);
        int i = 0;
        int j = 0;

        while (i < hlen) {
            if (hay[i] == nee[j]) {
                i++;
                j++;
            }
            if (j == nlen) {
                return i - j;
            } else if (i < hlen && hay[i] != nee[j]) {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
        }
        return res;

    }

    public int[] getLps(char[] s) {
        int[] lps = new int[s.length];
        int len = 0;
        lps[0] = 0;
        int i = 1;
        while (i < lps.length) {
            if (s[i] == s[len]) {
                lps[i] = ++len;
                i++;
            } else {
                if (len == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    len = lps[len - 1];
                }
            }
        }
        return lps;
    }
}

//633ms
/*
class Solution {
    public int strStr(String haystack, String needle) {
        char[] hay = haystack.toCharArray();
        char[] nee = needle.toCharArray();
        int hlen = hay.length, nlen = nee.length;
        int j;
        if(hlen==0||nlen==0) return 0;
        for(int i=0; i<=hlen-nlen; i++){
            if(hay[i]!=nee[0]) continue;
            else{
                for(j=1; j<nlen; j++){
                    if(hay[i+j]!=nee[j]){
                        break;
                    }
                }
                if(j==nlen) return i;
            }
        }
        return -1;
    }
}
*/

//279ms ver
/*
class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
*/

public class Main {
    public static void main(String[] args) {
        String[] hay ={"hello","aaaaa",""};
        String[] nee = {"ll","bba",""};
        Solution tt = new Solution();
        for(int i=0; i< hay.length;i++){
            System.out.println(tt.strStr(hay[i],nee[i]));
            System.out.println("================");
        }
    }
}
