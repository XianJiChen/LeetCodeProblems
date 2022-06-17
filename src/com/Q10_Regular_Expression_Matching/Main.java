package com.Q10_Regular_Expression_Matching;
/*
class Solution {
    public char[] str;
    public char[] reg;
    public boolean isMatch_sub(int idxS, int idxP){

    }
    public boolean isMatch(String s, String p) {
        str = s.toCharArray();
        reg = p.toCharArray();
        int idxS, idxP;
        for(idxS=0, idxP=0; idxS<str.length && idxP<reg.length; idxS++, idxP++){
            System.out.println("<<<<<<<<<<<<<<");
            System.out.printf("Str: %dth position: %c\n", idxS,str[idxS]);
            System.out.printf("Reg: %dth position: %c\n", idxP,reg[idxP]);
            System.out.println("--------------");
            if(idxP!= reg.length-1){
                switch (reg[idxP+1]){
                    case '*':
                        if(reg[idxP]=='.'){
                            if(idxP+1 == reg.length-1) return true;//while(idxS<str.length) idxS++;//when the * character is at the end of reg
                            else for(;idxS<str.length && str[idxS] != reg[idxP+2];idxS++) {
                                if(this.isMatch_sub())
                            }
                        }
                        else{
                            if(str[idxS] == reg[idxP]){
                                while(idxS<str.length && str[idxS] == reg[idxP]) idxS++;
                            }
                            if((idxP+1<reg.length && reg[idxP+1]==reg[idxP]) || (idxP+2<reg.length && reg[idxP+2]==reg[idxP] && reg[idxP+1]=='*')){
                                while(idxP+1<reg.length || idxP+2<reg.length) {
                                    if(reg[idxP+2]==reg[idxP] && reg[idxP+1]=='*') idxP+=2;
                                    else if(reg[idxP+1]==reg[idxP]) idxP++;
                                    else break;
                                }
                                idxP-=1;
                            }
                        }
                        idxP++;
                        idxS--;
                        //if(idxS==str.length) idxS--;
                        break;
                    case '.':
                        if(str[idxS] != '.' && str[idxS] != reg[idxP]) return  false;
                        else{
                            idxS++;
                            idxP++;
                        }
                        break;
                    default:
                        if(str[idxS] != '.' && str[idxS] != reg[idxP]) return  false;
                        break;
                }
            }
            else{
                if(reg[idxP]=='.') return (idxS==str.length-1);
                else if(str[idxS] != reg[idxP]) return  false;
            }
            System.out.println(">>>>>>>>>>>>>>");
        }
        if()
            return (idxS>=str.length && idxP>=reg.length)? true : false;
    }
}
*/
/*
    public boolean isMatch(String s, String p) {
        str = s.toCharArray();
        reg = p.toCharArray();
        int idxS, idxP;
        for(idxS=0, idxP=0; idxS<str.length && idxP<reg.length; idxS++, idxP++){
            System.out.println("<<<<<<<<<<<<<<");
            System.out.printf("Str: %dth position: %c\n", idxS,str[idxS]);
            System.out.printf("Reg: %dth position: %c\n", idxP,reg[idxP]);
            System.out.println("--------------");
            if(idxP!= reg.length-1){
                switch (reg[idxP+1]){
                    case '*':
                        if(reg[idxP]=='.'){
                            if(idxP+1 == reg.length-1) return true;//while(idxS<str.length) idxS++;//when the * character is at the end of reg
                            else while(idxS<str.length && str[idxS] != reg[idxP+2]) idxS++;
                        }
                        else{
                            if(str[idxS] == reg[idxP]){
                                while(idxS<str.length && str[idxS] == reg[idxP]) idxS++;
                            }
                            if((idxP+1<reg.length && reg[idxP+1]==reg[idxP]) || (idxP+2<reg.length && reg[idxP+2]==reg[idxP] && reg[idxP+1]=='*')){
                                while(idxP+1<reg.length || idxP+2<reg.length) {
                                    if(reg[idxP+2]==reg[idxP] && reg[idxP+1]=='*') idxP+=2;
                                    else if(reg[idxP+1]==reg[idxP]) idxP++;
                                    else break;
                                }
                                idxP-=1;
                            }
                        }
                        idxP++;
                        idxS--;
                        //if(idxS==str.length) idxS--;
                        break;
                    case '.':
                        if(str[idxS] != '.' && str[idxS] != reg[idxP]) return  false;
                        else{
                            idxS++;
                            idxP++;
                        }
                        break;
                    default:
                        if(str[idxS] != '.' && str[idxS] != reg[idxP]) return  false;
                        break;
                }
            }
            else{
                if(reg[idxP]=='.') return (idxS==str.length-1);
                else if(str[idxS] != reg[idxP]) return  false;
            }
            System.out.println(">>>>>>>>>>>>>>");
        }
        if()
        return (idxS>=str.length && idxP>=reg.length)? true : false;
    }

}
*/

/*
class Solution {
    public boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] reg = p.toCharArray();
        int idxS, idxP;
        for(idxS=0, idxP=0; idxS<str.length && idxP<reg.length; idxS++, idxP++) {
            if(reg[idxP] == '*'){
                if(reg[idxP-1]=='.') {
                    while(idxS+1<str.length){
                        if(idxP+1<reg.length && str[idxS+1]==reg[idxP+1]) break;
                        else idxS++;
                    }
                }
                else {
                    while(idxS<str.length && str[idxS]==reg[idxP-1]) idxS++;
                    if(idxS==str.length) idxS--;
                }
            }
            else if(reg[idxP]=='.'){
                continue;
            }
            else{
                if(str[idxS]!=reg[idxP]) return false;
            }
        }
        return (idxS==str.length && idxP==reg.length) ? true : false;
    }
}
*/

//36ms ver
/*
class Solution {
    public boolean isMatch(String s, String p) {
        return myIsMatch(s, 0, p, 0);
    }

    public boolean myIsMatch(String s, int idxS, String p, int idxP) {
//        System.out.println("In");
//        System.out.println(idxS);
//        System.out.println(idxP);
//        System.out.println("for");
        for (; idxS < s.length() && idxP < p.length(); ) {
            if (idxP == p.length() - 1 || p.charAt(idxP + 1) != '*') {
                switch (p.charAt(idxP)) {
                    case '.':
                        break;
                    default:
                        if (s.charAt(idxS) != p.charAt(idxP)) {
                            return false;
                        }
                        break;
                }
                idxS++;
                idxP++;
            } else {
                switch (p.charAt(idxP)) {
                    case '.':
                        if (idxP + 2 == p.length()) {
                            return true;
                        } else {
                            while (idxS < s.length()) {
                                if (myIsMatch(s, idxS, p, idxP + 2)) {
                                    return true;
                                } else {
                                    idxS++;
                                }
                            }
                        }
                        break;
                    default:
                        if (idxP + 2 == p.length()) {
                            while(idxS<s.length()){
                                if(s.charAt(idxS)!=p.charAt(idxP)){
                                    return false;
                                }
                                else{
                                    idxS++;
                                }
                            }
                        } else {
                            while (idxS < s.length() && s.charAt(idxS) == p.charAt(idxP)) {
                                if (myIsMatch(s, idxS, p, idxP + 2)) {
                                    return true;
                                }
                                idxS++;
                            }
                        }
                        break;
                }
                idxP += 2;
            }
        }
        if (idxS == s.length()) {
            while (idxP + 1 < p.length() && p.charAt(idxP + 1) == '*') {
                idxP += 2;
            }
        }

        if ((idxS == s.length() && idxP < p.length()) || (idxS < s.length() && idxP == p.length())) {
            return false;
        } else {
            return true;
        }
    }
}
*/

//2ms ver
class Solution {
    public boolean isMatch(String s, String p) {
        // corner case
        if(s == null || p == null) return false;

        int m = s.length();
        int n = p.length();

        // M[i][j] represents if the 1st i characters in s can match the 1st j characters in p
        boolean[][] M = new boolean[m + 1][n + 1];

        // initialization:
        // 1. M[0][0] = true, since empty string matches empty pattern
        M[0][0] = true;

        // 2. M[i][0] = false(which is default value of the boolean array) since empty pattern cannot match non-empty string
        // 3. M[0][j]: what pattern matches empty string ""? It should be #*#*#*#*..., or (#*)* if allow me to represent regex using regex :P,
        // and for this case we need to check manually:
        // as we can see, the length of pattern should be even && the character at the even position should be *,
        // thus for odd length, M[0][j] = false which is default. So we can just skip the odd position, i.e. j starts from 2, the interval of j is also 2.
        // and notice that the length of repeat sub-pattern #* is only 2, we can just make use of M[0][j - 2] rather than scanning j length each time
        // for checking if it matches #*#*#*#*.
        for(int j = 2; j < n + 1; j +=2){
            if(p.charAt(j - 1) == '*' && M[0][j - 2]){
                M[0][j] = true;
            }
        }

        // Induction rule is very similar to edit distance, where we also consider from the end. And it is based on what character in the pattern we meet.
        // 1. if p.charAt(j) == s.charAt(i), M[i][j] = M[i - 1][j - 1]
        //    ######a(i)
        //    ####a(j)
        // 2. if p.charAt(j) == '.', M[i][j] = M[i - 1][j - 1]
        // 	  #######a(i)
        //    ####.(j)
        // 3. if p.charAt(j) == '*':
        //    1. if p.charAt(j - 1) != '.' && p.charAt(j - 1) != s.charAt(i), then b* is counted as empty. M[i][j] = M[i][j - 2]
        //       #####a(i)
        //       ####b*(j)
        //    2.if p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i):
        //       ######a(i)
        //       ####.*(j)
        //
        // 	  	 #####a(i)
        //    	 ###a*(j)
        //      2.1 if p.charAt(j - 1) is counted as empty, then M[i][j] = M[i][j - 2]
        //      2.2 if counted as one, then M[i][j] = M[i - 1][j - 2]
        //      2.3 if counted as multiple, then M[i][j] = M[i - 1][j]

        // recap:
        // M[i][j] = M[i - 1][j - 1]
        // M[i][j] = M[i - 1][j - 1]
        // M[i][j] = M[i][j - 2]
        // M[i][j] = M[i][j - 2]
        // M[i][j] = M[i - 1][j - 2]
        // M[i][j] = M[i - 1][j]
        // Observation: from above, we can see to get M[i][j], we need to know previous elements in M, i.e. we need to compute them first.
        // which determines i goes from 1 to m - 1, j goes from 1 to n + 1

        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                char curS = s.charAt(i - 1);
                char curP = p.charAt(j - 1);
                if(curS == curP || curP == '.'){
                    M[i][j] = M[i - 1][j - 1];
                }else if(curP == '*'){
                    char preCurP = p.charAt(j - 2);
                    if(preCurP != '.' && preCurP != curS){
                        M[i][j] = M[i][j - 2];
                    }else{
                        M[i][j] = (M[i][j - 2] || M[i - 1][j - 2] || M[i - 1][j]);
                    }
                }
            }
        }

        return M[m][n];
    }
}

public class Main {
    public static void main(String[] args) {
        String[] inputs1 = {"aa", "aa", "ab", "aab", "mississippi", "mississippi", "aaa", "aaa", "aaa", "a"};//aaaabc,
        String[] inputs2 = {"a", "a*", ".*", "c*a*b", "mis*is*ip*.", "mis*is*p*.", "a.a", "a*a", "ab*a*c*a", "ab*"};//.*aabc
        Solution tt = new Solution();

        for (int idxS = 0; idxS < inputs1.length; idxS++) {
            System.out.println(inputs1[idxS]);
            System.out.println(inputs2[idxS]);
            System.out.println(tt.isMatch(inputs1[idxS], inputs2[idxS]));
            System.out.println("==============================");
        }
    }
}
