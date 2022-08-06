package Searching_sorting;

import java.util.*;

public class Utility {


    public int majorityElement(int[] nums) {
        /*
            find an element which appear more that n/2 times in a array
            Leetcode : https://leetcode.com/problems/majority-element/
        */
        Integer num = null;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int currNum = nums[i];
            if(num == null){
                num = currNum;
                count++;
            }else{
                if(currNum == num){
                    count++;
                }else{
                    count--;
                    if(count <= 0){
                        num = currNum;
                        count = 1;
                    }
                }
            }
        }

        int finalCount = 0;
        for(int currNum2 : nums){
            if(currNum2 == num){
                finalCount++;
            }
        }
        if(finalCount > nums.length/2){
            return num;
        }
        return -1;
    }

    public int maxGapBwAdEleInSrtdFrm(int[] nums){
        /*  Given an integer array nums, return the maximum difference between two successive elements
            in its sorted form. If the array contains less than two elements, return 0.

            Leetcode : https://leetcode.com/problems/maximum-gap/
            This a classic bucket-sort implementation problem
            Things to remember :
                1. avgGap = ceil(max-min)/(n-1);
                2. noOfBucket = (max - min)/avgGap + 1;
                3. bucketNumber = (num - min)/avgGap;
        */

        Integer min = Integer.MAX_VALUE;
        Integer max = Integer.MIN_VALUE;

        for(int num : nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if(max == min){
            return 0;
        }
        int avgGap = (int) Math.ceil((max - min)/(nums.length - 1.0));
        int numOfBuckets = (int) Math.ceil((max - min)/(avgGap + 0.0)) + 1;

        int[][] buckets = new int[numOfBuckets][2];
        for(int i = 0; i < numOfBuckets; i++){
            buckets[i][0] = max;
            buckets[i][1] = min;
        }
        for(int num : nums){
            int bucketNumber = (num - min)/avgGap;
            buckets[bucketNumber][0] = Math.min(num, buckets[bucketNumber][0]);
            buckets[bucketNumber][1] = Math.max(num, buckets[bucketNumber][1]);
        }
        int maxDiffInSotdForm = 0;
        int prev = -1;
        for(int i = 0; i < numOfBuckets; i++){
            if(buckets[i][0] == max && i != numOfBuckets - 1){
                continue;
            }
            if(prev == -1){
                prev = buckets[i][1];
            }else{
                maxDiffInSotdForm = Math.max(maxDiffInSotdForm, buckets[i][0] - prev);
                prev = buckets[i][1];
            }
        }

        return maxDiffInSotdForm;
    }


}
