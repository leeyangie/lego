package com.lego.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lego.dto.Inventory;
import com.lego.mapper.InventoryMapper;

public class InventoryService {

	@Autowired
	private InventoryMapper inventoryMapper;

	public int getTotalCount() {
		return inventoryMapper.getTotalCount();
	}
	
	public List<Inventory> getInventoryList() {
		return inventoryMapper.getInventoryList();
	}
	
	public Inventory getInventory(String productid) {
		return inventoryMapper.getInventory(productid);
	}
	
	public void insInventory(Inventory inventory) {
		inventoryMapper.insInventory(inventory);
	}
	
	public void upInventory(Inventory inventory) {
		inventoryMapper.upInventory(inventory);
	}
	
	public void delInventory(int ino) {
		inventoryMapper.delInventory(ino);
	}


}
