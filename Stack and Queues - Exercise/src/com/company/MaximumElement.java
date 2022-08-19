package com.company;

import java.util.*;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int command = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        List<Integer> maximum = new ArrayList<>();
        while(command!=0) {
            int max = Integer.MIN_VALUE;
            int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if(numbers[0] == 1){
                stack.push(numbers[1]);
                maximum.add(numbers[1]);
                command--;
            }
            else if(numbers[0] == 2){
                stack.pop();
                maximum.remove(maximum.size() - 1);
                command--;
            }
            else if(numbers[0] == 3){
                for (Integer integer : maximum) {
                    if (integer > max) {
                        max = integer;
                    }
                }
                System.out.println(max);
                command--;
            }
        }

    }
}
