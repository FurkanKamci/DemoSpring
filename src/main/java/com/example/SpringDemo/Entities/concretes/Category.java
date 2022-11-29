package com.example.SpringDemo.Entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Categories")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
public class Category {
	
	@Id
	@Column(name="category_id")
	private int categoryId;
	
	@Column(name="category_name")
	private String categoryName;
	
	// Product listesini categories tablosu ile ilişkilendireceğiz.
	// 1 e 1 de OneToOne -> 1 kere tekrarlayabilir.
	// veya OneToMany kullanılır. 
	// Eğer Productan gelseydik ManyToOne olarak işaretleriz.
	@OneToMany(mappedBy="category")
	private List<Product> products;
}
