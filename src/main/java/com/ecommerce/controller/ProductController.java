package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.entity.Product;
import com.ecommerce.exceptionhandling.ProductAlreadyExistException;
import com.ecommerce.exceptionhandling.ProductNotFoundException;
import com.ecommerce.service.ProductService;

@RestController
public class ProductController {

	/// perform CRUD operations belong to primary keys
	
	@Autowired
	private ProductService ps;

	/// Get product by id
	@GetMapping("/getproduct/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) {
         System.out.println("This is controller class");   
		Product product = ps.getProductById(id);
		if (product != null) {
			return new ResponseEntity<Product>(product, HttpStatus.FOUND);
		} else {
			throw new ProductNotFoundException("Product not found for this id"+id);
		}
	}

	// save product
	@PostMapping("/saveproduct")
	public ResponseEntity<Boolean> saveproduct(@RequestBody Product product) {
		boolean saveproduct = ps.saveproduct(product);
		if (product != null) {
			return new ResponseEntity<Boolean>(saveproduct, HttpStatus.CREATED);
		} else {
			throw new ProductAlreadyExistException("Product Already Exist");
		}
	}

	//  Update product by id
	@PutMapping("/updateproduct")
	public ResponseEntity<Boolean> updateProductById(@RequestBody Product product) {
		boolean isUpdated = ps.updateProductById(product);
		if (isUpdated) {
			return new ResponseEntity<Boolean>(isUpdated, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Boolean>(isUpdated, HttpStatus.NOT_MODIFIED);
		}
	}

	// Delete product by id
	@DeleteMapping("/deleteproduct/{id}")
	public ResponseEntity<Boolean> deleteProductById(@PathVariable int id) {
		boolean isDeleted = ps.deleteProductById(id);
		if (isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		} else {
			throw new ProductNotFoundException("Product not found for this id"+id);
		}

	}

	/// perform operations belong to non primary keys by using criteria

	@GetMapping("/getallproducts")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> list = ps.getAllProducts();
		if (!list.isEmpty()) {
			for (Product prd : list) {
				System.out.println(prd);
			}
			return new ResponseEntity<List<Product>>(list, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<List<Product>>(list, HttpStatus.NOT_FOUND);
		}

	}

	/// get all product by asscending order
	@GetMapping("/getproductbyasscendingorder")
	public ResponseEntity<List<Product>> getAllProductByAscendingOrde() {
		List<Product> list = ps.getAllProductByAscendingOrde();
		if (!list.isEmpty()) {
			for (Product prd : list) {
				System.out.println(prd);
			}
			return new ResponseEntity<List<Product>>(list, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<List<Product>>(list, HttpStatus.NOT_FOUND);
		}

	}

	// get product by name
	@GetMapping("/getproductbyname/{name}")
	public ResponseEntity<Product> getProductByName(@PathVariable String name) {
		Product product = ps.getProductByName(name);
		if (product != null) {
			return new ResponseEntity<Product>(product, HttpStatus.FOUND);
		} else {
			throw new ProductNotFoundException("Product not found for this name "+name);
		}
	}

	// get all product greater then prize
	@GetMapping("/getallproductgreterthen/{prize}")
	public ResponseEntity<List<Product>> getAllProductGreterthen(@PathVariable double prize) {
		List<Product> list = ps.getAllProductGreterthen(prize);
		if (!list.isEmpty()) {
			for (Product prd : list) {
				System.out.println(prd);
			}
			return new ResponseEntity<List<Product>>(list, HttpStatus.FOUND);
		} else {
			throw new ProductNotFoundException("Product not found for greater then"+prize);
		}
	}

	// get all product prize between
	@GetMapping("/getproductbetween/{minPrize}/{maxPrize}")
	public ResponseEntity<List<Product>> getProductBetween(@PathVariable double minPrize, @PathVariable double maxPrize) {
		List<Product> list = ps.getProductBetween(minPrize, maxPrize);
		if (!list.isEmpty()) {
			for (Product prd : list) {
				System.out.println(prd);
			}return new ResponseEntity<List<Product>>(list, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<List<Product>>(list, HttpStatus.NOT_FOUND);
		}
		
	}
	
	// calculate sum of product prize
	@GetMapping("/sumofproductprize")
	public ResponseEntity<Double> sumOfProductPrize() {
		double sum = ps.sumOfProductPrize();
		if (sum != 0) {
			return new ResponseEntity<Double>(sum, HttpStatus.OK);
		} else {
			return new ResponseEntity<Double>(sum, HttpStatus.NOT_FOUND);
		}
	}

	// Get row count present in database
	@GetMapping("/getrowcount")
	public ResponseEntity<Long> getRowCount() {
		long count = ps.getRowCount();
		if (count != 0) {
			return new ResponseEntity<Long>(count, HttpStatus.FOUND);
		} else {
			throw new ProductNotFoundException("no record found in database");
		}
	}
	
	// To find out max prize of product
	@GetMapping("/maxprize")
	public ResponseEntity<Double> getMaxPrize() {
		double maxPrize = ps.getMaxPrize();
		if (maxPrize != 0) {
			return new ResponseEntity<Double>(maxPrize, HttpStatus.OK);
		} else {
			return new ResponseEntity<Double>(maxPrize, HttpStatus.NOT_FOUND);
		}
	}

	// delete product by using HQL
	@DeleteMapping("/deleteproductusinghql/{id}")
	public int deleteProductUsingHql(@PathVariable int id) {
		int row = ps.deleteProductUsingHql(id);
		if (row != 0) {
			System.out.println(row);
		}
		return row;

	}

}
