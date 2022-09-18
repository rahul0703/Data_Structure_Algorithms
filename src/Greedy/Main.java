package Greedy;

import Greedy.hard.CreateMaximumNumberFrom2ArraysMaintainingRelativeOrder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int[] array1 = {3, 9};
        int[] array2 = {7, 9, 6};

        int[] answer = CreateMaximumNumberFrom2ArraysMaintainingRelativeOrder.createMaxNumber(array1, array2, 3);

        for(int num : answer){
            System.out.print(num + " ");
        }
    }
}
