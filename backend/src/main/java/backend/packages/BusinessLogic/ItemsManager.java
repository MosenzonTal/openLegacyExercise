package backend.packages.BusinessLogic;
import backend.packages.Beans.Item;
import backend.packages.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class ItemsManager {

    @Autowired
    ItemRepository itemRepo;

    public Optional<Item> getItemDetails(BigInteger id){
        Optional<Item> item = this.itemRepo.findById(id);
        return item;
    }

    public List<Item> getAllItems(){
        return this.itemRepo.findAll();
    }

    public void deleteItemFromStock(BigInteger id) throws Exception {
        if(!this.itemRepo.existsById(id))
            throw new Exception("id is not exist");
        this.itemRepo.deleteById(id);
    }

    public void addItemToStock(Item item) throws Exception {
        if(item.getName()==null || item.getAmount() ==null ||
                item.getItemNumber() == null || item.getInventoryCode() == null)
            throw new Exception("Item must contain the fields: Name, Amount, ItemNumber and InventoryCode");
        if(this.itemRepo.existsItemByName(item.getName()))
            throw new Exception("Item is already exists");
        this.itemRepo.save(item);
    }

    public void updateQuantity(BigInteger id, Integer quantity) throws Exception {
        if(!this.itemRepo.existsById(id))
            throw new Exception("Item id is not exist");
        Optional<Item> item = this.itemRepo.findById(id);
        item.get().setAmount(item.get().getAmount()+quantity);
        if(item.get().getAmount()<0)
            item.get().setAmount(0);
        this.itemRepo.save(item.get());
    }

}
