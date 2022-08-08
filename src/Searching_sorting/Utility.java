package Searching_sorting;

import Searching_sorting.Implementation.Binary_search;

import java.lang.reflect.Array;
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

    public ArrayList<Integer> missingAndRepeatingNumberInArray(int[] nums){
        /*
            Given an unsorted array of size n. Array elements are in the range of 1 to n. One number from set {1, 2, …n}
            is missing and one number occurs twice in the array. Find these two numbers

            GFG : https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/

            This is a classic Bit Manupulation question, but this can also be solved by dummy indexing method.

            Approach :
                Mod(nums[i]) = x;
                nums[x-1] = -nums[x-1];
                this way, the postive element index will be missing one and the one which is already negative will be negative one.
         Time Cmplx: O(n)
         Space Cmplx : O(1)
         */
        ArrayList<Integer> answer = new ArrayList<>(Arrays.asList(0, 0));
        Integer missing = -1;
        Integer repeating = -1;
        for(int i = 0; i < nums.length; i++){
            int num = Math.abs(nums[i]);
            int idx = num-1;
            if(nums[idx] < 0){
                repeating = num;
                continue;
            }
            nums[idx] = -1 * nums[idx];
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                missing = i+1;
            }
        }
        answer.add(0, missing);
        answer.add(1, repeating);
        return answer;
    }

    public ArrayList<Integer> findCeilAndFloorOfXinSrtdArray(int[] nums, int x){
        /*
            Given a sorted array and a value x, the ceiling of x is the smallest element in an array greater than or equal to x,
            and the floor is the greatest element smaller than or equal to x.
            Assume that the array is sorted in non-decreasing order. Write efficient functions to find the floor and ceiling of x.

            Leetcode : https://leetcode.com/problems/search-insert-position/

            This a classical binary search question, if element is found the return pos or return pos where it would be inserted.

            Time Cmplx : O(logn)
            space Complx : O(1)
         */
        Binary_search binarySearch = new Binary_search();

        int index = binarySearch.binarySearch2(nums, x);
        return new ArrayList<>(Arrays.asList(index-1, index));
    }

    public int findUniquePairWithGivenDiffInArr(int[] nums, int diff){
        /*
            Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.

            A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

            0 <= i, j < nums.length
            i != j
            nums[i] - nums[j] == k
            Notice that |val| denotes the absolute value of val

            Leetcode : https://leetcode.com/problems/k-diff-pairs-in-an-array/

            Approach : 1. using sorting : sort the array and applying sliding window.
                            Time Cmplx : O(nlogn)
                            space Cmplx : O(n)
                       2. using HashSet : travel the array and find num - diff and num + diff in hashset. Insert num in hashset.
                            Time Cmplx : O(n)
                            Space Cmplx : O(n)
            we are going to implement both approach
         */
        return findUniquePairWithGivenDiffInArrSorting(nums, diff);
//        return 0;
    }

    public int findUniquePairWithGivenDiffInArrSorting(int[] nums, int diff){
        Arrays.sort(nums);
        int left = 0;
        int right = 1;
        int count = 0;
        int prevRight = Integer.MIN_VALUE;
        while(right < nums.length){
            if(left > right){
                right++;
                continue;
            }
            int diffIter = nums[right] - nums[left];
            if(diffIter < diff){
                right++;
            }else if(diffIter == diff){
                if(prevRight != nums[right] && left != right){
                    prevRight = nums[right];
                    count++;
                }
                if(left == right){
                    right++;
                }else{
                    left++;
                }
            }else{
                left++;
            }
        }
        return count;
    }
}
