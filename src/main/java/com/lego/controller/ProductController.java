package com.lego.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lego.dto.Product;
import com.lego.mapper.ProductMapper;

@Controller
@RequestMapping("/product/")
public class ProductController {
	
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductMapper productService;
	
	
	private String uploadLoc = "/resources/upload/";
	
	@RequestMapping("listAll.do")
	public String getProductList(Model model) {
		model.addAttribute("list", productService.getProductList());
		return "product/productList";
	}
	
	@RequestMapping("list.do")
	public String getProductCateList(@RequestParam("productcategory") String productcategory, Model model) {
		model.addAttribute("list", productService.getProductCateList(productcategory));
		return "product/productList";
	}
	
	@RequestMapping("detail.do")
	public String getProduct(@RequestParam("productid") String productid, Model model) {
		model.addAttribute("product", productService.getProduct(productid));
		return "product/productView";
	}

	@GetMapping("insert.do")
	public String insProduct(Product product, Model model) {
		return "product/productInsert";
	}
	
	@PostMapping("insertPro.do")
	public String insProductPro(@RequestParam("productid") String productid,
			@RequestParam("productcategory") String productcategory,
			@RequestParam("productname") String productname,
			@RequestParam("description") String description,
			@RequestParam("price") int price,
			@RequestParam("img1") MultipartFile img1,
			@RequestParam("img2") MultipartFile img2,
			@RequestParam("img3") MultipartFile img3, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		
		log.info(request.getServletContext().getRealPath(uploadLoc));
		String uploadDir = request.getServletContext().getRealPath(uploadLoc);
		log.info(uploadDir);
		File dir = new File(uploadDir);
		
		String img1Name="", img2Name="", img3Name="";
		
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		try {
			if(!img1.isEmpty()) {
				img1Name = saveFile(img1, uploadDir);
				log.info("업로드 파일1 이름 : {}", img1Name);
			}
			if(!img2.isEmpty()) {
				img2Name = saveFile(img2, uploadDir);
				log.info("업로드 파일2 이름 : {}", img2Name);
			}
			if(!img3.isEmpty()) {
				img3Name = saveFile(img3, uploadDir);
				log.info("업로드 파일3 이름 : {}", img3Name);
			}
		} catch (IOException e) {
			log.error("예외 : {}", e);
		}
		
		Product product = new Product();
		product.setProductid(productid);
		product.setProductcategory(productcategory);
		product.setProductname(productname);
		product.setDescription(description);
		product.setPrice(price);
		product.setImg1(img1Name);
		product.setImg2(img2Name);
		product.setImg3(img3Name);
		
		productService.insProduct(product);
		return "redirect:listAll.do";
	}

	public String saveFile(MultipartFile file, String uploadDir) throws IOException {
		String originalFilename = file.getOriginalFilename();
		String newFilename = UUID.randomUUID().toString() + "_" + originalFilename;
		File serverFile = new File(uploadDir + newFilename);
		file.transferTo(serverFile);
		return newFilename;
	}
	
	@GetMapping("update.do")
	public String upProduct(@RequestParam("productid") String productid,
			@RequestParam("productcategory") String productcategory,
			@RequestParam("productname") String productname,
			@RequestParam("description") String description,
			@RequestParam("price") int price,
			@RequestParam("img1") MultipartFile img1,
			@RequestParam("img2") MultipartFile img2,
			@RequestParam("img3") MultipartFile img3, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		
		model.addAttribute("product", productService.getProduct(productid));
		return "product/edit";
	}
	
	@PostMapping("updatePro.do")
	public String upProductPro(@RequestParam("productid") String productid,
			@RequestParam("productcategory") String productcategory,
			@RequestParam("productname") String productname,
			@RequestParam("description") String description,
			@RequestParam("price") int price,
			@RequestParam("img1") MultipartFile img1,
			@RequestParam("img2") MultipartFile img2,
			@RequestParam("img3") MultipartFile img3, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		
		Product before = productService.getProduct(productid);
		
		String uploadDir = request.getServletContext().getRealPath(uploadLoc);
		File dir = new File(uploadDir);
		
		String img1Name="", img2Name="", img3Name="";
		
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		try {
			if(!img1.isEmpty()) {
				img1Name = saveFile(img1, uploadDir);
				log.info("변경 파일1 이름 : {}", img1Name);
			} else {
				img1Name = before.getImg1();
			}
			if(!img2.isEmpty()) {
				img2Name = saveFile(img2, uploadDir);
				log.info("변경 파일2 이름 : {}", img2Name);
			} else {
				img2Name = before.getImg2();
			}
			if(!img3.isEmpty()) {
				img3Name = saveFile(img3, uploadDir);
				log.info("변경 파일3 이름 : {}", img3Name);
			} else {
				img1Name = before.getImg3();
			}
		} catch (IOException e) {
			log.error("예외 : {}", e);
		}
		
		Product product = new Product();
		product.setProductid(productid);
		product.setProductcategory(productcategory);
		product.setProductname(productname);
		product.setDescription(description);
		product.setImg1(img1Name);
		product.setImg2(img2Name);
		product.setImg3(img3Name);
		
		productService.upProduct(product);
		return "redirect:list.do";
	}
	
	@RequestMapping("delProduct.do")
	public String delProduct(@RequestParam("productid") String productid, Model model) {
		productService.delProduct(productid);
		return "redirect:list.do";
	}

}
