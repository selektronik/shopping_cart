package guru.springframework.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import guru.springframework.domain.Category;
import guru.springframework.domain.Product;


public interface ProductRepository extends MongoRepository<Product, Integer> {
	
	
	Product findByName(String name);
	List<Product> findByCategories(String id);
	
	
	
}
