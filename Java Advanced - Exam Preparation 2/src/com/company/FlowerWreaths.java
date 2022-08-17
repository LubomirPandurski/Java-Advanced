package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;


public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(liliesStack::push);

        ArrayDeque<Integer> rosesQueue= new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(rosesQueue::offer);

        int wreathCount = 0;

        int otherFlowers = 0;

        while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()){
            int lily = liliesStack.pop();
            int rose = rosesQueue.poll();

            int sum = lily + rose;

            while (sum > 15){
                lily -=2;
                sum = lily + rose;
            }

            if(sum == 15){
                wreathCount++;
            } else  if (sum < 15){
                otherFlowers += sum;
            }
        }

        int leftWreaths = otherFlowers / 15;
        wreathCount += leftWreaths;
        if(wreathCount >=5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreathCount);
        }
        else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreathCount);
        }
    }
}
