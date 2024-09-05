package com.example.first.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.first.dto.request.CreateProductRequest;
import com.example.first.dto.response.CategoryDTO;
import com.example.first.dto.response.ProductDTO;
import com.example.first.entity.CategoryEntity;
import com.example.first.entity.ProductEntity;
import com.example.first.repository.CategoryRepository;
import com.example.first.repository.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;

	public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		super();
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	public List<ProductDTO> getListProducts() {
		List<ProductEntity> products = productRepository.findAll();

		List<ProductDTO> listPrdDto = new ArrayList<ProductDTO>();

		for (ProductEntity prd : products) {
			ProductDTO newDto = new ProductDTO();
			newDto.setId(prd.getId());
			newDto.setDescription(prd.getDescription());
			newDto.setImage(prd.getImage());
			newDto.setName(prd.getName());
			newDto.setPrice(prd.getPrice());
			newDto.setQuantity(prd.getQuantity());
			newDto.setColors(prd.getColors());
			newDto.setMemory(prd.getMemory());
			newDto.setDiscount(prd.getDiscount());
			newDto.setCode(prd.getCode());
			newDto.setCategory(new CategoryDTO(prd.getCategory().getId(), prd.getCategory().getName(),
					prd.getCategory().getDescription()));
			listPrdDto.add(newDto);
		}

		return listPrdDto;

	}

	public ProductDTO getDetailProduct(Long id) {
		ProductEntity prd = productRepository.findById(id).get();

		ProductDTO newDto = new ProductDTO();
		newDto.setId(prd.getId());
		newDto.setDescription(prd.getDescription());
		newDto.setImage(prd.getImage());
		newDto.setName(prd.getName());
		newDto.setPrice(prd.getPrice());
		newDto.setQuantity(prd.getQuantity());
		newDto.setColors(prd.getColors());
		newDto.setMemory(prd.getMemory());
		newDto.setDiscount(prd.getDiscount());
		newDto.setCode(prd.getCode());
		newDto.setCategory(new CategoryDTO(prd.getCategory().getId(), prd.getCategory().getName(),
				prd.getCategory().getDescription()));

		return newDto;
	}

	public ProductDTO createProduct(CreateProductRequest newProduct) {
		// kiểm tra CID có tồn tại trong category hay không
		CategoryEntity existCategory = categoryRepository.findById(newProduct.getCid()).get();

//		 Nếu không thì trả về null và không tạo mới
		if (existCategory == null) {
			return null;
		}

		// set request vào entity
		ProductEntity newPrdEntity = new ProductEntity();

		newPrdEntity.setCategory(existCategory);
		newPrdEntity.setDescription(newProduct.getDescription());
		newPrdEntity.setImage(newProduct.getImage());
		newPrdEntity.setName(newProduct.getName());
		newPrdEntity.setPrice(newProduct.getPrice());
		newPrdEntity.setQuantity(newProduct.getQuantity());
		newPrdEntity.setColors(newProduct.getColors());
		newPrdEntity.setDiscount(newProduct.getDiscount());
		newPrdEntity.setMemory(newProduct.getMemory());
		newPrdEntity.setCode(newProduct.getCode());
		// tạo mới product
		ProductEntity createdProduct = productRepository.save(newPrdEntity);

		ProductDTO newDto = new ProductDTO();
		newDto.setId(createdProduct.getId());
		newDto.setDescription(createdProduct.getDescription());
		newDto.setImage(createdProduct.getImage());
		newDto.setName(createdProduct.getName());
		newDto.setPrice(createdProduct.getPrice());
		newDto.setQuantity(createdProduct.getQuantity());
		newDto.setColors(createdProduct.getColors());
		newDto.setMemory(createdProduct.getMemory());
		newDto.setDiscount(createdProduct.getDiscount());
		newDto.setCode(createdProduct.getCode());
		newDto.setCategory(new CategoryDTO(createdProduct.getCategory().getId(), createdProduct.getCategory().getName(),
				createdProduct.getCategory().getDescription()));

		return newDto;
	}
	public ProductDTO updateProduct(CreateProductRequest newProduct, Long id) {
		// kiểm tra CID có tồn tại trong category hay không
		CategoryEntity existCategory = categoryRepository.findById(newProduct.getCid()).get();

		// Nếu không thì trả về null và không tạo mới
		if (existCategory == null) {
			return null;
		}

		// set request vào entity
		ProductEntity newPrdEntity = new ProductEntity();
		newPrdEntity.setId(id);
		newPrdEntity.setCategory(existCategory);
		newPrdEntity.setDescription(newProduct.getDescription());
		newPrdEntity.setImage(newProduct.getImage());
		newPrdEntity.setName(newProduct.getName());
		newPrdEntity.setPrice(newProduct.getPrice());
		newPrdEntity.setQuantity(newProduct.getQuantity());
		newPrdEntity.setColors(newProduct.getColors());
		newPrdEntity.setDiscount(newProduct.getDiscount());
		newPrdEntity.setMemory(newProduct.getMemory());
		newPrdEntity.setCode(newProduct.getCode());
		// tạo mới product
		ProductEntity createdProduct = productRepository.save(newPrdEntity);

		ProductDTO newDto = new ProductDTO();
		newDto.setId(createdProduct.getId());
		newDto.setDescription(createdProduct.getDescription());
		newDto.setImage(createdProduct.getImage());
		newDto.setName(createdProduct.getName());
		newDto.setPrice(createdProduct.getPrice());
		newDto.setQuantity(createdProduct.getQuantity());
		newDto.setColors(createdProduct.getColors());
		newDto.setMemory(createdProduct.getMemory());
		newDto.setDiscount(createdProduct.getDiscount());
		newDto.setCode(createdProduct.getCode());
		newDto.setCategory(new CategoryDTO(createdProduct.getCategory().getId(), createdProduct.getCategory().getName(),
				createdProduct.getCategory().getDescription()));
		return newDto;
		
	}
	public List<ProductDTO> getListByCid(Long id) {
		List<ProductEntity> listProducts = productRepository.findByCid(id);
		List<ProductDTO> listProductDtos = new ArrayList<ProductDTO>();

		for (ProductEntity prd : listProducts) {
			ProductDTO newDto = new ProductDTO();
			newDto.setId(prd.getId());
			newDto.setDescription(prd.getDescription());
			newDto.setImage(prd.getImage());
			newDto.setName(prd.getName());
			newDto.setPrice(prd.getPrice());
			newDto.setQuantity(prd.getQuantity());
			newDto.setDiscount(prd.getDiscount());
			newDto.setCode(prd.getCode());
			newDto.setCategory(new CategoryDTO(prd.getCategory().getId(), prd.getCategory().getName(),
					prd.getCategory().getDescription()));
			listProductDtos.add(newDto);
		}

		return listProductDtos;

	}

	public boolean deleteProduct(Long id)
	{
		boolean isExit = productRepository.existsById(id);
		if (isExit)
		{
			productRepository.deleteById(id);
			return true;
		}
		return false;
		
	}

}
