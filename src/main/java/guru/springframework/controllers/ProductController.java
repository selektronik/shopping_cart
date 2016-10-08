package guru.springframework.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import guru.springframework.domain.Category;
import guru.springframework.domain.Product;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.ProductRepository;



@Controller
public class ProductController {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	
	 @RequestMapping(value="/{categoryName}/products",method=RequestMethod.GET)
	    public ModelAndView products(@PathVariable String categoryName){
	    	
		 Category category = categoryRepository.findByName(categoryName); 
		 String id= category.getId();	    	
		 List<Product> productList = productRepository.findByCategories(id);
	    	ModelAndView modelAndView = new ModelAndView("hardware");
			modelAndView.addObject("productList", productList);
		        return modelAndView;
		    }
	 
	 
	 @RequestMapping(value="/{categoryName}",method=RequestMethod.GET)
	    public ModelAndView products2(@PathVariable String categoryName){
	    	
		 Category category = categoryRepository.findByName(categoryName); 
		 String id= category.getId();	    	
		 List<Product> productList = productRepository.findByCategories(id);
	    	ModelAndView modelAndView = new ModelAndView("hardware");
			modelAndView.addObject("productList", productList);
		        return modelAndView;
		    }
	   
	 @RequestMapping(value="/products",method=RequestMethod.GET)
	    public ModelAndView products(){
	    	
		
	     List<Product> productList = productRepository.findAll();
		
	    	ModelAndView modelAndView = new ModelAndView("hardware");
			modelAndView.addObject("productList", productList);
		        return modelAndView;
		    }
	 
	 @RequestMapping(value="/product/{productName}",method=RequestMethod.GET)
	    public ModelAndView productDetail(@PathVariable String productName){
	    	
		 Product product = productRepository.findByName(productName); 
		 
		 
	     
		
	    	ModelAndView modelAndView = new ModelAndView("productDetail");
			modelAndView.addObject("product", product);
		        return modelAndView;
		    }

	

}
