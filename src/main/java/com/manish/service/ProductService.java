package com.manish.service;

import java.util.List;

import com.manish.entity.Product;

public interface ProductService {

	public String addProduct(Product product);

	public List<Product> getAllProduct();

	public Product getproductById(Integer productId);
	
		//public Product updateproduct(Integer productId,Product product);

}
