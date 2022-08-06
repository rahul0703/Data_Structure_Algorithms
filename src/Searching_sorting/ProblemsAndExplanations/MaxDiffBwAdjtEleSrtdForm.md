
**Link** : Leetcode 164 https://leetcode.com/problems/maximum-gap/ \
**Tag** : Hard

Given an integer array nums, return the maximum difference between two successive elements in its sorted form. If the array contains less than two elements, return 0.

You must write an algorithm that runs in linear time and uses linear extra space.



Example 1:

Input: nums = [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) has the maximum difference 3.

Example 2:

Input: nums = [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.


Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 109

Time Complexity : O(n);\
Space Complexity : O(n);


```textmate
--------------Enter your notes here-------------------------
This is a clasic example of buket-sort 

```

```java
class Solution {   
    public int maximumGap(int[] nums) {
        int MAX = Integer.MAX_VALUE, MIN = Integer.MIN_VALUE;
        int max = MIN, min = MAX;
        for(int i : nums){
            max = Math.max(i,max);
            min = Math.min(i,min);
        }
        if(max==min)    return 0;
        int gap = (int)Math.ceil(((double)(max-min)/(nums.length-1)));
        System.out.println(gap);
        int n = (max-min)/gap+1;
        System.out.println(n);
        int bucket[][] = new int[n][2];
        for(int i = 0 ; i<n ; i++){
            bucket[i][0] = MAX;
            bucket[i][1] = MIN;
        }
        for(int i : nums){
            int idx = (i-min)/gap ;
            bucket[idx][0] = Math.min(bucket[idx][0],i);
            bucket[idx][1] = Math.max(bucket[idx][1],i);
        }
        int prev = 0, res = gap;
        for(int i = 1; i<n ; i++){
            if(bucket[i][1]!=MIN){
                res = Math.max(res,bucket[i][0] - bucket[prev][1]);
                prev = i;
            }
        }
        return res;
    }
    
}
``` 








