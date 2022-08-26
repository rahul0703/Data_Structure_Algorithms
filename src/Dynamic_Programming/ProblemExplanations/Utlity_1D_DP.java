package Dynamic_Programming.ProblemExplanations;

import Dynamic_Programming.Types.Pair_buildingBridges;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Utlity_1D_DP {

    public boolean uglyNumber(int n){
        /*
        An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
        Given an integer n, return true if n is an ugly

        level: easy
        Leetcode: https://leetcode.com/problems/ugly-number/
         */
        if(n == 0){
            return false;
        }
        while(n % 2 == 0){
            n = n/2;
        }
        while(n % 3 == 0){
            n = n/3;
        }
        while(n % 5 == 0){
            n = n/5;
        }
        return n == 1? true:false;
    }

    public int findNthUglyNumber(int[] array, int n){
        /*
            A super ugly number is a positive integer whose prime factors are in the array primes.
            Given an integer n and an array of integers primes, return the nth super ugly number.
            The nth super ugly number is guaranteed to fit in a 32-bit signed integer.

            Level: Hard
            Leetcode: https://leetcode.com/problems/super-ugly-number/

            Approach:
                1. Make a dp array equals the size of primes array
                2. maintain the index in the array, till which each prime is used.
         */
        int[] count = new int[array.length];
        int[] answer = new int[n];
        answer[0] = 1;
        int max = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < array.length; j++){
                while(answer[count[j]] * array[j] <= max){
                    count[j]++;
                }
            }
            int minIndex = 0;
            int minValue = answer[count[0]] * array[0];
            for(int j = 1; j < array.length; j++){
                int index = count[j];
                if(minValue > answer[index] * array[j]){
                    minValue = answer[index] * array[j];
                    minIndex = j;
                }
            }

            answer[i] = minValue;
            max = answer[i];
            count[minIndex]++;
        }
        return answer[n-1];
    }

    public boolean canReachTopOrNot(int[] nums){
        /*
        You are given an integer array nums. You are initially positioned at the array's first index,
        and each element in the array represents your maximum jump length at that position.
        Return true if you can reach the last index, or false otherwise.

        Level: Medium
        Leetcode: https://leetcode.com/problems/jump-game/

        Approach:
            1. Update the max reach at every step.
            2. At every step, check if step <= max_reach before that. If not, return false;
         */
        int x = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                x = nums[i];
                continue;
            }
            if(i > x){
                return false;
            }
            x = Math.max(x, i + nums[i]);
        }

        return true;
    }

    public int minJumpRequiredToReachTop(int[] nums){
        /*
        Given an array of non-negative integers nums, you are initially positioned at the first index
        of the array. Each element in the array represents your maximum jump length at that position.
        Your goal is to reach the last index in the minimum number of jumps.
        You can assume that you can always reach the last index.

        Level: Medium
        Leetcode: https://leetcode.com/problems/jump-game-ii/

        Approach: At every step, update the min jump till the max jump from current.
                  return the number at last index of dp.
         */
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int currMin = dp[i];
            for(int j = i+1; j <= i + num; j++){
                if(j >= nums.length){
                    break;
                }
                dp[j] = dp[j] == 0? currMin + 1 : Math.min(dp[j], currMin + 1);
            }
        }
        return dp[nums.length -1];
    }

    public int longestIncreasingSubsequence(int[] nums){
        /*
        Given an integer array nums, return the length of the longest strictly increasing subsequence.
        A subsequence is a sequence that can be derived from an array
        by deleting some or no elements without changing the order of the remaining elements.
        For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7]

        Level: Medium
        Leetcode: https://leetcode.com/problems/longest-increasing-subsequence/

        Approach:
            1. This is a classic Dp question. We will make a 1D dp array
            and store the longest increasing subsequence at each index in the DP array
            2. for all prev, if the num > prev num, dp[i] = Max(dp[prv] + 1).
         */

        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans= 1;
        for(int i = 1;i < nums.length; i++){
            int max = 1;
            for(int j = 0; j < i; j++){
                max = nums[i] > nums[j] ? Math.max(max, dp[j] + 1) : max;
            }
            dp[i] = max;
            ans = Math.max(ans, max);
        }
        return ans;
    }

    public int longestBiotonicSubsequence(int[] nums){
        /*
            Same as above, here it is biotonic subsequence (increasing and then decreasing)
            Strictly increasing and strictly decreasing is also biotonic

            Level: Medium
            GFG: https://www.geeksforgeeks.org/longest-bitonic-subsequence-dp-15/

            Approach: Same as above
         */
        if(nums.length <= 1 ){
            return nums.length;
        }
        int[] dpIncreasing = new int[nums.length];
        int[] dpReverseIncreasing = new int[nums.length];
        dpIncreasing[0] = 1;
        dpReverseIncreasing[nums.length-1] = 1;
        for(int i = 1; i < nums.length; i++){
            int max = 1;
            for(int j = 0; j < i; j++){
                max = nums[i] > nums[j] ? Math.max(max, dpIncreasing[j] + 1) : max;
            }
            dpIncreasing[i] = max;
        }
        for(int i = nums.length-2; i >= 0; i--){
            int max = 1;
            for(int j = nums.length-1; j > i; j--){
                max = nums[i] > nums[j] ? Math.max(max, dpReverseIncreasing[j] + 1) : max;
            }
            dpReverseIncreasing[i] = max;
        }
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            ans = Math.max(ans, dpIncreasing[i] + dpReverseIncreasing[i] -1);
        }
        return ans;
    }

    public long maxAltSubseqDiff(int[] nums){
        /*
        The alternating sum of a 0-indexed array is defined as the sum of the elements
        at even indices minus the sum of the elements at odd indices.

        For example, the alternating sum of [4,2,5,3] is (4 + 5) - (2 + 3) = 4.
        Given an array nums, return the maximum alternating sum of any subsequence
        of nums (after reindexing the elements of the subsequence).

        Level: Medium-hard
        Leetcode: https://leetcode.com/problems/maximum-alternating-subsequence-sum/

        Approach:
            1. We'll make a Dp[n][2] size.
            2. n,0 will have maximum sum, if current element is at even place.
            3. n,1 will have maximum sum, if current element is at odd place.
            4. We will update the maxAtEven ad maxAtOdd at every step to use in next iteration.
         */
        long[][] dp = new long[nums.length][2];
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        long ans = nums[0];

        long maxPos = nums[0];
        long maxNeg = 0;

        for(int i = 0; i < nums.length; i++){
            dp[i][0] = maxNeg + nums[i];
            dp[i][1] = maxPos - nums[i];

            maxPos = Math.max(maxPos, dp[i][0]);
            maxNeg = Math.max(maxNeg, dp[i][1]);
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }
        return ans;
    }

    public int buildingBridges(int[] north, int[] south){
        if(south.length == 0 || south.length == 1){
            return south.length;
        }
        Pair_buildingBridges[] array = new Pair_buildingBridges[north.length];
        for(int i = 0;i < north.length; i++){
            array[i] = new Pair_buildingBridges(north[i], south[i]);
        }
        Arrays.sort(array);
        int[] dp = new int[north.length];
        dp[0] = 1;
        int ans = 1;
        for(int i = 1; i < north.length; i++){
            Pair_buildingBridges pairIter = array[i];
            int southIter = pairIter.getSouth();
            int max = 1;
            for(int j = 0; j < i; j++){
                max = array[j].getSouth() < southIter ? Math.max(max, dp[j] + 1) : max;
            }
            dp[i] = max;
            ans =Math.max(ans, dp[i]);
        }
        return ans;
    }

}
