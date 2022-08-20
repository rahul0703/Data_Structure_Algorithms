package Searching_sorting.Implementation;

import java.util.Arrays;

public class Merge2Sorted_Arrays {
    public void merge2SortedArraysInO1Space(int[] nums1, int[] nums2){
        /*
        We are given two sorted arrays. We need to merge these two arrays such that the initial numbers
        (after complete sorting) are in the first array and the remaining numbers are in the second array.
        Extra space is allowed in O(1).

        GFG: https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/

        Approach:
            1. Travel array1 and array2 simultaneously and swap the lowest element to array1, and increase the count.
         */
        int i = 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] <= nums2[j]){
                i++;
                continue;
            }
            if(nums1[i] > nums2[j]){
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                i++;
                j++;
            }
        }

        Arrays.sort(nums2);
    }


}
