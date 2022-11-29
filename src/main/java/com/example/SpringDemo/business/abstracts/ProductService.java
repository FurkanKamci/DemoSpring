package com.example.SpringDemo.business.abstracts;

import java.util.List;

import com.example.SpringDemo.Entities.concretes.Product;
import com.example.SpringDemo.Entities.dtos.ProductWithCategoryDto;
import com.example.SpringDemo.core.utilities.results.DataResult;
import com.example.SpringDemo.core.utilities.results.Result;

public interface ProductService {
	// Tüm dataları listelemek için kullanılacak.
	DataResult<List<Product>> getAll();
	
	// Tüm dataları nasıl sıralamak istediğimizi belirtiriz.
	DataResult<List<Product>> getAllSorted();
	
	//Sayfa düzeni yapmak için kullanılacak.
	DataResult<List<Product>> getAll(int pageNo, int pageSize);
	
	// Yeni bir product nesnesi oluşturmak için kullanılacak.
	Result add(Product product);
	//
	//////////////////////////////////////////////
	DataResult<Product> getByProductName(String productName);
	////////////////////////////////////////////////
	DataResult<Product> getByProductNameAndCategory(String productName, int categoryId);
	////////////////////////////////////////////////// 
	DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId);
	//////////////////////////////////////////////////
	DataResult<List<Product>> getByCategoryIn(List<Integer> categories);
	//////////////////////////////////////////////////
	DataResult<List<Product>> getByProductNameContains(String productName);
	//////////////////////////////////////////////////
	DataResult<List<Product>> getByProductNameStartsWith(String productName);
	//////////////////////////////////////////////////
	DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
	
	// DTO örneği için
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
////////////////////////////////////////////////
}
