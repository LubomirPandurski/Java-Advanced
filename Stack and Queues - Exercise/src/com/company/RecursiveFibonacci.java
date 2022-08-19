package com.company;

import java.util.Scanner;

public class RecursiveFibonacci {
    static int n1 = 0, n2 = 1, n3 = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int result = getFibonacci(n);
        System.out.println(result);
    }

    private static int getFibonacci(int n) {
        if(n<2){
            return 1;
        }
        else{
            n3 = n2 + n1;
            n1 = n2;
            n2 = n3;
            getFibonacci(n - 1);
        }
        return n3;
    }
}
