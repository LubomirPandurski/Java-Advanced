package CarSalesman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int enginesCount = Integer.parseInt(scanner.nextLine());
        while (enginesCount-->0){
            String [] data = scanner.nextLine().split(" ");
            String engineModel = data[0];
            int power = Integer.parseInt(data[1]);
            Engine engine = null;
            switch (data.length){
                case 2:
                    engine = new Engine(engineModel, power);
                    break;
                case 3:
                    if (data[2].matches("\\d+")) {
                        String displacement = data[2];
                        ;
                    } else {
                        String efficiency = data[2];

                    }
                    break;
                case 4:
                    String displacement = data[2];
                    String efficiency = data[3];

                    break;
            }
        }

        int carsCount = Integer.parseInt(scanner.nextLine());
        while (carsCount-->0){

        }
    }
}
