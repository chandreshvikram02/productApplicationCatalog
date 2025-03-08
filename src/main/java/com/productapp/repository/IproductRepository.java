package com.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.productapp.model.Product;

@Repository
public interface IproductRepository extends JpaRepository<Product,Integer> {

	List<Product> findByBrand(String brand);
	List<Product> findByCategory(String category);
	List<Product> findByPriceLessThan(double price);
	List<Product>  findByCategoryAndPriceLessThan(String category, double price);
	
	// custom queries -  JPQL query using entity name
//	@Query("from Product p where p.brand=?1and p.price=?2")
//	List<Product> findByBrandPrice(String brand, double price);
	
	@Query("from Product p where p.brand=:brand and p.price<:price")
	List<Product> findByBrandPrice(@Param("brand") String brand,@Param("price") double price);
	
	// select * from product where productName like %letter %
	@Query("from Product p where p.productName like ?1")
	List<Product> findByProductNameHas(String letter);
	
	//Native Query
	@Query(value = "select * from PRODUCT where category=?1",nativeQuery = true)
	List<Product> getByCat(String category);
	
	@Query(value = "select * from PRODUCT where category=?1 and cost<?2",nativeQuery = true)
	List<Product> getAByCatPrice(String category, double price);
	
	//named query
	@Query(name="findProductsByBrandAndName")
	List<Product> findByBrandProductName(String brand, String productName);
	
	
	
	
}
