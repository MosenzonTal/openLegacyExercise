package backend.packages.BusinessLogic;

import backend.packages.Beans.Item;
import backend.packages.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemsManager {

    @Autowired
    ItemRepository itemRepo;

    public Optional<Item> getItemDetails(Long item_number){
        return this.itemRepo.findById(item_number);
    }

    public void deleteItemFromStock(Long item_number) throws Exception {
        if(!this.itemRepo.existsById(item_number))
            throw new Exception("Item id is not exist");
        this.itemRepo.deleteById(item_number);
    }

    public void addItemToStock(Item item){
        this.itemRepo.save(item);
    }

    public void updateQuantity(Long item_number, Integer quantity) throws Exception {
        if(!this.itemRepo.existsById(item_number))
            throw new Exception("Item id is not exist");
        Optional<Item> item = this.itemRepo.findById(item_number);
        item.get().setAmount(item.get().getAmount()+quantity);
        if(item.get().getAmount()<0)
            item.get().setAmount(0);
        this.itemRepo.save(item.get());
    }
}
