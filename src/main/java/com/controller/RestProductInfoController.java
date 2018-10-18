package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pogo.ProductInfo;
import com.service.ProductInfoService;

@RestController
public class RestProductInfoController {
	
	@Autowired
	ProductInfoService productInfoService;
	
	@RequestMapping(value ="/productinfo", method =RequestMethod.GET, produces= "application/json")
	public ResponseEntity<ArrayList<ProductInfo>> getProductsInfo (){
		
		ResponseEntity<ArrayList<ProductInfo>> response =  null;
		
		ArrayList<ProductInfo> productInfo = productInfoService.getAllProducts();
		
		response = new ResponseEntity<ArrayList<ProductInfo>>(productInfo, HttpStatus.OK);
		
		return response;
	}

}
