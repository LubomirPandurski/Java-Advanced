package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int min = Integer.MAX_VALUE;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int number : numbers) {
            queue.add(number);
        }
        for (int i = 0; i < arr[1]; i++) {
            queue.remove();
        }
        if(queue.contains(arr[2])){
            System.out.println("true");
        }
        else if(queue.isEmpty()){
            System.out.println("0");
        }
        else{
            while(!queue.isEmpty()) {
                int temp = queue.remove();
                if(temp<min){
                    min = temp;
                }
            }
            System.out.println(min);
        }
    }
}
