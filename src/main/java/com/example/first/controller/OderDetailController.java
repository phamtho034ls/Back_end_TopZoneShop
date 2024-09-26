package com.example.first.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.first.dto.response.OdersDetailDTO;
import com.example.first.dto.response.ProductDTO;
import com.example.first.entity.OderDetails;
import com.example.first.service.OderDetailService;


@CrossOrigin("*")
@RestController
@RequestMapping("/oderdetail")
public class OderDetailController {
	@Autowired
	OderDetailService oderDetailService;
	
	@GetMapping("list")
	public List<OdersDetailDTO> getListOderDetail()
	{
		return oderDetailService.getListOderDetail();
	}
	@PostMapping("/create")
	public List<OderDetails> createOrderDetails(@RequestBody List<ProductDTO> productDTOs, Long id ) {
	    // Gọi phương thức createOrderDetailsWishProduct từ OderDetailService
	    return oderDetailService.createOrderDetailsWishProduct(productDTOs,id);
	}


	@DeleteMapping("/delete/{id}")
	public boolean deleteOder(@PathVariable Long id)
	{
		return oderDetailService.deleteOderDetail(id);
	}
	

}
