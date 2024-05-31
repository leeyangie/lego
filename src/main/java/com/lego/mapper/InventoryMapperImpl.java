package com.lego.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lego.dto.Inventory;

@Repository
public class InventoryMapperImpl implements InventoryMapper {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int getTotalCount() {
		return sqlSession.selectOne("com.lego.mapper.inventoryMapper.getTotalCount");
	}

	@Override
	public List<Inventory> getInventoryList() {
		return sqlSession.selectList("com.lego.mapper.inventoryMapper.getInventoryList");
	}

	@Override
	public Inventory getInventory(String productid) {
		return sqlSession.selectOne("com.lego.mapper.inventoryMapper.getInventory", productid);
	}

	@Override
	public void insInventory(Inventory inventory) {
		sqlSession.insert("com.lego.mapper.inventoryMapper.insInventory", inventory);
		
	}

	@Override
	public void upInventory(Inventory inventory) {
		sqlSession.update("com.lego.mapper.inventoryMapper.upInventory", inventory);
		
	}

	@Override
	public void delInventory(int ino) {
		sqlSession.delete("com.lego.mapper.inventoryMapper.delInventory", ino);
		
	}

}
