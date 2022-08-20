package Searching_sorting.Implementation;

import java.util.Collections;
import java.util.PriorityQueue;

public class Median_In_Integer_Stream {

    private PriorityQueue<Integer> minQueue = new PriorityQueue<>();
    private PriorityQueue<Integer> maxQueue = new PriorityQueue<>(10, Collections.reverseOrder());

    public double findMedian(){

        if(minQueue.size() > maxQueue.size()){
            return minQueue.peek();
        }
        if(minQueue.size() == maxQueue.size()){
            return (minQueue.peek() + maxQueue.peek())/2.0;
        }
        if(minQueue.size() < maxQueue.size()){
            return maxQueue.peek();
        }
        return -1;
    }

    public void addNum(int num){
        int size1 = maxQueue.size();
        int size2 = minQueue.size();

        if(size1 == 0){
            maxQueue.add(num);
            return;
        }
        if(size2 == 0){
            if(num >= maxQueue.peek()){
                minQueue.add(num);
            }else{
                minQueue.add(maxQueue.poll());
                maxQueue.add(num);
            }
            return;
        }

        if(size1 == size2){
            if(num <= minQueue.peek()){
                maxQueue.add(num);
            }else{
                maxQueue.add(minQueue.poll());
                minQueue.add(num);
            }
        }else if(size1 > size2){
            if(num >= maxQueue.peek()){
                minQueue.add(num);
            }else{
                minQueue.add(maxQueue.poll());
                maxQueue.add(num);
            }
        }else{
            if(num <= minQueue.peek()){
                maxQueue.add(num);
            }else{
                maxQueue.add(minQueue.poll());
                minQueue.add(num);
            }
        }
    }
}
