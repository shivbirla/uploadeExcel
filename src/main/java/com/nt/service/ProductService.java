package com.nt.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nt.entity.Product;
import com.nt.helper.Helper;
import com.nt.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo repo;

	public void save(MultipartFile file) {

		try {
			List<Product> convertExcelToListOfProduct = Helper.convertExcelToListOfProduct(file.getInputStream());
			repo.saveAll(convertExcelToListOfProduct);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Product> getAllProducts() {

		return repo.findAll();
	}
}
