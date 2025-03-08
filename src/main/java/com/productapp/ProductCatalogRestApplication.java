package com.productapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.model.Product;
import com.productapp.repository.IproductRepository;
import com.productapp.service.IProductService;

@SpringBootApplication
public class ProductCatalogRestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogRestApplication.class, args);
	}

	@Autowired
	IProductService productService;

	@Override
	public void run(String... args) throws Exception {
		Product product = new Product("Mobile", "Samsung", "Gadgets", 12000.60);
		productService.addProduct(product);
		product = new Product("Television", "Samsung", "Electronics", 120000.60);
		productService.addProduct(product);
		product = new Product("Pen", "Parker", "Stationary", 120);
		productService.addProduct(product);
		product = new Product("Notebook", "Classmate", "Stationary", 180);

		productService.addProduct(product);
		// productService.getAll().forEach(Product->System.out.println(Product));
		productService.getAll().forEach(System.out::println);

		System.out.println("get one product");
		Product nproduct = productService.getById(4);
		// update product
		nproduct.setCategory("Electronics");
		nproduct.setPrice(30000);
		productService.updateProduct(nproduct);

		System.out.println();
		productService.getAll().forEach(System.out::println);
		System.out.println();
		System.out.println("....By brand......");
		productService.getByBrand("Samsung").forEach(System.out::println);
		System.out.println();
		System.out.println("by category");
		productService.getByCategory("Stationary").forEach(System.out::println);
		System.out.println();
		System.out.println("by price");
		productService.getByPriceLessThan(600).forEach(System.out::println);
		System.out.println();
		System.out.println("by category and price");
		productService.getAByCatAndPrice("Electronics", 50000).forEach(System.out::println);

		System.out.println("get by Brand & Price");
		productService.getByBrandPrice("Samsung", 200000).forEach(System.out::println);
		System.out.println("get by ProductName having E");
		productService.getByProductNameHas("e").forEach(System.out::println);
		System.out.println(" get by category electronics");
		productService.getByCat("Electronics").forEach(System.out::println);
		System.out.println(" get by category and price");
		productService.getAByCatPrice("Stationary", 2000).forEach(System.out::println);

		System.out.println("get by brand and product name");
		productService.getByBrandProductName("Samsung", "Mobile").forEach(System.out::println);

	}

}
