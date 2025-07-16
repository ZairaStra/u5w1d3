package zairastra.u5w1d2.entities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import zairastra.u5w1d2.entities.enums.OrderStatus;
import zairastra.u5w1d2.entities.enums.TableStatus;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("application.properties")
public class AppConfig {

    //aggiungo i tavoli come Beans
    @Bean(name = "t1")
    public Table t1() {
        return new Table(1, 10, TableStatus.AVAILABLE);
    }

    @Bean(name = "t2")
    public Table t2() {
        return new Table(2, 6, TableStatus.AVAILABLE);
    }

    @Bean(name = "t3")
    public Table t3() {
        return new Table(3, 4, TableStatus.OCCUPIED);
    }

    @Bean(name = "t4")
    public Table t4() {
        return new Table(4, 6, TableStatus.AVAILABLE);
    }

    //non posso fare injection del settable qui?
    @Bean(name = "o1")
    @Primary
    public Order o1() {
        return new Order(1, OrderStatus.READY, 3, LocalTime.of(13, 3), List.of(pizzaSalamiXlBean(), pizzaHawaiianBean(), pizzaMargheritaBean(), toppingHamBean(), toppingCheeseBean(), lemonadeBean(), lemonadeBean(), wineBean()), t1());
    }

    @Bean(name = "o2")
    public Order o2() {
        return new Order(2, OrderStatus.WORK_IN_PROGRESS, 2, LocalTime.of(14, 30), List.of(pizzaMargheritaBean(), pizzaSalamiBean(), toppingPineappleBean(), lemonadeBean(), waterBean()), t2());
    }


    @Bean(name = "toppings_tomato")
    public Topping toppingTomatoBean() {
        return new Topping("Tomato", 0, 0);
    }

    @Bean(name = "toppings_cheese")
    public Topping toppingCheeseBean() {
        return new Topping("Cheese", 92, 0.69);
    }

    @Bean(name = "toppings_ham")
    public Topping toppingHamBean() {
        return new Topping("Ham", 35, 0.99);
    }

    @Bean(name = "toppings_pineapple")
    public Topping toppingPineappleBean() {
        return new Topping("Pineapple", 24, 0.79);
    }

    @Bean(name = "toppings_salami")
    public Topping toppingSalamiBean() {
        return new Topping("Salami", 86, 0.99);
    }


    @Bean(name = "pizza_margherita")
    public Pizza pizzaMargheritaBean() {
        List<Topping> tList = new ArrayList<>();
        tList.add(toppingTomatoBean());
        tList.add(toppingCheeseBean());
        return new Pizza("Pizza Margherita", tList, false);
    }

    @Bean(name = "hawaiian_pizza")
    public Pizza pizzaHawaiianBean() {
        List<Topping> tList = new ArrayList<>();
        tList.add(toppingTomatoBean());
        tList.add(toppingCheeseBean());
        tList.add(toppingHamBean());
        tList.add(toppingPineappleBean());
        return new Pizza("Hawaiian Pizza", tList, false);
    }

    @Bean(name = "salami_pizza")
    public Pizza pizzaSalamiBean() {
        List<Topping> tList = new ArrayList<>();
        tList.add(toppingTomatoBean());
        tList.add(toppingCheeseBean());
        tList.add(toppingSalamiBean());
        return new Pizza("Salami Pizza", tList, false);
    }

    @Bean(name = "salami_pizza_xl")
    public Pizza pizzaSalamiXlBean() {
        List<Topping> tList = new ArrayList<>();
        tList.add(toppingTomatoBean());
        tList.add(toppingCheeseBean());
        tList.add(toppingSalamiBean());
        return new Pizza("Salami Pizza XL", tList, true);
    }

    @Bean(name = "lemonade")
    public Drink lemonadeBean() {
        return new Drink("Lemonade", 128, 1.29);
    }

    @Bean(name = "water")
    public Drink waterBean() {
        return new Drink("Water", 0, 1.29);
    }

    @Bean(name = "wine")
    public Drink wineBean() {
        return new Drink("Wine", 607, 7.49);
    }

    @Bean(name = "menu")
    public Menu menuBean() {
        List<Pizza> pizzaList = new ArrayList<>();
        List<Drink> drinkList = new ArrayList<>();
        List<Topping> toppingsList = new ArrayList<>();

        pizzaList.add(pizzaMargheritaBean());
        pizzaList.add(pizzaHawaiianBean());
        pizzaList.add(pizzaSalamiBean());
        pizzaList.add(pizzaSalamiXlBean());

        drinkList.add(lemonadeBean());
        drinkList.add(waterBean());
        drinkList.add(wineBean());

        toppingsList.add(toppingTomatoBean());
        toppingsList.add(toppingCheeseBean());
        toppingsList.add(toppingSalamiBean());
        toppingsList.add(toppingHamBean());
        toppingsList.add(toppingPineappleBean());

        return new Menu(pizzaList, drinkList, toppingsList);
    }
}
