package zairastra.u5w1d2.entities;

import lombok.Getter;
import lombok.Setter;

//tutti gli ingredienti che posso mettere su una base pizza sono qui - posso solo eventualemnte raddioppiarli o triplicarli
@Getter
@Setter

public class Topping extends Item {
    private String name;

    public Topping(String name, int calories, double price) {
        super(calories, price);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Topping{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", price=" + price +
                '}';
    }
}
