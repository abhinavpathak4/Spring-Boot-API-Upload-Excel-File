package com.excel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.excel.entity.Product;
import com.excel.helper.Helper;
import com.excel.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public void save(MultipartFile file) {
		
		try {
			List<Product> list =  Helper.convertExcelToListOfProduct(file.getInputStream());
			this.productRepository.saveAll(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Product> getAllProducts(){
		return this.productRepository.findAll();
	}

}
