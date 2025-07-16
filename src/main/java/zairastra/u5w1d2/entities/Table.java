package zairastra.u5w1d2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import zairastra.u5w1d2.entities.enums.TableStatus;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Table {
    private int tableNumb;
    private int maxCover;
    private TableStatus status;
}
