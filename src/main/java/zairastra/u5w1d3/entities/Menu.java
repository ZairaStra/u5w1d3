package zairastra.u5w1d3.entities;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//in Menu ho un metodo che stampa una lista di pizze, una di topping e una di drink
//come diceva Riccardo ieri volendo si poteva fare una lista unica di Item e avrebbe funzionato comunque
//grazie al polimorfismo - tutti discendono da Item
//così però la stampa è più ordinata
@Getter
@ToString
//essendo Menu un Component, devo iniettare le liste
//lo faccio tramite costruttore settato a mano
//@NoArgsConstructor
//@AllArgsConstructor
//poteva essere un @Component
@Component
public class Menu {
    private List<Pizza> pizzaList;
    private List<Drink> drinkList;
    private List<Topping> toppingList;

    @Autowired
    public Menu(List<Pizza> pizzaList, List<Drink> drinkList, List<Topping> toppingList) {
        this.pizzaList = pizzaList;
        this.drinkList = drinkList;
        this.toppingList = toppingList;
    }

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
