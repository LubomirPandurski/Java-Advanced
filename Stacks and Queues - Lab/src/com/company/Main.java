package com.company;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.offer(42);
        queue.offer(13);
        queue.offer(73);
        queue.offer(69);

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
