package com.lego.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lego.dto.Product;
import com.lego.dto.ProductVO;

@Repository
public class ProductMapperImpl implements ProductMapper{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int getTotalCount() {
		return sqlSession.selectOne("com.lego.mapper.ProductMapper.geTotalCount");
	}

	@Override
	public List<ProductVO> getProductList() {
		return sqlSession.selectList("com.lego.mapper.ProductMapper.getProductList");
	}

	@Override
	public List<ProductVO> getProductCateList(String productcategory) {
		return sqlSession.selectList("com.lego.mapper.ProductMapper.getProductCateList", productcategory);
	}

	@Override
	public ProductVO getProduct(String productid) {
		return sqlSession.selectOne("com.lego.mapper.ProductMapper.getProduct", productid);
	}

	@Override
	public void insProduct(Product product) {
		sqlSession.insert("com.lego.mapper.ProductMapper.insProduct", product);
	}

	@Override
	public void upProduct(Product product) {
		sqlSession.update("com.lego.mapper.ProductMapper.upProduct", product);
	}

	@Override
	public void delProduct(String productid) {
		sqlSession.delete("com.lego.mapper.ProductMapper.delProduct");
		
	}

}
