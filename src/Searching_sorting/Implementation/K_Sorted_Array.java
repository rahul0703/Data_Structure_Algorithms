package Searching_sorting.Implementation;

import java.util.PriorityQueue;

public class K_Sorted_Array {
    public void KSortedArray(int[] nums, int K){
        /*
        here every element is atmost K distance far from its desired place.
        write an algo, that sort it in nlog(k) Time complexity

        We can use priorityQueue here, of size K+1, and will travel and pop out lowest element and add
        the corrosponding element at every step.
         */

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i <= K; i++){
            queue.add(nums[i]);
        }

        for(int i = K+1; i < nums.length; i++){
            nums[i-K] = queue.poll();
            queue.add(nums[i]);
        }
        for(int i = nums.length - K - 1; i < nums.length; i++){
            nums[i] = queue.poll();
        }
    }
}
