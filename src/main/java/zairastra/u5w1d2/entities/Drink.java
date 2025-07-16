package zairastra.u5w1d2.entities;

import lombok.Getter;
import lombok.Setter;

//anche i Drink sono solo item con un nome
@Getter
@Setter
public class Drink extends Item {
    private String name;

    public Drink(String name, int calories, double price) {
        super(calories, price);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", price=" + price +
                '}';
    }
}
