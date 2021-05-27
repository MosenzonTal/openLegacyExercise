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

//    @Bean
//    CommandLineRunner commandLineRunner(ItemRepository itemRepository){
//        return strings -> {
//            itemRepository.save(new Item(1L,"Sony PlayStation 5",15,123372));
//            itemRepository.save(new Item(2L,"xBox 360",87,127923));
//            itemRepository.save(new Item(3L,"Fifa21",17,230223));
//            itemRepository.save(new Item(4L,"Lenovo thinkPad",23,120111));
//            itemRepository.save(new Item(5L,"LG 17'screen",2,750233));
//        };
//    }

}
