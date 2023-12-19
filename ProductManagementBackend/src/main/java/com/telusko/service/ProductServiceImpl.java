package com.telusko.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.model.Product;
import com.telusko.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Override
	public Product saveProduct(Product product) {
		return productRepo.save(product);

	}

	@Override
	public List<Product> getAllProduct() {
		return productRepo.findAll();

	}

	@Override
	public Product getProductById(int id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		Product product = null;
		if (optionalProduct != null) {
			product = optionalProduct.get();

		}
		return product;
	}

	@Override
	public String deleteProductById(int id) {
		Optional<Product> optionalProduct = productRepo.findById(id);

		if (optionalProduct != null) {
			productRepo.deleteById(id);
			return "product deleted ";

		}
		return "oops! product not found with the given id";
	}

	@Override
	public Product updateProductById(int id, Product newProduct) {

		Optional<Product> optionalProduct = productRepo.findById(id);
		Product oldProduct = null;
		if (optionalProduct != null) {
			oldProduct = optionalProduct.get();
			oldProduct.setProductName(newProduct.getProductName());
			oldProduct.setDescription(newProduct.getDescription());
			oldProduct.setPrice(newProduct.getPrice());
			oldProduct.setStatus(newProduct.getStatus());
			productRepo.save(oldProduct);

		}
		return oldProduct;

	}

}
