package backend.packages.Controllers;
import backend.packages.Beans.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import backend.packages.BusinessLogic.ItemsManager;

import java.util.Optional;

@RequestMapping("items")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ItemsController {

    @Autowired
    ItemsManager itemsManager;

    @GetMapping("/{item_number}")
    private ResponseEntity<Optional<Item>> getItemDetails(@PathVariable Long item_number){
        Optional<Item> item = this.itemsManager.getItemDetails(item_number);
       return new ResponseEntity<Optional<Item>>(item, HttpStatus.OK);
    }

    @DeleteMapping("/{item_number}")
    private ResponseEntity<Void> deleteItem(@PathVariable Long item_number) throws Exception {
        this.itemsManager.deleteItemFromStock(item_number);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("")
    private ResponseEntity<Void> addItem(@RequestBody Item item ) throws Exception {
        this.itemsManager.addItemToStock(item);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/{item_number}/{quantity}")
    private ResponseEntity<Void> updateQuantity(@PathVariable Long item_number, @PathVariable Integer quantity) throws Exception {
        this.itemsManager.updateQuantity(item_number,quantity);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
