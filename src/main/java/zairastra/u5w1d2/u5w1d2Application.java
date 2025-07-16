package zairastra.u5w1d2;

//visto che nell'esercitazione precedente avevo cannato tutto sono partita dalla soluzione,
//creando un nuovo progetto e integrando i file

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zairastra.u5w1d2.entities.Menu;

@SpringBootApplication
@Slf4j//cos'è????
public class u5w1d2Application {

    public static void main(String[] args) {
        SpringApplication.run(u5w1d2Application.class, args);

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(u5w1d2Application.class);

        Menu m = (Menu) ctx.getBean("menu");

        m.printMenu();
        ctx.close();
    }

}
