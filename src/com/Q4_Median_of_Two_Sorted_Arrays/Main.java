package com.Q4_Median_of_Two_Sorted_Arrays;
import java.util.*;
import java.text.DecimalFormat;
//class Sotring{
//    public int[] MergeSort(int[] arr1, int[] arr2){
//
//    }
//}
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mid = (nums1.length+ nums2.length)/2;
        int[] arr = {0,0};
        if(nums1.length == 0){
            arr[1] = nums2[mid];
            if(nums2.length%2==0) arr[0] = nums2[mid-1];
        }
        else if(nums2.length ==0){
            arr[1] = nums1[mid];
            if(nums1.length%2==0) arr[0] = nums1[mid-1];
        }
        else if(nums1[nums1.length-1]<nums2[0]){
            arr[1] = (mid < nums1.length) ? nums1[mid] : nums2[mid- nums1.length];
            if((nums1.length+ nums2.length)%2==0){
                arr[0] = (mid-1 < nums1.length) ? nums1[mid-1] : nums2[mid-1 - nums1.length];
            }
        }
        else if(nums2[nums2.length-1]<nums1[0]){
            arr[1] = (mid < nums2.length) ? nums2[mid] : nums1[mid- nums2.length];
            if((nums1.length+ nums2.length)%2==0){
                arr[0] = (mid-1 < nums2.length) ? nums2[mid-1] : nums1[mid-1 - nums2.length];
            }
        }
        else{
            for(int i=0, j=0, k=0; k<mid+1; k++) {
                if(k==mid-1||k==mid){
                    if (i == nums1.length) {
                        arr[k-mid+1] = nums2[j++];
                    } else if (j == nums2.length) {
                        arr[k-mid+1] = nums1[i++];
                    } else {
                        if (nums1[i] < nums2[j]) {
                            arr[k-mid+1] = nums1[i++];
                        } else {
                            arr[k-mid+1] = nums2[j++];
                        }
                    }
                }else{
                    if (i == nums1.length) {
                        j++;
                    } else if (j == nums2.length) {
                        i++;
                    } else {
                        if (nums1[i] < nums2[j]) i++;
                        else j++;
                    }
                }
            }
        }

        return ((nums1.length + nums2.length) % 2 == 1) ? (double) arr[1] : (double)(arr[0]+arr[1])/2.0;
    }
}

/*
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mid = (nums1.length+ nums2.length)/2;
        int[] arr = {0,0};
        for(int i=0, j=0, k=0; k<mid+1; k++) {
            if(k==mid-1||k==mid){
                if (i == nums1.length) {
                    arr[k-mid+1] = nums2[j++];
                } else if (j == nums2.length) {
                    arr[k-mid+1] = nums1[i++];
                } else {
                    if (nums1[i] < nums2[j]) {
                        arr[k-mid+1] = nums1[i++];
                    } else {
                        arr[k-mid+1] = nums2[j++];
                    }
                }
            }else{
                if (i == nums1.length) {
                    j++;
                } else if (j == nums2.length) {
                    i++;
                } else {
                    if (nums1[i] < nums2[j]) {
                        i++;
                    } else {
                        j++;
                    }
                }
            }
        }

        return ((nums1.length + nums2.length) % 2 == 1) ? (double) arr[1] : (double)(arr[0]+arr[1])/2.0;
    }
}
*/
/*
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mid = (nums1.length+ nums2.length)/2;
        int[] arr = new int[mid+1];

        for(int i=0, j=0, k=0; k<mid+1; k++) {
//            System.out.println("----------");
//            System.out.println(nums1[i]);
//            System.out.println(nums2[j]);
            if (i == nums1.length) {
                arr[k] = nums2[j++];
            } else if (j == nums2.length) {
                arr[k] = nums1[i++];
            } else {
                if (nums1[i] < nums2[j]) {
                    arr[k] = nums1[i++];
                } else {
                    arr[k] = nums2[j++];
                }
            }
            //System.out.println(arr[k]);
        }
//        for(int k=0; k<mid+1; k++)
//            System.out.println(arr[k]);
        return ((nums1.length + nums2.length) % 2 == 1) ? (double) arr[mid] : (double)(arr[mid-1]+arr[mid])/2.0;
    }
}
*/

/*
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mid = (nums1.length + nums2.length)/2;
        //mid = ((nums1.length + nums2.length) %2 == 1) ? mid:mid-1;
//        System.out.println("mid =");
//        System.out.println(mid);
        int i=0, j=0;
        int k1=0, k2=0;
        if(nums1.length==0){
            if(nums2.length%2==1){
                k2 = nums2[mid];
            }
            else{
                k1 = nums2[mid-1];
                k2 = nums2[mid];
            }
        }
        else if(nums2.length==0){
            if(nums1.length%2==1){
                k2 = nums1[mid];
            }
            else{
                k1 = nums1[mid-1];
                k2 = nums1[mid];
            }
        }
        else if(nums1[nums1.length-1]<nums2[0]){
            if((nums1.length + nums2.length) %2 == 1){
                k2 = (mid < nums1.length) ? nums1[mid] : nums2[mid- nums1.length];
            }
            else{
                k1 = (mid-1 < nums1.length) ? nums1[mid-1] : nums2[mid-1 - nums1.length];
                k2 = (mid < nums1.length) ? nums1[mid] : nums2[mid- nums1.length];
            }
        }
        else if(nums2[nums2.length-1]<nums1[0]){
            if((nums1.length + nums2.length) %2 == 1){
                k2 = (mid < nums2.length) ? nums2[mid] : nums1[mid- nums2.length];
            }
            else{
                k1 = (mid-1 < nums2.length) ? nums2[mid-1] : nums1[mid-1 - nums2.length];
                k2 = (mid < nums2.length) ? nums2[mid] : nums1[mid- nums2.length];
            }
        }
        else{
            for(int k = 0;i <= nums1.length && j <= nums2.length && k <= mid; k++){
                if(i == nums1.length){
                    if(k==mid-1) k1 = nums2[j];
                    if(k==mid) k2 = nums2[j];
                    j++;
                }
                else if(j == nums2.length){
                    if(k==mid-1) k1 = nums1[i];
                    if(k==mid) k2 = nums1[i];
                    i++;
                }
                else{
                    if(nums1[i]<nums2[j]){
                        if(k==mid-1) k1 = nums1[i];
                        if(k==mid) k2 = nums1[i];
                        i++;
                    }
                    else {
                        if(k==mid-1) k1 = nums2[j];
                        if(k==mid) k2 = nums2[j];
                        j++;
                    }
                }
            }
        }
        return ((nums1.length + nums2.length) % 2 == 1) ? (double) k2 : (double)(k1+k2)/2.0;
    }
}
 */
public class Main {
    public static void main(String[] args){
        int[][] nums1s = {{1,3},{1,2}};
        int[][] nums2s = {{2},{3,4}};
        Solution tt = new Solution();
        for(int i=0; i< nums1s.length; i++){
            System.out.println(new DecimalFormat("#,###.00000").format(tt.findMedianSortedArrays(nums1s[i],nums2s[i])));

            System.out.println("=============================");
        }
    }
}
