package com.example.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.first.dto.request.CreateProductRequest;
import com.example.first.dto.response.ProductDTO;
import com.example.first.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/list")
	public List<ProductDTO> getListProducts() {
		return productService.getListProducts();
	}

	@GetMapping("/detail/{id}")
	public ProductDTO getDetailProduct(@PathVariable Long id) {
		return productService.getDetailProduct(id);
	}

	@PostMapping("/create")
	public ProductDTO createProduct(@RequestBody CreateProductRequest bodyRequest) {
		ProductDTO newProduct = productService.createProduct(bodyRequest);
		return newProduct;
	}

	@PutMapping("/update/{id}")
	public ProductDTO createProduct(@RequestBody CreateProductRequest bodyRequest, @PathVariable Long id) {
		ProductDTO newProduct = productService.updateProduct(bodyRequest, id);
		return newProduct;
	}

	@GetMapping("/category/id/{id}")
	public List<ProductDTO> getListProductInCate(@PathVariable Long id) {
		return productService.getListByCid(id);
	}
	@GetMapping("/category/{name}")
	public List<ProductDTO> getListProductInCateByName(@PathVariable String name) {
		return productService.getListByName(name);
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteProduct(@PathVariable Long id) {
		return productService.deleteProduct(id);
	}

}
