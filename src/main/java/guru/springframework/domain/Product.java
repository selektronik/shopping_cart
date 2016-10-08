package guru.springframework.domain;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "Products")
public class Product {
private String id;
private String name;
private String price;
private String imageName;


private List<String> categories;

public Product(String id, String name, List<String> categories, String imageName, String price) {
	super();
	this.id = id;
	this.name = name;
	this.categories = categories;
	this.imageName =imageName;
	this.price = price;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public List<String> getCategories() {
	return categories;
}

public void setCategories(List<String> categories) {
	this.categories = categories;
}

public String getPrice() {
	return price;
}

public void setPrice(String price) {
	this.price = price;
}

public String getImageName() {
	return imageName;
}

public void setImageName(String imageName) {
	this.imageName = imageName;
}



}
