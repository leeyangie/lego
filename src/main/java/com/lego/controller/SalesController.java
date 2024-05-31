package com.lego.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lego.dto.IamPortClient;
import com.lego.dto.Member;
import com.lego.dto.Sales;
import com.lego.mapper.InventoryMapper;
import com.lego.mapper.ProductMapper;
import com.lego.mapper.SalesMapper;

@Controller
@RequestMapping("/sales/")
public class SalesController {

private static final Logger log = LoggerFactory.getLogger(SalesController.class);
	
	@Autowired
	private SalesMapper salesService;
	
	@Autowired
	private ProductMapper productService;
	
	@Autowired
	private InventoryMapper inventoryService;

	@Autowired
	private HttpSession session;
	
	@GetMapping("salesList.do")
	public String getSalesList(Model model) {
		String id = (String) session.getAttribute("sid");
		model.addAttribute("list", salesService.getSalesList(id));
		return "sales/list";
	}

	@GetMapping("sales.do")
	public String getSales(@RequestParam("sno") int sno, Model model) {
		model.addAttribute("dto", salesService.getSales(sno));
		return "sales/get";
	}
	
	@GetMapping("insSales.do")
	public String insSales(@RequestParam("productid") String productid, Model model) {
		log.info("Before Sales");
		IamPortClient imPort = new IamPortClient(); 
		model.addAttribute("code", IamPortClient.getCode());
		model.addAttribute("key", IamPortClient.getKey());
		model.addAttribute("secret", IamPortClient.getSecret());
		model.addAttribute("gtid", imPort.getRandChar());
		model.addAttribute("product", productService.getProduct(productid));
		model.addAttribute("inventory", inventoryService.getInventory(productid));
		log.info("After Sales", productid);
		
		// Get the member from the session and add the member's name to the model
	    Member member = (Member) session.getAttribute("cus");
	    if (member != null) {
	        model.addAttribute("name", member.getName());
	        log.info("Member name: " + member.getName());
	    } else {
	        log.error("Member is null");
	    }
		
		return "sales/salesInsert";
	}
	
	@PostMapping("insSalesPro.do")
	public String insSalesPro(Sales sales, Model model) {
		log.info("insert success");
		salesService.insSales(sales);
		return "redirect:/product/listAll.do";
	}
	
	@GetMapping("upSales.do")
	public String upSales(@RequestParam("sno") int sno, Model model) {
		model.addAttribute("dto", salesService.getSales(sno));
		return "sales/edit";
	}
	
	@PostMapping("upSalesPro.do")
	public String upSalesPro(Sales sales, Model model) {
		salesService.upSales(sales);
		return "redirect:salesList.do";
	}
}