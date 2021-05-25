package backend.packages.config;
import backend.packages.Beans.Item;
import backend.packages.Repositories.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = ItemRepository.class )
@Configuration
public class MongoDBConfig {

    @Bean
    CommandLineRunner commandLineRunner(ItemRepository itemRepository){
        return strings -> {
            itemRepository.save(new Item(1L,"Sony PlayStation 5",15,123372));
            itemRepository.save(new Item(2L,"xBox 360",87,127923));
            itemRepository.save(new Item(3L,"Lenovo thinkPad",17,120223));
        };
    }

}
