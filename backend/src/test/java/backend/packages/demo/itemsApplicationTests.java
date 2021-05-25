package backend.packages.demo;
import backend.packages.Beans.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class itemsApplicationTests {

    private static final String baseURL = "http://localhost:8093/items";
    private RestTemplate restTemplate = new RestTemplate();


    @Test
    public void testAddItem() {
        for (int i = 0; i < 2; i++) {
            Long itemNumber = (long) (Math.random() * 999);
            int amount = (int) (Math.random() * 200);
            long inventoryCode = (long) (Math.random() * 999999);
            Item item = new Item(itemNumber ,"item " + itemNumber, amount, inventoryCode);
            this.restTemplate.postForObject(baseURL + "", item, Void.class);
            System.out.println("item" + itemNumber + " was added successfully");
        }
    }

    @Test
    public void getItemDetails() throws Exception {
        BigInteger ItemID = new BigInteger("29919751807496167075322599056");
        ResponseEntity<Item> response = this.restTemplate.getForEntity(baseURL + "/"+ItemID, Item.class);
        Item item = response.getBody();
        if(item==null)
            throw new Exception("Item id doesn't Exist.");
        System.out.println("Got Item" + ItemID + " Successfully:" + '\n' + item.toString());
    }

    @Test
    public void deleteItem(){
        BigInteger deletedItemID = new BigInteger("29919708344745815054630613433");
        this.restTemplate.delete(baseURL + "/" + deletedItemID);
        System.out.println("item with id: " + deletedItemID + " deleted successfully");
    }

    @Test
    public void updateQuantity(){
        BigInteger updatedItemID = new BigInteger("29919751807496167075322599056");
        Item updatedItem = new Item();
        int itemNumber = (int) (Math.random() * 5);
        int amount = (int) (Math.random() * 150 - 90);
        this.restTemplate.put(baseURL + "/" + updatedItemID + "/" +  amount, updatedItem );
        if(amount>=0)
            System.out.println("Item" + itemNumber + " amount was deposited with: " + amount);
        else
            System.out.println("Item" + itemNumber + " amount was withdraw with: " + amount);
    }

    @Test
    public void getAllItems(){
        ResponseEntity<Item[]> response= this.restTemplate.getForEntity(baseURL, Item[].class);
        for (Item i : response.getBody()) {
            System.out.println(i.toString() + '\n');
        }
    }

//    @Test
//    public void deleteAllItems(){
//        ResponseEntity<Item[]> response = this.restTemplate.getForEntity(baseURL, Item[].class);
//        List<Item> itemList = Arrays.asList(response.getBody());
//        for (Item i : itemList) {
//            this.restTemplate.delete(baseURL+'/'+i.getId());
//        }
//        System.out.println("Items deleted Successfully");
//    }

}
