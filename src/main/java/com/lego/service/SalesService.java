package com.lego.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lego.dto.Sales;
import com.lego.mapper.SalesMapper;

@Service
public class SalesService {
	
	@Autowired
    private SalesMapper salesMapper;
	
	public int getTotalCount() {
		return salesMapper.getTotalCount();
	}

	public List<Sales> getAllSalesList() {
		return salesMapper.getAllSalesList();
	}
	
	public List<Sales> getStSalesList(String st) {
		return salesMapper.getStSalesList(st);
	}
	
	public List<Sales> getDelstSalesList(String delStatus) {
		return salesMapper.getDelstSalesList(delStatus);
	}
	
	public List<Sales> getPnoSalesList(String productid) {
		return salesMapper.getPidSalesList(productid);
	}

	public List<Sales> getSalesList(String id) {
		return salesMapper.getSalesList(id);
	}

	public Sales getSales(int sno) {
		return salesMapper.getSales(sno);
	}

	public void insSales(Sales sales) {
		salesMapper.insSales(sales);
	}

	public void upSales(Sales sales) {
		salesMapper.upSales(sales);
	}

	public void upDelivery(Sales sales) {
		salesMapper.upDelivery(sales);
	}

	public void completeDelivery(Sales sales) {
		salesMapper.completeDelivery(sales);
	}

	public void delSales(int sno) {
		salesMapper.delSales(sno);
	}

}
