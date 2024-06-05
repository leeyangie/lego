package com.lego.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lego.dto.Product;
import com.lego.dto.ProductVO;
import com.lego.mapper.ProductMapper;

public class ProductService {
	
	@Autowired
    private ProductMapper productMapper;
	
	public int getTotalCount() {
		return productMapper.getTotalCount();
	}
	
	public List<ProductVO> getProductList() {
		return productMapper.getProductList();
	}
	
	public List<ProductVO> getProductCateList(String productcategory) {
		return productMapper.getProductCateList(productcategory);
	}
	
	public ProductVO getProduct(String productid ) {
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
