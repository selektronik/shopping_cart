package guru.springframework.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import guru.springframework.domain.Category;
import guru.springframework.domain.Product;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.ProductRepository;



@Controller
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductRepository productRepository;
	
/*
	@RequestMapping("/categories")
    public String showCategoriesPage() {
    	
    	return "home";
    }
    */
	@RequestMapping(method = RequestMethod.GET)
	 public ModelAndView categories() {
		
		List<Category> categoryList = categoryRepository.findAll();
		
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("categoryList", categoryList);
	        return modelAndView;
	    }
	
	@RequestMapping(value="/sidebar", method=RequestMethod.GET)
	 public ModelAndView sidebar() {
		
		ModelAndView modelAndView = new ModelAndView("sidebar");
	        return modelAndView;
	    }
	
    /*
    @RequestMapping(value="/{categoryName}", method=RequestMethod.GET)
    public ResponseEntity<List<Product>> getProductsByCategoryNames(@PathVariable("categoryName") String categoryName){
    	System.out.println("categoryName: " + categoryName);
        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }
    */
	 
	 @RequestMapping(value="/{categoryName}",method=RequestMethod.GET)
	    public ModelAndView getProductsByCategoryName (@PathVariable String categoryName){
		 
		//  List<Product> productList = productRepository.findByCategories(categoryName);
		 Category category = categoryRepository.findByName(categoryName); 
		 String id= category.getId();
	     
		  List<Product> productList = productRepository.findByCategories(id);
	    	ModelAndView modelAndView = new ModelAndView("hardware");
			modelAndView.addObject("productList", productList);
		        
		        return modelAndView;
		    }
	 
	
	
    @RequestMapping(value="/home/{id}", method=RequestMethod.GET)
    public ResponseEntity<String> getPerson(@PathVariable Long id){
    	List<String> catList=new ArrayList<String>();
    	List<String> catList2=new ArrayList<String>();
    	List<String> catList3=new ArrayList<String>();
    	List<String> catList4=new ArrayList<String>();
    	List<String> catList5=new ArrayList<String>();
    	
    	    	
    	Category cat1=new Category("1", "Hardware",null);
    	Category cat2=new Category("2", "Software",null);
    	Category cat3=new Category("3", "Movies",null);
    	Category cat4=new Category("4", "Monitor","1");
    	Category cat5=new Category("5", "Printer","1");
    	Category cat6=new Category("6", "Antivirus","2");
    	Category cat7=new Category("7", "Animation","3");
    	Category cat8=new Category("8", "Science Fiction","3");
    	
    	
    	
    	catList.add(cat1.getId());
    	catList.add(cat4.getId());
    	catList2.add(cat1.getId());
    	catList2.add(cat5.getId());
    	catList3.add(cat2.getId());
    	catList3.add(cat6.getId());
    	catList4.add(cat3.getId());
    	catList4.add(cat7.getId());
    	catList5.add(cat3.getId());
    	catList5.add(cat8.getId());
    	
    	
    	Product pro1=new Product("1", "LG22AU", catList, "LG22AU.jpg", "220,50 TL" );
    	Product pro2=new Product("2", "Sony Vaio", catList, "SonyVaio.jpg", "1220,50 TL" );
    	Product pro3=new Product("3", "XEROX", catList2, "XEROX.jpg", "2203,50 TL" );
    	Product pro4=new Product("4", "HP", catList2, "HP.jpg", "3220,50 TL" );
    	Product pro5=new Product("5", "Avast", catList3, "Avast.jpg", "6220,50 TL" );
    	Product pro6=new Product("6", "Ice AGE", catList4, "IceAGE.jpg", "2220,50 TL" );
    	Product pro7=new Product("7", "Avatar", catList5, "Avatar.jpg", "4220,50 TL" );
    	
    	
    	    	
    	categoryRepository.save(cat1);
    	categoryRepository.save(cat2);
    	categoryRepository.save(cat3);
    	categoryRepository.save(cat4);
    	categoryRepository.save(cat5);
    	categoryRepository.save(cat6);
    	categoryRepository.save(cat7);
    	categoryRepository.save(cat8);
    	
    	 	
    	
    	productRepository.save(pro1);
    	productRepository.save(pro2);
    	productRepository.save(pro3);
    	productRepository.save(pro4);
    	productRepository.save(pro5);
    	productRepository.save(pro6);
    	productRepository.save(pro7);
        return new ResponseEntity<String>("selam", HttpStatus.OK);
    }
    
    @RequestMapping(value="/cateList/", method=RequestMethod.GET)
    public ResponseEntity<List<Category>> getCategories(){
    	
        return new ResponseEntity<>(categoryRepository.findAll(), HttpStatus.OK);
    }
    
    @RequestMapping(value="/proListByCatId/", method=RequestMethod.GET)
    public ResponseEntity<List<Product>> getProducts(){
    
        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }
    
    
    @RequestMapping(value="/categoryById/{id}", method=RequestMethod.GET)
    public ResponseEntity<Category> getCategory(@PathVariable String id){
    
        return new ResponseEntity<Category>(categoryRepository.findById(id), HttpStatus.OK);
    }
    
    @RequestMapping(value="/productsByCategoryId/{id}", method=RequestMethod.GET)
    public ResponseEntity<List<Product>> getProductsByCategoryId(@PathVariable String id){
        List<String> categories=new ArrayList<String>();
        categories.add(id);
        return new ResponseEntity<List<Product>>(productRepository.findByCategories(id), HttpStatus.OK);
    }
    
    
	
}
