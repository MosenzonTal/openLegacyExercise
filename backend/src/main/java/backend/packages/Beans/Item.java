package backend.packages.Beans;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
//@Table(name="items")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue
    private Long item_number; // to check if i need ID
    private String name;
    private Integer amount;
    private Long inventoryCode;

    public Item(String name, int amount, long inventoryCode) {
        this.name=name;
        this.amount=amount;
        this.inventoryCode=inventoryCode;
    }
}
