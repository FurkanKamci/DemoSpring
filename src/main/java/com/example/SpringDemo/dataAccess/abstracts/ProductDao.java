package com.example.SpringDemo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.SpringDemo.Entities.concretes.Product;
import com.example.SpringDemo.Entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product, Integer>{
	
	// Aşağıdaki isimlendirme kurallarına uyduğumuz zaman
	// JpaRepository bize bunlar hazır olarak getirecektir.
	// select * from products where product_name = abc or(and) category_id=1 gibi 
	
	// Product İsmine göre getirmesini isteriz
	Product getByProductName(String productName);
	
	// Product ismine ve category id sine göre data getirmesini isteriz
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	
	// Product ismine veya category id sine göre data getirmesini isteriz. Liste olarak
	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
	
	// select * from products where category_id in(1,2,3,vs) gibi 
	List<Product> getByCategoryIn(List<Integer> categories);

	// Ürün ismine göre arama yapma
	List<Product> getByProductNameContains(String productName);
	
	// Ürün isimleri şununla başlayan
	List<Product> getByProductNameStartsWith(String productName);
	
	//Select * from products where product_name=bisey and categoryId=bisey
	@Query("From Product where productName=:productName and category.categoryId=:categoryId") // aşağıdaki parametre : ile alınır.
	List<Product> getByNameAndCategory(String productName, int categoryId);
	
	////////////////////////////////////////////////////////////////////////
	// DTO da bulunan class'ın metod ekleyelim.
	// DTO class'ı için 2 tablodaki bazı kolonları birleştirerek yeni tablo oluşturacak.
	
	// Tüm verilere ulaşmak için Liste döndürmemiz gerekmektedir. 
	
	// Join atmamız gerekmektedir. (OneToMany gitmek tavsiye ediliyor.)
	// select * from Category c inner join Product p
	// on c.categoryId = p.categoryId (Bu kısmı JPQL de yazmaya gerek yok.)
	@Query("Select new com.example.SpringDemo.Entities.dtos.ProductWithCategoryDto"
			+ "(p.id, p.productName, c.categoryName) "
			+ "From Category c Inner Join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails(); 
	

	
	
	
	
}
