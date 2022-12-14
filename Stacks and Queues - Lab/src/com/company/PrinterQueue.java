package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        ArrayDeque<String> printerQueue = new ArrayDeque<>();
        while(!fileName.equals("print")){
            if(fileName.equals("cancel")){
                if(printerQueue.isEmpty()){
                    System.out.println("Printer is on standby");
                    fileName = scanner.nextLine();
                    continue;
                }
                else{
                    String firstInQueue = printerQueue.pollFirst();
                    System.out.println("Canceled " + firstInQueue);
                }
            }
            else{
                printerQueue.offer(fileName);
            }
            fileName = scanner.nextLine();
        }
        while (!printerQueue.isEmpty()){
            System.out.println(printerQueue.poll());
        }
    }
}
