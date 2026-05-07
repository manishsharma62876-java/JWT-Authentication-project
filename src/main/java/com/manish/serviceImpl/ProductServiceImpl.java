package com.manish.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manish.entity.Product;
import com.manish.repository.ProductRepository;
import com.manish.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
     	@Override
     	public String addProduct(Product product) {
		Product save = productRepository.save(product);
		return "product saved successfully.....";
	}

		@Override
		public List<Product> getAllProduct() {
			return productRepository.findAll();
		}

		@Override
		public Product getproductById(Integer productId) {
			return productRepository.findById(productId).orElseThrow(()  ->  new RuntimeException("Product id not found::"));
		}



		
}
