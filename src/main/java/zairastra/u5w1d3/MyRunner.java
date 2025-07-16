package zairastra.u5w1d3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import zairastra.u5w1d3.entities.Menu;
import zairastra.u5w1d3.entities.Order;

@Component
public class MyRunner implements CommandLineRunner {

    private final Menu menu;
    private final double coverCharge;
    private Order order;

    public MyRunner(Menu menu, @Value("${cover.charge}") double coverCharge) {
        this.menu = menu;
        this.coverCharge = coverCharge;
    }

    //RICORDATI LA NOTAZIONE PER PORTARTI IL VALORE DEL COPERTO - @Value("${admin.name}"
    //E RICORDATI DI NON USARE IL ; IN application.properties

    //creo l'ordine
//    private void createOrder() {
//        order = new Order(1, OrderStatus.READY, 3, LocalTime.of(13, 3), List.of(pizzaSalamiXlBean(), pizzaHawaiianBean(), pizzaMargheritaBean(), toppingHamBean(), toppingCheeseBean(), lemonadeBean(), lemonadeBean(), wineBean()), null);
//        o1.setTable(t1());
//    }
    //devo passare da Menu per accedere agli elementi in List<Menu>, va riscritto completamente


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
        System.out.println("This is your order: ");
        printOrder();
        System.out.println("This is your bill: ");
        printBill();
    }
}
