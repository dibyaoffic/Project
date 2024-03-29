package com.severstal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.severstal.dto.ProductDto;
import com.severstal.dto.ProductDto;
import com.severstal.model.Product;
import com.severstal.service.ProductService;

@Controller
public class MainController {

	@Autowired
	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ProductDto getProductDto() {
		ProductDto productDto =new ProductDto();
		productDto.setId(1);
		productDto.setName("DtoProduct");
		return productDto;
	
		//System.out.println("Spring mvc is working");
	}

	@RequestMapping(value = "/springproducts", method = RequestMethod.GET)
	public void getAllSpingproducts() {
		List<Product> list = productService.fetchALlProduct();
		System.out.println(list);
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Product>> getproducts() {
		List<Product> product = productService.fetchALlProduct();
		if (product.size() == 0) {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		System.out.println(product);
		return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
	}

}
