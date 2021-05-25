package backend.packages.Beans;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;
import java.math.BigInteger;

@Data
//@Table(name="items")
@AllArgsConstructor
@NoArgsConstructor
//@Entity
@Document
public class Item {

    @Id
    private BigInteger id;
    @Field
    private Long itemNumber;
    @Field
    private String name;
    @Field
    private Integer amount;
    @Field
    private Long inventoryCode;

    public Item(Long itemNumber, String name, int amount, long inventoryCode) {
        this.name=name;
        this.amount=amount;
        this.inventoryCode=inventoryCode;
        this.itemNumber=itemNumber;
    }
}
