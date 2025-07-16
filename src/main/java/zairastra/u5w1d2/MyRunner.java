package zairastra.u5w1d2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import zairastra.u5w1d2.entities.Menu;
import zairastra.u5w1d2.entities.Order;

@Component
public class MyRunner implements CommandLineRunner {

    private final Menu menu;
    private final Order order;
    private final double coverCharge;

    //RICORDATI LA NOTAZIONE PER PORTARTI IL VALORE DEL COPERTO - @Value("${admin.name}"
    //E RICORDATI DI NON USARE IL ; IN application.properties

    public MyRunner(Menu menu, Order order, @Value("${cover.charge}") double coverCharge) {
        this.menu = menu;
        this.order = order;
        this.coverCharge = coverCharge;
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
        System.out.println("This is your order: ");
        printOrder();
        System.out.println("This is your bill: ");
        printBill();
    }
}
