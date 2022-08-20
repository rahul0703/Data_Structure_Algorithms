package Searching_sorting;

import Searching_sorting.Implementation.Binary_search;
import Searching_sorting.types.Pair;
import com.sun.org.apache.regexp.internal.RE;

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
                            space Cmplx : O(1)
         */
        return findUniquePairWithGivenDiffInArrSorting(nums, diff);

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

    public ArrayList<String> combintionOf4SumEuqalsX(int[] nums, int x){
        /*
            Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

            0 <= a, b, c, d < n
            a, b, c, and d are distinct.
            nums[a] + nums[b] + nums[c] + nums[d] == target
            You may return the answer in any order.

            Leetcode : https://leetcode.com/problems/4sum/

            Approach :
                => 1. Store all possible combinations of 2 numbers in a array
                => apply 2 pointer
            Time Complexity :
                combinations O(n2) + Sorting O(n2*log(n2)) + 2-pointer O(n2) = O(n2log(n))
            Space Complexity : O(n2)
         */
        ArrayList<String> answer = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        ArrayList<Pair> combinations = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                combinations.add(new Pair(nums[i], nums[j]));
            }
        }
        Collections.sort(combinations);

        int left = 0;
        int right = combinations.size()-1;
        while(left < right){
            Pair pair1 = combinations.get(left);
            Pair pair2 = combinations.get(right);

            int sum = pair1.getSum() + pair2.getSum();
            if(sum == x){
                int num1 = pair1.getNum1();
                int num2 = pair1.getNum2();
                int num3 = pair2.getNum1();
                int num4 = pair2.getNum2();

                ArrayList<Integer> subAns = new ArrayList<>(Arrays.asList(num1, num2, num3, num4));
                Collections.sort(subAns);
                String subAnsStr = subAns.toString();
                if(!set.contains(subAnsStr) && num1 != num3 && num1 != num4 && num2 != num3 && num2 != num4){
                    set.add(subAnsStr);
                    answer.add(subAnsStr);
                }
                int subIterRight = right -1;
                while(subIterRight > left && combinations.get(subIterRight).getSum() == pair2.getSum()){
                    int num3SubIter = combinations.get(subIterRight).getNum1();
                    int num4SubIter = combinations.get(subIterRight).getNum2();

                    ArrayList<Integer> subAnsIterRight = new ArrayList<>(Arrays.asList(num1, num2, num3SubIter, num4SubIter));
                    Collections.sort(subAnsIterRight);
                    String subAnsStrIterRight = subAnsIterRight.toString();
                    if(!set.contains(subAnsStrIterRight) && num1 != num3SubIter && num2 != num3SubIter && num1 != num4SubIter && num2 != num4SubIter){
                        set.add(subAnsStrIterRight);
                        answer.add(subAnsStrIterRight);
                    }
                    subIterRight--;
                }
                int subIterLeft = left+1;
                while(subIterLeft < right && combinations.get(subIterLeft).getSum() == pair1.getSum()){
                    int num1SubIter = combinations.get(subIterLeft).getNum1();
                    int num2SubIter = combinations.get(subIterLeft).getNum2();

                    ArrayList<Integer> subAnsIterLeft = new ArrayList<>(Arrays.asList(num1SubIter, num2SubIter, num3, num4));
                    Collections.sort(subAnsIterLeft);
                    String subAnsStrIterLeft = subAnsIterLeft.toString();
                    if(!set.contains(subAnsStrIterLeft) && num1SubIter != num3 && num1SubIter != num4 && num2SubIter != num3 && num2SubIter != num4){
                        set.add(subAnsStrIterLeft);
                        answer.add(subAnsStrIterLeft);
                    }
                    subIterLeft++;
                }
                left++;
                right--;
            }else if(sum < x){
                left++;
            }else{
                right--;
            }
        }

        return answer;
    }

    public double medianOf2SrtdArr(int[] nums1, int[] nums2){
        /*
            Given two sorted arrays nums1 and nums2 of size m and n respectively,
            return the median of the two sorted arrays.

            Leetcode : https://leetcode.com/problems/median-of-two-sorted-arrays/

            Approach :
                This is a classical Binary Search implementation

                lets say the arrays are A : [a1, a2, a3, ........, a7], B: [b1, b2, ........b9]
                now, the size of array are 7 and 9 respectively.
                1. We need to divide the array into equal index on the left and right,
                combined. example : 3-4 and 5-4 : here on the left A has 3 index and on B has 5 index. On the right 4 and 4 respectively.
                Both now have 8-8 index on left and right combined.
                2. the elements on the left should be smaller than all the elements on the right. as A3 is by default smaller than A4
                and same for B5 and B6. So, we just need to check if A3 <= B6 and B5 <= A4.

                We will use binary search on smaller array and divide the larger for the same.

                if both conditions satifies we need to output the answer.
                Remember : if the combined size of array is odd, we can directly output the middle element. If the array combined size if even
                like the one above, we need to output Math.avg(Math.max(a3, b5), Math.min(a4, b6))

            Time Cmplx : O(log(Math.min(A.size, B.size))
            Space Cmplx : O(1)

         */
        int n=nums1.length;
        int m=nums2.length;

        if (m < n)
            return medianOf2SrtdArr(nums2, nums1);

        int start1=0,end1=n;
        while(start1<=end1){
            int mid1=(start1+end1)/2;
            int mid2=(n+m+1)/2-mid1;

            int min1=(mid1==n)?Integer.MAX_VALUE:nums1[mid1];
            int max1=(mid1==0)?Integer.MIN_VALUE:nums1[mid1-1];

            int min2=(mid2==m)?Integer.MAX_VALUE:nums2[mid2];
            int max2=(mid2==0)?Integer.MIN_VALUE:nums2[mid2-1];

            if(max1<=min2 && max2<=min1){
                if((n+m)%2==0){
                    return ((double)(Math.max(max1,max2)+Math.min(min1,min2))/2);
                }else{
                    return ((double) Math.max(max1,max2));
                }
            }
            else if(max1>min2){
                end1=mid1-1;
            }
            else{
                start1=mid1+1;
            }
        }
        return 0;
    }

    public int maxSumSubsequenceWithNoAdjEle(int[] array){
        /*
            Given an array arr[] of positive numbers, the task is to find the maximum sum of a subsequence with
             the constraint that no 2 numbers in the sequence should be adjacent in the array.

             Leetcode : https://leetcode.com/problems/house-robber/

             Approach:
                This is a classic DP question
                1. Make a 2*N array, for every i {1, n} dp[0][i] will store max sum if current number is not included.
                 And dp[1][i] will store max sum if current number is to be included.
                 return the Max(dp[0][n-1], dp[1][n-1])
                 example : 5 5 10 100 10 5
                 array will be {0, 5}, {5, 5}, {5, 15}, {15, 105}, {105, 25}, {105, 110}
                 therefore answer will be 110.
         */
        int[][] dpArray = new int[2][array.length];
        for(int i = 0; i < array.length; i++){
            if(i == 0){
                dpArray[0][i] = 0;
                dpArray[1][i] = array[i];
                continue;
            }
            dpArray[0][i] = Math.max(dpArray[0][i-1], dpArray[1][i-1]);
            dpArray[1][i] = array[i] + dpArray[0][i-1];

        }
        return Math.max(dpArray[0][array.length-1], dpArray[1][array.length-1]);
    }

    public ArrayList<String> findTriplatesWithSumLessThanX(int[] array){
        /*
        Given an array of distinct integers and a sum value.
        Find count of triplets with sum smaller than given sum value.
        The expected Time Complexity is O(n2).

        GFG : https://www.geeksforgeeks.org/count-triplets-with-sum-smaller-that-a-given-value/

        Approach :
            1) Sort the input array in increasing order.
            2) Initialize result as 0.
            3) Run a loop from i = 0 to n-2.  An iteration of this loop finds all
               triplets with arr[i] as first element.
                 a) Initialize other two elements as corner elements of subarray
                    arr[i+1..n-1], i.e., j = i+1 and k = n-1
                 b) Move j and k toward each other until they meet, i.e., while (j<k),
                        (i) If arr[i] + arr[j] + arr[k] >= sum
                            then k--
                        // Else for current i and j, there can (k-j) possible third elements
                        // that satisfy the constraint.
                        (ii) Else Do ans += (k - j) followed by j++

         */
        return new ArrayList<>();
    }




}
