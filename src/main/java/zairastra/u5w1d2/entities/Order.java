package zairastra.u5w1d2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import zairastra.u5w1d2.entities.enums.OrderStatus;
import zairastra.u5w1d2.entities.enums.TableStatus;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Order {
    private int orderNumb;
    private OrderStatus orderStatus;
    private int numbCovers;
    private LocalTime orderTime;
    private List<Item> items;
    //ovviamente non stiamo usando db, NON C'è UNA RELAZIONE, TONTA
    private Table table;

    //metodo per settare il tavolo OCCUPIED quando ho un ordine per esso
    //per fare in modo che questo metodo venga eseguito devo fare @Autowired sul setter???
    public void setTable(Table table) {
        this.table = table;
        if (table != null) {
            table.setStatus(TableStatus.OCCUPIED);
        }
    }

    //metodo per calcolare il totale compreso di coperto - application.properties - cover.charge
    public double calcBill(double coverCharge) {
        double itemsCost = items.stream().mapToDouble(Item::getPrice).sum();
        return itemsCost + (numbCovers * coverCharge);
    }


}
