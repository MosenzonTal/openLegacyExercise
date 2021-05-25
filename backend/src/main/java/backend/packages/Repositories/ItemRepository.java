package backend.packages.Repositories;
import backend.packages.Beans.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
//for H2: public interface ItemRepository extends CrudRepository<Item, Long>
public interface ItemRepository extends MongoRepository<Item, Long> {
    boolean existsItemByName(String name);
    Optional<Item> findById(BigInteger id);
    void deleteById(BigInteger id);
    boolean existsById(BigInteger id);
}
