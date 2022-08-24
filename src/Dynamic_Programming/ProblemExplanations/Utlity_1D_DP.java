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


    public int AreaOfLargestSqaureOfAll1(char[][] matrix){
        /*
            Given an m x n binary matrix filled with 0's and 1's,
            find the largest square containing only 1's and return its area.

            Level: Medium
            Leetcode: https://leetcode.com/problems/maximal-square/

            Approach:
                1. At every index the largest matrix size will be min(diagonal, up, left) + 1
                2. for all the corners, the largest size square ending there would be 1;
                3. At 0, 0. the matrix and value will be same.
         */
        int[][] value = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(i == 0 && j == 0){
                    value[i][j] = matrix[i][j] == '1'? 1 : 0;
                }else if(i == 0){
                    value[i][j] = matrix[i][j] == '1'? 1 : 0;
                }else if(j == 0){
                    value[i][j] = matrix[i][j] == '1'? 1 : 0;
                }else{
                    value[i][j] = matrix[i][j] == '1'? Math.min(Math.min(value[i-1][j], value[i][j-1]), value[i-1][j-1]) + 1: 0;
                    max = Math.max(max, value[i][j]);
                }
                if(value[i][j] >= 1){
                    max = Math.max(max, 1);
                }
            }
        }
        return max*max;
    }

    public boolean targetSumSubset(int[] nums){
        /*
        Given a non-empty array nums containing only positive integers, find
        if the array can be partitioned into two subsets such that the sum of elements
         in both subsets is equal.

        Level: Medium
        Leetcode: https://leetcode.com/problems/partition-equal-subset-sum/

        Approach:
            1. At every point, we will check
            a. If the current element is equal to target : true
            b. If the target was completed before reaching the curr element : true
            c. If the target-currElement is reached: true
         */
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0){
            return false;
        }
        int target = sum/2;
        boolean[][] dp = new boolean[target+1][nums.length];

        for(int i = 0; i <= target; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0){
                    dp[i][j] = true;
                    continue;
                }
                int num = nums[j];
                if(num > i){
                    dp[i][j] = j == 0 ? false : dp[i][j-1];
                    continue;
                }
                if(num == i){
                    dp[i][j] = true;
                    continue;
                }
                if(num < i){
                    dp[i][j] = j == 0? false : (dp[i-num][j-1] == true ? true : dp[i][j-1]);
                    continue;
                }
            }
        }
        return dp[target][nums.length - 1];
    }
}
