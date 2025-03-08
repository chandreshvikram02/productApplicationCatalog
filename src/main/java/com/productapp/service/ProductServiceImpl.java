package com.productapp.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.productapp.model.Product;
import com.productapp.repository.IproductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	private IproductRepository productRepository;

	public ProductServiceImpl(IproductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public void addProduct(Product product) {
		// auto generated id, we dont pass id in product object
		// id will auto generated in the database
		// manual id,
		// check if id exists, if so updat else add a new row
		productRepository.save(product);

	}

	@Override
	public void updateProduct(Product product) {
		productRepository.save(product);

	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);

	}

	@Override
	public Product getById(int productId) {
		Optional<Product> productOpt = productRepository.findById(productId);
		if (productOpt.isPresent()) {
			return productOpt.get();
		} else
			return null;
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public List<Product> getByBrand(String brand) {
		List<Product> products=productRepository.findByBrand(brand);
		return products.stream()
				.sorted((prod1,prod2)-> prod1.getProductName().compareTo(prod2.getProductName()))
				.toList();
	}

	@Override
	public List<Product> getByCategory(String category) {
		List<Product> products = productRepository.findByCategory(category);
		return products.stream()
				.sorted(Comparator.comparing(Product::getPrice))
				.toList();
	}

	@Override
	public List<Product> getByPriceLessThan(double price) {
		List<Product> products = productRepository.findByPriceLessThan(price);
		return products.stream()
				.sorted(Comparator.comparing(Product::getPrice))
				.toList();
	}

	@Override
	public List<Product> getAByCatAndPrice(String category, double price) {
		List<Product> products = productRepository.findByCategoryAndPriceLessThan(category, price);
		return products.stream()
				.sorted(Comparator.comparing(Product::getPrice))
				.toList();
	}
	@Override
	public List<Product> getByBrandPrice(String brand, double price) {
		return productRepository.findByBrandPrice(brand, price);
	}
	@Override
	public List<Product> getByProductNameHas(String letter) {
		return productRepository.findByProductNameHas("%"+letter+"%");
	}
	@Override
	public List<Product> getByCat(String category) {
		return productRepository.getByCat(category);
	}
	@Override
	public List<Product> getAByCatPrice(String category, double price) {
		return productRepository.getAByCatPrice(category, price);
	}
	@Override
	public List<Product> getByBrandProductName(String brand, String productName) {
		return productRepository.findByBrandProductName(brand, productName);
	}

}
