package com.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.ProductInfoDatabase;
import com.pogo.ProductInfo;

@Service
public class ProductInfoService {
	
	@Autowired
	ProductInfoDatabase productInfoDatabase;
	
	public ArrayList<ProductInfo> getAllProducts (){
		
		ArrayList<ProductInfo> productInfo = productInfoDatabase.getAllProducts();
		
		return productInfo;
		
	}

}
