package Searching_sorting;

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


        return -1;
    }


}
