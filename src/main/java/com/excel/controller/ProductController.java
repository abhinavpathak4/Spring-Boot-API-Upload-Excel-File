package com.excel.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.excel.entity.Product;
import com.excel.helper.Helper;
import com.excel.service.ProductService;

@RestController
@CrossOrigin("*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/product/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file){
		
		if(Helper.checkExcelFormat(file)) {
			this.productService.save(file);
			 return ResponseEntity.ok(getProducts());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel files only");
	}
	
	@GetMapping("/product")
	public List<Product> getProducts(){
		return this.productService.getAllProducts();
	}

}
