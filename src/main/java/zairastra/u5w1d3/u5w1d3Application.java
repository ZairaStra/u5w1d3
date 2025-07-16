package zairastra.u5w1d3;

//visto che nell'esercitazione precedente avevo cannato tutto sono partita dalla soluzione,
//creando un nuovo progetto e integrando i file

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
@Slf4j//cos'è????
public class u5w1d3Application {

    public static void main(String[] args) {
        SpringApplication.run(u5w1d3Application.class, args);

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(u5w1d3Application.class);

        //non serve più scrivere nell'application perchè è il runner che stampa
        //altrimenti stampa sotto il menu ancora una volta
//        Menu m = (Menu) ctx.getBean("menu");

//        m.printMenu();
        ctx.close();
    }

}
