package zairastra.u5w1d2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

//in Menu ho un metodo che stampa una lista di pizze, una di topping e una di drink
//come diceva Riccardo ieri volendo si poteva fare una lista unica di Item e avrebbe funzionato comunque
//grazie al polimorfismo - tutti discendono da Item
//così però la stampa è più ordinata
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
//poteva essere un @Component
public class Menu {
    private List<Pizza> pizzaList;
    private List<Drink> drinkList;
    private List<Topping> toppingList;

    public void printMenu() {
        System.out.println("******* Menu *******");
        System.out.println("PIZZAS");
        this.pizzaList.forEach(System.out::println);
        System.out.println();

        System.out.println("TOPPINGS");
        this.toppingList.forEach(System.out::println);
        System.out.println();

        System.out.println("DRINKS");
        this.drinkList.forEach(System.out::println);
        System.out.println();

    }
}
