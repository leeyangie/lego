package com.lego.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lego.dto.Product;
import com.lego.mapper.ProductMapper;

public class ProductService {
	
	@Autowired
    private ProductMapper productMapper;
	
	public int getTotalCount() {
		return productMapper.getTotalCount();
	}
	
	public List<Product> getProductList() {
		return productMapper.getProductList();
	}
	
	public List<Product> getProductCateList(String productcategory) {
		return productMapper.getProductCateList(productcategory);
	}
	
	public Product getProduct(String productid ) {
		return productMapper.getProduct(productid);
	}
	
	public void insProduct(Product product) {
		productMapper.insProduct(product);
	}
	
	public void upProduct(Product product) {
		productMapper.upProduct(product);
	}
	
	public void delProduct(String productid) {
		productMapper.delProduct(productid);
	}
}
