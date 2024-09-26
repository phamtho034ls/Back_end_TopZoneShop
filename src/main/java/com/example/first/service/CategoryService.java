package com.example.first.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.first.dto.response.CategoryDTO;
import com.example.first.dto.response.ProductDTO;
import com.example.first.entity.CategoryEntity;
import com.example.first.entity.ProductEntity;
import com.example.first.repository.CategoryRepository;

@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public List<CategoryDTO> getListCategory() {
		List<CategoryEntity> result = categoryRepository.findAll();
		List<CategoryDTO> listCategories = new ArrayList<CategoryDTO>();

		// chuyển đổi dữ liệu entity sang DTO
		for (CategoryEntity categoryEntity : result) {
			CategoryDTO dto = new CategoryDTO(categoryEntity.getId(), categoryEntity.getName(),
					categoryEntity.getDescription());
			listCategories.add(dto);

		}

		return listCategories;
	}

	public List<CategoryDTO> getListCategoryWithProduct() {
		List<CategoryEntity> result = categoryRepository.findAll();
		List<CategoryDTO> listCategories = new ArrayList<CategoryDTO>();

		// chuyển đổi dữ liệu entity sang DTO
		for (CategoryEntity categoryEntity : result) {
			CategoryDTO dto = new CategoryDTO(categoryEntity.getId(), categoryEntity.getName(),categoryEntity.getDescription());
			List<ProductDTO> prdList = new ArrayList<ProductDTO>();
			for(ProductEntity prd: categoryEntity.getProductList()) {
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
				prdList.add(newDto);
			}
			dto.setProducts(prdList);
			listCategories.add(dto);

		}

		return listCategories;
	}
	
	public CategoryDTO saveCategory(CategoryEntity newCategory) {
		CategoryEntity cate = categoryRepository.save(newCategory);

		CategoryDTO dto = new CategoryDTO();
		dto.setId(cate.getId());
		dto.setName(cate.getName());
		dto.setDescription(cate.getDescription());

		return dto;
	}

	public boolean deleteCategory(Long id) {
		boolean isExist = categoryRepository.existsById(id);

		if (isExist) {
			categoryRepository.deleteById(id);
			return true;
		}

		return false;
	}

	public CategoryDTO getDetailCategory(Long id) {
		CategoryEntity detail = categoryRepository.findById(id).get();
		CategoryDTO dto = new CategoryDTO(detail.getId(), detail.getName(), detail.getDescription());
		return dto;
	}

}
