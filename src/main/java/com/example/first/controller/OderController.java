package com.example.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.first.dto.request.CreateOderRequest;
import com.example.first.dto.request.CreateUserRequest;
import com.example.first.dto.response.OdersDTO;
import com.example.first.dto.response.OdersDetailDTO;
import com.example.first.entity.OderDetails;
import com.example.first.entity.Oders;
import com.example.first.entity.UsersEntity;
import com.example.first.service.OderDetailService;
import com.example.first.service.OderService;
import com.example.first.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin("*")
@RestController
@RequestMapping("/oder")
public class OderController {
	@Autowired
	OderService oderService;
	@Autowired
	UserService userService;
	@Autowired
	OderDetailService oderDetailService;

	@GetMapping("/listoders")
	public List<OdersDTO> getOders() {
		return oderService.getListOders();
	}

	@PostMapping("/create")
	public Oders createOders(@RequestBody CreateOderRequest bodyCreateOderRequest) {
		CreateOderRequest newOder = new CreateOderRequest();

		boolean check = oderService.checkUesr(bodyCreateOderRequest.getUser().getPhone());
		UsersEntity userEntity = new UsersEntity();
		CreateUserRequest userDto =bodyCreateOderRequest.getUser();
		System.out.println("check" + bodyCreateOderRequest.getListPoducts().get(0).getName());
		if (!check) {
			userService.saveUserEntity(bodyCreateOderRequest.getUser());
		}
		userEntity = userService.getbByPhone(bodyCreateOderRequest.getUser().getPhone());
		userDto.setId(userEntity.getId());

		newOder.setDate(bodyCreateOderRequest.getDate());
		newOder.setStatus(bodyCreateOderRequest.getStatus());
		newOder.setUser(userDto); // Đảm bảo userEntity đã được lưu
		newOder.setListPoducts(bodyCreateOderRequest.getListPoducts());
		Oders savedOder = oderService.saveOderDto(newOder);

		List<OderDetails> listOders = oderDetailService.orderDetailsfromProduct(bodyCreateOderRequest.getListPoducts(),
				savedOder.getId());
		savedOder.setListOder(listOders);

		// Cập nhật lại đơn hàng với chi tiết
		Oders updatedOder = oderService.UpdateOder(bodyCreateOderRequest, savedOder.getId());

		return updatedOder;
//	    return null;
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteOders(@PathVariable Long id) {
		return oderService.deleteOders(id);
	}

}
