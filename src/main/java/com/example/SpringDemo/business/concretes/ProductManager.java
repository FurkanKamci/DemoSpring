 package com.example.SpringDemo.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.SpringDemo.Entities.concretes.Product;
import com.example.SpringDemo.Entities.dtos.ProductWithCategoryDto;
import com.example.SpringDemo.business.abstracts.ProductService;
import com.example.SpringDemo.core.utilities.results.DataResult;
import com.example.SpringDemo.core.utilities.results.Result;
import com.example.SpringDemo.core.utilities.results.SuccessDataResult;
import com.example.SpringDemo.core.utilities.results.SuccessResult;
import com.example.SpringDemo.dataAccess.abstracts.ProductDao;

@Service
public class ProductManager implements ProductService{

	// İnterface 'e injection ile bağlanır.
	private ProductDao productDao;
	// Constructor injection
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	// ===============================================================================
	@Override
	public DataResult<List<Product>> getAll() {
		// Gitti coredaki DataResult'un extend ettiği SuccessDataResult'un içerisindeki metodu getirdi.
		return new SuccessDataResult<List<Product>> (this.productDao.findAll(),"Data listelendi"); // Datası ve mesajı
	}
	// ===============================================================================

	@Override
	public Result add(Product product) {
		this.productDao.save(product); // Jpa'nın save metodunu kullanarak ekler
		return new SuccessResult("Ürün eklendi.");
	}
	// ===============================================================================
	// ===============================================================================
	@Override
	public DataResult<Product> getByProductName(String productName) {
		
		// Eğer business kodları olursa buraya yazılır. Örneğin şartlar için if kuralları
		return new SuccessDataResult<Product> (this.productDao.getByProductName(productName),"Data listelendi");
	}
	// ===============================================================================
	@Override
	public DataResult<Product> getByProductNameAndCategory(String productName, int categoryId) {
		
		// Eğer business kodları olursa buraya yazılır. Örneğin şartlar için if kuralları
		return new SuccessDataResult<Product> (this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data listelendi");
	}
	// ===============================================================================
	@Override
	public DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId) {
		
		return new SuccessDataResult<List<Product>> (this.productDao.getByProductNameOrCategory_CategoryId(productName,categoryId),"Data listelendi");
	}
	// ===============================================================================
	@Override
	public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
		
		return new SuccessDataResult<List<Product>> (this.productDao.getByCategoryIn(categories),"Data listelendi");
	}
	// ===============================================================================
	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		
		return new SuccessDataResult<List<Product>> (this.productDao.getByProductNameContains(productName),"Data listelendi");
	}
	// ===============================================================================
	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		
		return new SuccessDataResult<List<Product>> (this.productDao.getByProductNameStartsWith(productName),"Data listelendi");
	}
	// ===============================================================================
	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		
		return new SuccessDataResult<List<Product>> (this.productDao.getByNameAndCategory(productName,categoryId),"Data listelendi");
	}
	// ===============================================================================
	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<Product>> (this.productDao.findAll(pageable).getContent(),"Listelendi");
	}
	// ===============================================================================
	@Override
	public DataResult<List<Product>> getAllSorted() {

		Sort sort = Sort.by(Sort.Direction.DESC,"productName");
		return new SuccessDataResult<List<Product>> (this.productDao.findAll(sort),"Başarılı");
	}
	// ===============================================================================
	// DTO örneği için. İki tablodan kolonları çekerek tek tablo yapacak.
	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		
		return new SuccessDataResult<List<ProductWithCategoryDto>> (this.productDao.getProductWithCategoryDetails(),"Data listelendi");
	}
	// ===============================================================================
}
