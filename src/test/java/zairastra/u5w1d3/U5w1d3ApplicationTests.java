package zairastra.u5w1d3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class U5w1d3ApplicationTests {

//    @Test
//    void totalCoverCharge() {
//        System.out.println("TEST 1: verifico che il calcolo del costo totale dei coperti sia corretto");
//        double coverCharge = 2.5;
//        double fakeCoverNumb = 3;
//
//        double result = coverCharge * fakeCoverNumb;
//        assertEquals(7.5, result);
//    }

    //lo rendo multiparametrico: costo coperto, numero persone al tavolo, totale atteso
    //funziona sia per numeri giusti che sbagliati

    @ParameterizedTest
    @CsvSource({
            "2.5, 3, 7.5",
            "2.5, 4, 10",
            "2.5, 6, 15",
            "2.5, 10, 25"
    })
    void totalCoverCharge(double coverCharge, int fakeCoverNumb, double expectedResult) {
        double result = coverCharge * fakeCoverNumb;
        assertEquals(expectedResult, result);
    }

}
