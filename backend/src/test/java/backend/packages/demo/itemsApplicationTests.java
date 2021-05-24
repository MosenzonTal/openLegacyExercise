package backend.packages.demo;

import backend.packages.Beans.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class itemsApplicationTests {

    private static final String baseURL = "http://localhost:8080/items";
    private RestTemplate restTemplate = new RestTemplate();


    @Test
    public void testAddItem() {
        for (int i = 0; i < 10; i++) {
            Item item = new Item("item " + i, (int) (Math.random() * 200), (long) (Math.random() * 999999));
            this.restTemplate.postForObject(baseURL + "", item, Void.class);
            System.out.println("item" + i + " was added successfully");
        }
    }

    @Test
    public void getItemDetails() throws Exception {
        int itemNumber=(int) (Math.random() * 15);
        ResponseEntity<Item> response = this.restTemplate.getForEntity(baseURL + "/"+itemNumber, Item.class);
        Item item = response.getBody();
        if(item==null)
            throw new Exception("Item id doesn't Exist.");
        System.out.println("Got Item" + itemNumber + " Successfully:" + '\n' + item.toString());
    }

    @Test
    public void deleteItem(){
        int deletedItemNumber = (int) (Math.random() * 15);
       this.restTemplate.delete(baseURL + "/"+ deletedItemNumber);
        System.out.println("item" + deletedItemNumber + " deleted successfully");
    }

    @Test
    public void updateQuantity(){
        Item updatedItem = new Item();
        int itemNumber = (int) (Math.random() * 15);
        int amount = (int) (Math.random() * 150 - 90);
        this.restTemplate.put(baseURL + "/" + itemNumber + "/" +  amount, updatedItem );
        System.out.println("Item" + itemNumber + " amount was updated in: " + amount);
    }

}
