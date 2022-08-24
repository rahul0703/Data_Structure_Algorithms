package Dynamic_Programming.ProblemExplanations;

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

}
