package com.example.SpringDemo.Entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	// Fields
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private int id;
	
	//@Column(name="category_id")
 	//private int categoryId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="unit_price")
	private double unitPrice;
	
	@Column(name="units_in_stock")
	private short unitsInStock;
	
	@Column(name="quantity_per_unit")
	private String quantityPerUnit;
	
	// Product'ın içerisinden category_id yi ilişkilendireceğiz.
	// Dikkat edilmesi gereken şey, 
	// Eğer Product da category_id için
	// Field varsa onu silmemiz gerekir.
	
	@ManyToOne()
	@JoinColumn(name="category_id")
	private Category category;
	
	// Buradan sonrasının tamamını Artık loombok yapacaktır. Bizim bunları eklememize gerek yok.
//	// Constructor Parametresiz
//	public Product() {}
//
//	// Constructor Parametreli
//	public Product(int id, int categoryId, String productName, double unitPrice, short unitsInStock,
//			String quantityPerUnit) {
//		super();
//		this.id = id;
//		this.categoryId = categoryId;
//		this.productName = productName;
//		this.unitPrice = unitPrice;
//		this.unitsInStock = unitsInStock;
//		this.quantityPerUnit = quantityPerUnit;
//	}
//
//	// Getter ve Setter metodları
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public int getCategoryId() {
//		return categoryId;
//	}
//
//	public void setCategoryId(int categoryId) {
//		this.categoryId = categoryId;
//	}
//
//	public String getProductName() {
//		return productName;
//	}
//
//	public void setProductName(String productName) {
//		this.productName = productName;
//	}
//
//	public double getUnitPrice() {
//		return unitPrice;
//	}
//
//	public void setUnitPrice(double unitPrice) {
//		this.unitPrice = unitPrice;
//	}
//
//	public short getUnitsInStock() {
//		return unitsInStock;
//	}
//
//	public void setUnitsInStock(short unitsInStock) {
//		this.unitsInStock = unitsInStock;
//	}
//
//	public String getQuantityPerUnit() {
//		return quantityPerUnit;
//	}
//
//	public void setQuantityPerUnit(String quantityPerUnit) {
//		this.quantityPerUnit = quantityPerUnit;
//	}
	
	
	
	
	
	

}
