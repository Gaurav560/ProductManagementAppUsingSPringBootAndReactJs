package com.telusko.service;

import java.util.List;

import com.telusko.model.Product;

public interface ProductService {

	public Product saveProduct(Product product);
	public List<Product> getAllProduct();
	public Product getProductById(int id);
	public String deleteProductById(int id);
	public Product updateProductById(int id,Product newProduct);
	
}
