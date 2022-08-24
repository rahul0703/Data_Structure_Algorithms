package Dynamic_Programming.ProblemExplanations;

public class Utlity_2D_DP {
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
