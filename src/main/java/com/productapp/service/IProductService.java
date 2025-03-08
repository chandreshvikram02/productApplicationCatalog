package com.productapp.service;

import java.util.List;

import com.productapp.model.Product;

public interface IProductService {

	void addProduct(Product product);
	 void updateProduct(Product product);
	 void deleteProduct(int productId);
	 Product getById(int productId);
	List<Product> getAll();
	
	// derived queries
	 List<Product> getByBrand(String brand);
	 List<Product> getByCategory(String category);
	 List<Product> getByPriceLessThan(double price);
	 List<Product> getAByCatAndPrice(String category,double price);
	 
	// customquery
	 List<Product> getByBrandPrice(String brand, double price);
	 List<Product> getByProductNameHas(String letter);
	 
	//native query
	 List<Product> getByCat(String catagory);
	 List<Product> getAByCatPrice(String category,double price);
	 
	//named query
		List<Product> getByBrandProductName(String brand, String productName);

}
