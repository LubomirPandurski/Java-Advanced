package com.CarInfo;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    public String getBrand(){
        return brand;
    }

    public void setBrand(String newBrand){
        brand = newBrand;
    }

    public String getModel(){
        return model;
    }

    public void setModel(String newModel){
        model = newModel;
    }

    public int getHorsePower(){
        return horsePower;
    }

    public void setHorsePower(int newHorsePower){
        horsePower = newHorsePower;
    }

    public String carInfo(){
        return String.format("The car is: %s %s - %d HP.",
                getBrand(),
                getModel(),
                getHorsePower());
    }
}
