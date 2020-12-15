package christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String name, int capacity) {
        this.color = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return this.color;
    }

    public int getCapacity() {
        return this.capacity;
    }


    public int count(){

        return this.data.size();
    }

    public void add(Present present){

        if (this.count() < this.capacity){
            this.data.add(present);
        }
    }

    public boolean remove(String name){

        Present present = null;

        for (Present datum : this.data) {
            if (datum.getName().equals(name)) {
                present =datum;
            }
        }

        boolean isRemove = this.data.remove(present);

        return isRemove;
    }


    public Present heaviestPresent(){

        Present present = this.data.stream()

                .sorted((p1,p2) -> Double.compare(p2.getWeight(),p1.getWeight()))
                .findFirst()
                .orElse(null);

        return present;
    }

    public Present getPresent(String name){

        Present present = this.data
                .stream()
                .filter(a ->a.getName().equals(name))
                .findFirst()
                .orElse(null);

        return present;
    }

    public String report(){

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s bag contains:",this.color))
                .append(System.lineSeparator());

        for (Present datum : this.data) {
            sb.append(datum)
                    .append(System.lineSeparator());
        }

            return sb.toString().trim();


    }


}
