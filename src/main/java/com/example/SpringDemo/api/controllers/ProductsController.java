package com.example.SpringDemo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringDemo.Entities.concretes.Product;
import com.example.SpringDemo.Entities.dtos.ProductWithCategoryDto;
import com.example.SpringDemo.business.abstracts.ProductService;
import com.example.SpringDemo.core.utilities.results.DataResult;
import com.example.SpringDemo.core.utilities.results.Result;

@RestController
@RequestMapping("/api/products")
@CrossOrigin //Reacta izin verir.
public class ProductsController {
	
	// İnjection yapacağız.
	private ProductService productService;
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}
	// ===============================================================================
	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}
	// ===============================================================================
	@PostMapping("/add")
	public Result add(@RequestBody Product product){
		// productService'in add metoduna product nesnesi gönderir.
		return this.productService.add(product);
	}
	// ===============================================================================
	// Kullanıcıdan alınan bilgi burada productName ismi ile parametre olarak gelecek.
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){ 
		return this.productService.getByProductName(productName);
	}
	// ===============================================================================
	@GetMapping("/getByProductNameAndCategory")
	public DataResult<Product> getByProductNameAndCategory
	(@RequestParam String productName,@RequestParam int categoryId){
		return this.productService.getByProductNameAndCategory(productName,categoryId);
	}
	// ===============================================================================
	@GetMapping("/getByProductNameOrCategory")
	public DataResult<List<Product>> getByProductNameOrCategory(@RequestParam String productName,@RequestParam int categoryId){
		return this.productService.getByProductNameOrCategory(productName,categoryId);
	}
	// ===============================================================================
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);
	}
	// ===============================================================================
	@GetMapping("/getAllByPage")
	public DataResult<List<Product>> getAll(int pageNo, int pageSize){
		
		return this.productService.getAll(pageNo, pageSize);
	}
	// ===============================================================================
	@GetMapping("/getAllDesc") // Tersten sıralar.
	public DataResult<List<Product>> getAllSorted(){
		return this.productService.getAllSorted();
	}
	// ===============================================================================
	// DTO için;
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
		return this.productService.getProductWithCategoryDetails();
	}
	
	
	// ===============================================================================
	// Sayfalama için
	
	// ===============================================================================
	//@GetMapping("/getByCategoryIn")
	//public DataResult<List<Product>> getByCategoryIn(@RequestParam List<Integer> categories){
	//	return this.productService.getByCategoryIn(categories);
	//}
	// ===============================================================================
	
	
	
	
	
	
	
}
