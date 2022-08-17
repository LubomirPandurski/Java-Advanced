package dealership;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Dealership {

    public String name;
    public int capacity;
    Collection<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car){
        if(this.data.size() < this.capacity){
            data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model){
        return data.removeIf(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model));
    }

    public Car getLatestCar() {
        if(data.size() > 0){
            int newestCar = Integer.MIN_VALUE;
            int index = -1;
            List<Car> carList = new ArrayList<>();
            carList.addAll(data);
            for (int i = 0; i < carList.size(); i++) {
                if (carList.get(i).getYear() >= newestCar) {
                    index = i;
                    newestCar= carList.get(i).getYear();
                }
            }
            return carList.get(index);
        }
        return null;
    }

    public Car getCar(String manufacturer, String model) {
        for (Car car : data) {
            if (manufacturer.equals(car.getManufacturer()) && model.equals(car.getModel())) {
                return car;
            }
        }
        return null;
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are in a car dealership %s:%n", this.name));
        for (Car car : data) {
            sb.append(String.format("%s%n", car.toString()));
        }
        return sb.toString();
    }
}
