package com.lego.mapper;

import java.util.List;

import com.lego.dto.Inventory;

public interface InventoryMapper {
	int getTotalCount();
	List<Inventory> getInventoryList();
	Inventory getInventory(String productid);
	void insInventory(Inventory inventory);
	void upInventory(Inventory inventory);
	void delInventory(int ino);
}
