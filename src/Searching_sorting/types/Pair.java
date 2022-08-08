package Searching_sorting.types;

import java.util.*;

public class Pair implements Comparable<Pair>{
    int num1;
    int num2;
    int sum;

    public Pair(int num1, int nums2){
        this.num1 = num1;
        this.num2 = nums2;
        this.sum = num1 + nums2;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int compareTo(Pair o){
        return this.sum - o.sum;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }
}
