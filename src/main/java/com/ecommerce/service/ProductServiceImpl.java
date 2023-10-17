package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.dao.ProductDao;
import com.ecommerce.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao pd;
	@Override
	public Product getProductById(int id) {
		
		return pd.getProductById(id);
	}
	
	@Override
	public boolean saveproduct(Product product) {
		boolean isAdded = pd.saveproduct(product);
		return isAdded;
	}
	
	@Override
	public boolean updateProductById(Product product) {
		
		return pd.updateProductById(product);
	}
	
	@Override
	public boolean deleteProductById(int id) {
		 boolean isDeleted = pd.deleteProductById(id);
		return isDeleted;
	}

	@Override
	public List<Product> getAllProducts() {
		
		return pd.getAllProducts();
	}

	@Override
	public List<Product> getAllProductByAscendingOrde() {
		List<Product> list = pd.getAllProductByAscendingOrde();
		return list;
	}

	@Override
	public Product getProductByName(String name) {
		Product product = pd.getProductByName(name);
		return product;
	}

	@Override
	public List<Product> getAllProductGreterthen(double prize) {
		List<Product> list = pd.getAllProductGreterthen( prize);
		return list;
	}

	@Override
	public List<Product> getProductBetween(double minPrize, double maxPrize) {
		List<Product> list = pd.getProductBetween(minPrize,maxPrize);
		return list;
	}

	@Override
	public double sumOfProductPrize() {
		double sum = pd.sumOfProductPrize();
		return sum;
	}

	@Override
	public long getRowCount() {
		long count=pd.getRowCount();
		return count;
	}

	@Override
	public double getMaxPrize() {
		double maxPrize=pd.getMaxPrize();
		return maxPrize;
	}

	@Override
	public int deleteProductUsingHql(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
