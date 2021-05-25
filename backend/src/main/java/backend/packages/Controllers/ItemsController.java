package backend.packages.Controllers;
import backend.packages.Beans.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import backend.packages.BusinessLogic.ItemsManager;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("items")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ItemsController {

    @Autowired
    ItemsManager itemsManager;


    @GetMapping("")
    private ResponseEntity<List<Item>> getAllItems(){
        List<Item> allItems = this.itemsManager.getAllItems();
        return new ResponseEntity<List<Item>>(allItems,HttpStatus.OK);
//        return allItems;
    }

    @GetMapping("/{id}")
    private ResponseEntity<Optional<Item>> getItemDetails(@PathVariable BigInteger id){
        Optional<Item> item = this.itemsManager.getItemDetails(id);
       return new ResponseEntity<Optional<Item>>(item, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteItem(@PathVariable BigInteger id) throws Exception {
        this.itemsManager.deleteItemFromStock(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    @PostMapping("")
    private ResponseEntity<Void> addItem(@RequestBody Item item ) throws Exception {
        this.itemsManager.addItemToStock(item);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/{id}/{quantity}")
    private ResponseEntity<Void> updateQuantity(@PathVariable BigInteger id, @PathVariable Integer quantity) throws Exception {
        this.itemsManager.updateQuantity(id,quantity);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
