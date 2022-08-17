package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Double> milkQuantity = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Double> cacaoPowder = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .forEach(cacaoPowder::push);

        Map<String, Integer> chocolatesMade = new TreeMap<>();
        chocolatesMade.put("Milk Chocolate", 0);
        chocolatesMade.put("Dark Chocolate", 0);
        chocolatesMade.put("Baking Chocolate", 0);

        while(!milkQuantity.isEmpty() && !cacaoPowder.isEmpty()) {
            Double lastIngredient = milkQuantity.peek();
            double cacaoPercentage = (cacaoPowder.peek() / (cacaoPowder.peek() + milkQuantity.peek()) * 100);

            String chocoladeType;
            switch ((int) cacaoPercentage) {
                case 30:
                    chocoladeType = "Milk Chocolate";
                    break;
                case 50:
                    chocoladeType = "Dark Chocolate";
                    break;
                case 100:
                    chocoladeType = "Baking Chocolate";
                    break;
                default:
                    chocoladeType = null;
                    break;
            }

            if(chocoladeType != null){
                int newVal = chocolatesMade.get(chocoladeType) + 1;
                chocolatesMade.put(chocoladeType, newVal);
                milkQuantity.poll();
                cacaoPowder.pop();
            }
            else{
                milkQuantity.poll();
                milkQuantity.offer(lastIngredient + 10);
                cacaoPowder.pop();
            }
        }
        boolean allChocolatesAreMade = chocolatesMade.entrySet().stream().allMatch(e -> e.getValue() > 0);

        if(allChocolatesAreMade){
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        }
        else{
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        chocolatesMade.entrySet()
                .stream().filter(e-> e.getValue() >0)
                .forEach(e->
                        System.out.println("# " + e.getKey() + " --> " + e.getValue()));
    }
}
// 0 60 70 140 150
// 150 60 30 60 100

// 25 100 70.0 20
// 20 30 0 50.5