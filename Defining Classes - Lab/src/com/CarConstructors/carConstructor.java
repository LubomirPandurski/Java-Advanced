package com.CarConstructors;

public class carConstructor {
    private String brand;
    private String model;
    private int horsePower;

    public carConstructor(String brand, String model, int horsePower){
       this.brand = brand;
       this.model = model;
       this.horsePower = horsePower;
   }

   public carConstructor(String brand){
       this(brand, "unknown", -1);
        this.brand = brand;
        this.model = "unknown";
        this.horsePower = -1;
    }


    public String carInfo(){
        return String.format("The car is: %s %s - %d HP.",
                brand,
                model,
                horsePower);
    }
}
