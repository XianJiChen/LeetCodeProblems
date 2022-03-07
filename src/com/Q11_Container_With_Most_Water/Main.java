package com.Q11_Container_With_Most_Water;
//2ms 99% ver
class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int tmp=0,cnt, max = (height[0]<height[len-1]) ? height[0]*(len-1) : height[len-1]*(len-1);
        for(int i=0, j = len-1, hl=height[0], hr=height[len-1];i<j;){
            if(i+1==j){
                tmp = (height[i]<height[j]) ? height[i] : height[j];
                max = (max>tmp) ? max : tmp;
                break;
            }
            else if(hl==hr){
                cnt =1;
                while(i+cnt< len && height[i+cnt]<=hl && i+cnt<j) cnt++;

                tmp = cnt;
                cnt =1;
                while(j-cnt>=0 && height[j-cnt]<=hr && i<j-cnt) cnt++;

                if(i+tmp>=len && j-cnt<0) break;
                else if(i+tmp>= len) j-=cnt;
                else if(j-cnt<0) i+=tmp;
                else{
                    if(tmp==cnt){
                        if(i+tmp<j-cnt && height[i+tmp]==height[j-cnt]){
                            i+=tmp;
                            j-=cnt;
                        }
                        else{
                            if(height[i+tmp]>height[j-cnt]) i+=tmp;
                            else j-= cnt;
                        }

                    }
                    else if(tmp<cnt){
                        i+= tmp;
                    }
                    else if(tmp>cnt){
                        j-= cnt;
                    }
                }
                hl = (height[i]>hl) ? height[i] : hl;
                hr = (height[j]>hr) ? height[j] : hr;
                tmp = (hl<hr) ? hl*(j-i) : hr*(j-i);
                max =(max>tmp) ? max:tmp;
            }
            else if(hl<hr){
                while(height[i]<=hl && i<j) i++;
                hl = (height[i]>hl) ? height[i] : hl;
                tmp = (hl<hr) ? hl*(j-i) : hr*(j-i);
                max =(max>tmp) ? max:tmp;
            }
            else if(hl>hr){
                while(height[j]<=hr && i<j) j--;
                hr = (height[j]>hr) ? height[j] : hr;
                tmp = (hl<hr) ? hl*(j-i) : hr*(j-i);
                max =(max>tmp) ? max:tmp;
            }
        }
        return max;
    }
}

/*
class Solution {
    public int maxArea(int[] height) {
        boolean print = false;
        int len = height.length;
        int tmp=0,cnt, max = Math.min(height[0],height[len-1])* (len-1);
        for(int i=0, j = len-1, hl=height[0], hr=height[len-1];i<j;){
            if(print) System.out.printf("At index %d w/ val: %d hl: %d\n", i, height[i], hl);
            if(print) System.out.printf("At index %d w/ val: %d hr: %d\n", j, height[j], hr);

            if(i+1==j){
//                System.out.println("case1");
                max = Math.max(max, Math.min(height[i],height[j]));
                break;
            }
            else if(hl==hr){
                if(print) System.out.println("case2");
                cnt =1;
                while(i+cnt< height.length && height[i+cnt]<=hl && i+cnt<j) cnt++;


                tmp = cnt;
                cnt =1;
                while(j-cnt>=0 && height[j-cnt]<=hr && i<j-cnt) cnt++;

                if(print) System.out.println(tmp);
                if(print) System.out.println(cnt);
                if(i+tmp>=height.length && j-cnt<0) break;
                else if(i+tmp>= height.length) j-=cnt;
                else if(j-cnt<0) i+=tmp;
                else{
                    if(tmp==cnt){
                        if(i+tmp<j-cnt && height[i+tmp]==height[j-cnt]){
                            i+=tmp;
                            j-=cnt;
                        }
                        else{
                            if(height[i+tmp]>height[j-cnt]) i+=tmp;
                            else j-= cnt;
                        }

                    }
                    else if(tmp<cnt){
                        if(print) System.out.println("case2-1");
                        i+= tmp;
                    }
                    else if(tmp>cnt){
                        if(print) System.out.println("case2-2");
                        j-= cnt;
                    }
                }
                hl = Math.max(height[i], hl);
                hr = Math.max(height[j],hr);
                max = Math.max(max, Math.min(hl,hr)*(j-i));
//                System.out.println(i);
//                System.out.println(j);
            }
            else if(hl<hr){
                if(print) System.out.println("case3");
                while(height[i]<=hl && i<j) i++;
                hl = Math.max(height[i], hl);
                max = Math.max(max, Math.min(hl,hr)*(j-i));
            }
            else if(hl>hr){
                if(print) System.out.println("case4");
                while(height[j]<=hr && i<j) j--;
                hr = Math.max(height[j],hr);
                max = Math.max(max, Math.min(hl,hr)*(j-i));
            }
            if(print) System.out.println("---------------");
        }
        return max;
    }
}
*/
//Time Limit Exceeded
/*
class Solution {
    public int maxArea(int[] height) {
        int max =0;
        int tmp;
        for(int i=0; i<height.length-1; i++){
            for(int j=i+1; j<height.length; j++){
                tmp = (height[i] < height[j]) ? height[i]* (j-i) : height[j]* (j-i);
                max = (tmp > max) ? tmp : max;
            }
        }
        return max;
    }
}
 */

public class Main {
    public static void main(String[] args) {
        int[][] inputs = {{1,8,6,2,5,4,8,3,7},{1,1},{1,3,2,5,25,24,5}};
        Solution tt = new Solution();
        for(int[] input:inputs){
            //for(int t : input) System.out.println(t);

            System.out.println(tt.maxArea(input));
            System.out.println("===============");
        }
    }
}
