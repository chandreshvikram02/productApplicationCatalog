package com.productapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@NamedQuery(name = "findProductsByBrandAndName",
query = "from Product p where p.brand=?1 and p.productName=?2")
public class Product {

	@Column(length = 30)
	private String productName;
	@Id
	@GeneratedValue
	private Integer productId;
	private String brand;
	@Column(length = 30)
	private String category;
	@Column(name = "cost")
	private double price;

	public Product(String productName, String brand, String category, double price) {
		super();
		this.productName = productName;
		this.brand = brand;
		this.category = category;
		this.price = price;
	}
}
