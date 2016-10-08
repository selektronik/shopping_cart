package guru.springframework.domain;


import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;

@Document(collection = "Categories")
public class Category {
    
    private String id;
    
    private String parentId;
    private String name;
    
    
	public String getParentId() {
		return parentId;
	}


	public void setParentId(String parentId) {
		this.parentId = parentId;
	}


	private List<Product> productList;
    
	public Category(String id, String name,String parentId) {
		super();
		this.id = id;
		this.name = name;
		this.parentId=parentId;
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


	public List<Product> getProductList() {
		return productList;
	}


	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
      
    
}
