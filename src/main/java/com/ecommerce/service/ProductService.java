package com.ecommerce.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ecommerce.entity.Product;

public interface ProductService {

	Product getProductById(int id);

	boolean deleteProductById(int id);

	boolean saveproduct(Product product);

	boolean updateProductById(Product product);

	List<Product> getAllProducts();

	List<Product> getAllProductByAscendingOrde();

	Product getProductByName(String name);

	List<Product> getAllProductGreterthen(double prize);

	List<Product> getProductBetween(double minPrize, double maxPrize);

    double sumOfProductPrize();

	long getRowCount();

	double getMaxPrize();
	
	int deleteProductUsingHql(int id);

}
