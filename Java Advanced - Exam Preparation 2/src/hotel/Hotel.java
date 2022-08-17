package hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel {

    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person){
        if(this.roster.size() < this.capacity){
            this.roster.add(person);
        }
    }

    public boolean remove(String name){
        return roster.removeIf(person -> person.getName().equals(name));
    }

    public int getCount(){
        return this.roster.size();
    }

    public Person getPerson(String name, String hometown){
        for(Person person : roster){
            if(name.equals(person.getName()) && hometown.equals(person.getHometown())){
                return person;
            }
        }
        return null;
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The people in the hotel %s are:%n", this.name));
        for (Person person : roster) {
            sb.append(String.format("%s%n", person.toString()));
        }
        return sb.toString();
    }
}
