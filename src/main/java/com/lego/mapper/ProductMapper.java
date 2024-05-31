package com.lego.mapper;

import java.util.List;

import com.lego.dto.Product;

public interface ProductMapper {
	int getTotalCount();
	List<Product> getProductList();
	List<Product> getProductCateList(String productcategory);
	Product getProduct(String productid );
	void insProduct(Product product);
	void upProduct(Product product);
	void delProduct(String productid);
}
