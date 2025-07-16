package zairastra.u5w1d3;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import zairastra.u5w1d3.entities.Menu;
import zairastra.u5w1d3.entities.Order;
import zairastra.u5w1d3.entities.Table;
import zairastra.u5w1d3.entities.enums.OrderStatus;

import java.time.LocalTime;
import java.util.List;


@Component
public class MyRunner implements CommandLineRunner {

    private final Menu menu;
    private final double coverCharge;
    private final Table t1;
    private Order order;

    //devo fare l'injection del tavolo nell'ordine, così posso anche usare il setTable ch emi cambia lo stato del tavolo in occupato
    public MyRunner(Menu menu, @Value("${cover.charge}") double coverCharge, @Qualifier("t1") Table t1) {
        this.menu = menu;
        this.coverCharge = coverCharge;
        this.t1 = t1;
    }

    //RICORDATI LA NOTAZIONE PER PORTARTI IL VALORE DEL COPERTO - @Value("${admin.name}"
    //E RICORDATI DI NON USARE IL ; IN application.properties

    //creo l'ordine
//    private void createOrder() {
//        order = new Order(1, OrderStatus.READY, 3, LocalTime.of(13, 3), List.of(pizzaSalamiXlBean(), pizzaHawaiianBean(), pizzaMargheritaBean(), toppingHamBean(), toppingCheeseBean(), lemonadeBean(), lemonadeBean(), wineBean()), null);
//        o1.setTable(t1());
//    }
    //devo passare da Menu per accedere agli elementi in List<Menu>, va riscritto completamente
    private void createOrder() {
        order = new Order(1, OrderStatus.READY, 3, LocalTime.of(13, 3), List.of(menu.getPizzaList().get(3), menu.getPizzaList().get(1), menu.getPizzaList().get(0), menu.getToppingList().get(2), menu.getToppingList().get(1), menu.getDrinkList().get(0), menu.getDrinkList().get(0), menu.getDrinkList().get(2)), null);
        order.setTable(t1);
    }

    public void printOrder() {
        System.out.println(order.toString());
    }

    public void printBill() {
        System.out.println(order.calcBill(coverCharge));
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Welcome to our restaurant - choose your meal!");
        menu.printMenu();
        //ora che non viene più creato da solo devi aggiungere il metodo -NullPointerException
        createOrder();
        System.out.println("This is your order: ");
        printOrder();
        System.out.println("This is your bill: ");
        printBill();
    }
}
