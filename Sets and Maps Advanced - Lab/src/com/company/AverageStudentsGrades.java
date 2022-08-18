package com.company;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> gradeList = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            if(n==0){
                break;
            }
            String[] data = scanner.nextLine().split(" ");
            if(!gradeList.containsKey(data[0])){
                gradeList.put(data[0], new ArrayList<>());
                gradeList.get(data[0]).add(Double.valueOf(data[1]));
            }
            else{
                gradeList.get(data[0]).add(Double.valueOf(data[1]));
            }
        }

        gradeList.forEach((k, v) -> {
            double average;
            if(v.size() !=0) {
                System.out.printf("%s -> ", k);
                v.forEach(grade -> System.out.printf("%.2f ", grade));
                average = v.stream().mapToDouble(grade -> grade).sum();
                System.out.printf("(avg: %.2f)", average/v.size());
                System.out.println();

            }
        });

    }
}
