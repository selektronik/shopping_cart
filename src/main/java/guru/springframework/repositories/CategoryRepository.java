package guru.springframework.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import guru.springframework.domain.Category;


public interface CategoryRepository extends MongoRepository<Category, Integer> {
	
	Category findByName(String name);
	Category findById(String id);
	
	Category findCategoryByName(String name);
	

}
