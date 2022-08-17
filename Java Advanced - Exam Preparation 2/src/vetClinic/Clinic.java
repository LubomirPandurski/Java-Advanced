package vetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {

    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet){
        if(this.data.size() < this.capacity){
            this.data.add(pet);
        }
    }

    public boolean remove(String name){
        return data.removeIf(pet -> pet.getName().equals(name));
    }

    public Pet getPet(String name, String owner){
        for(Pet pet : data){
            if(name.equals(pet.getName()) && owner.equals(pet.getOwner())){
                return pet;
            }
        }
        return null;
    }

 //  public Pet getOldestPet(){
 //      return data.stream().max(Comparator.comparing(Pet::getAge)).get();
 //  }

    public Pet getOldestPet() {
        int oldestAge = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < this.data.size();i++) {
            if (this.data.get(i).getAge() >= oldestAge) {
                index = i;
                oldestAge = this.data.get(i).getAge();
            }
        }
        return this.data.get(index);
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The clinic has the following patients:");
        sb.append(System.lineSeparator());
        for (Pet pets : data) {
            sb.append(String.format("%s %s%n", pets.getName(), pets.getOwner()));
        }
        return sb.toString();
    }
}
