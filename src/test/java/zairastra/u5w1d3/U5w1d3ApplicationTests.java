package zairastra.u5w1d3;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class U5w1d3ApplicationTests {

    @Test
    void totalCoverCharge() {
        System.out.println("TEST 1: verifico che il calcolo del costo totale dei coperti sia corretto");
        double coverCharge = 2.5;
        double fakeCoverNumb = 3;

        double result = coverCharge * fakeCoverNumb;
        assertEquals(7.5, result);
    }

}
