package zairastra.u5w1d2.entities;


//crea una classe astratta Item da cui discendono tutti gli elementi nel menu

import lombok.Getter;

@Getter
public abstract class Item {

    protected int calories;
    protected double price;

    public Item(int calories, double price) {
        this.calories = calories;
        this.price = price;
    }

}
