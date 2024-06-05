package com.lego.mapper;

import java.util.List;

import com.lego.dto.Product;
import com.lego.dto.ProductVO;

public interface ProductMapper {
	int getTotalCount();
	List<ProductVO> getProductList();
	List<ProductVO> getProductCateList(String productcategory);
	ProductVO getProduct(String productid );
	void insProduct(Product product);
	void upProduct(Product product);
	void delProduct(String productid);
}
