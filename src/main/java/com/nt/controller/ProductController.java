package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nt.entity.Product;
import com.nt.helper.Helper;
import com.nt.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {

		if (Helper.checkExcelFormat(file)) {
			service.save(file);
			return ResponseEntity.ok(Map.of("Message","File uplaod Successfull and data save to DataBase"));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload Excel file");
	}
	
	
	@GetMapping("/get")
	public List<Product> getAllproduct(){
		return service.getAllProducts();
	}
}
