package com.company;

import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] data = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Set<String> set1 = new LinkedHashSet<>();
        Set<String> set2 = new LinkedHashSet<>();

        int set1Size = data[0];
        for (int i = 0; i < set1Size; i++) {
            String input = scanner.nextLine();
            set1.add(input);
        }

        int set2Size = data[1];
        for (int i = 0; i < set2Size; i++) {
            String input = scanner.nextLine();
            set2.add(input);
        }

        set1.retainAll(set2);

        System.out.print(String.join(" ", set1));

    }
}

//        int firstNumber ;
//        int secondNumber ;
//       for (int i = 0; i < set1.size(); i++) {
//          for (int j = 0; j < set2.size(); j++) {
//               Iterator<Integer> firstIterator = set1.iterator();
//               firstNumber = firstIterator.next();
//
//               Iterator<Integer> secondIterator = set2.iterator();
//                secondNumber = secondIterator.next();
/////               if(firstNumber==secondNumber){
//                    commonSet.add(firstNumber);//               }
//            }
//       }