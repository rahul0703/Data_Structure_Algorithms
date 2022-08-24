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


}
