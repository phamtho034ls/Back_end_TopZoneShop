package com.example.first.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.first.dto.request.CreateOderRequest;
import com.example.first.dto.response.OdersDTO;
import com.example.first.dto.response.OdersDetailDTO;
import com.example.first.dto.response.ProductDTO;
import com.example.first.dto.response.UserDTO;
import com.example.first.entity.OderDetails;
import com.example.first.entity.Oders;
import com.example.first.entity.UsersEntity;
import com.example.first.repository.OdersRepository;
import com.example.first.repository.UserRepository;

@Service
public class OderService {
	final private OdersRepository odersRepository;
	final private UserRepository userRepository;
	@Autowired
	OderDetailService oderDetailService;

	public OderService(OdersRepository odersRepository, UserRepository userRepository) {
		this.odersRepository = odersRepository;
		this.userRepository = userRepository;
	}
	
	public boolean checkUesr(String phone)
	{
		boolean check = userRepository.existsByPhone(phone);
		return check;
	}
	public List<OdersDTO> getListOders() {
		List<Oders> result = odersRepository.findAll();
		List<OdersDTO> listOderDto = new ArrayList<OdersDTO>();
		List <OdersDetailDTO> listDetailDto = new ArrayList<OdersDetailDTO>();
		for (Oders oder : result) {
			OdersDTO dto = new OdersDTO();
			dto.setDate(oder.getDate());
			dto.setId(oder.getId());
			dto.setStatus(oder.getStautus());
			dto.setUserDTO(new UserDTO( 
					oder.getUsersEntity().getId(),
					oder.getUsersEntity().getFullName(),
					oder.getUsersEntity().getPhone(),
					oder.getUsersEntity().getAddress(),
					oder.getUsersEntity().getEmail(),
					oder.getUsersEntity().getBirth(),
					oder.getUsersEntity().getUserName(),
					oder.getUsersEntity().getPassWord()
					));
				
			for(OderDetails oddetail : oder.getListOder())
				{
					OdersDetailDTO ddto = new OdersDetailDTO();
					ddto.setColor(oddetail.getColor());
					ddto.setMemory(oddetail.getMemory());
					ddto.setQuantity(oddetail.getQuantity());
					ddto.setOder_id(oddetail.getOders().getId());
					ddto.setOderprd(oddetail.getProduct().getId());
					listDetailDto.add(ddto);
				}
			
			dto.setListodeDetailDTOs(listDetailDto);
			
			listOderDto.add(dto);
		}
		return listOderDto;
	}
	


	public Oders saveOderDto(CreateOderRequest cteOder)
	{
		
		Oders oder = new Oders();
		oder.setDate(cteOder.getDate());
		oder.setStautus(cteOder.getStatus());
		oder.setId(cteOder.getId());
		
		
		
		oder.setUsersEntity(new UsersEntity(
				cteOder.getUser().getId(),
				cteOder.getUser().getFullName(),
				cteOder.getUser().getAddress(),
				cteOder.getUser().getPhone(),
				cteOder.getUser().getEmail(),
				cteOder.getUser().getBirth(),
				cteOder.getUser().getUserName(),
				cteOder.getUser().getPassWord(),
				cteOder.getUser().getCode()		
				));
		List <OdersDetailDTO> listDetailDto = new ArrayList<OdersDetailDTO>();

		for(ProductDTO oddetail : cteOder.getListPoducts())
		{
			OdersDetailDTO ddto = new OdersDetailDTO();
			ddto.setColor(oddetail.getColors());
			ddto.setMemory(oddetail.getMemory());
			ddto.setQuantity(oddetail.getQuantity());
			ddto.setOder_id(oder.getId());
			ddto.setOderprd(oddetail.getId());
			listDetailDto.add(ddto);
		}
		
		Oders createOder = odersRepository.save(oder);
		

		return createOder;
	}
	
	public Oders UpdateOder(CreateOderRequest cteOder, Long id)
	{
		Oders oder = new Oders();
		oder.setDate(cteOder.getDate());
		oder.setStautus(cteOder.getStatus());
		oder.setId(id);
		
		List<OderDetails> listOders = oderDetailService.orderDetailsfromProduct(cteOder.getListPoducts(),
				id);
		
		oder.setListOder(listOders);
		
		System.out.println("hiehiehie"+oder.getListOder().get(0).getOders().getId());
		
		oder.setUsersEntity(new UsersEntity(
				cteOder.getUser().getId(),
				cteOder.getUser().getFullName(),
				cteOder.getUser().getAddress(),
				cteOder.getUser().getPhone(),
				cteOder.getUser().getEmail(),
				cteOder.getUser().getBirth(),
				cteOder.getUser().getUserName(),
				cteOder.getUser().getPassWord(),
				cteOder.getUser().getCode()		
				));

		Oders createOder = odersRepository.save(oder);
		

		return createOder;
		
	}
	public boolean deleteOders(Long id)
	{
		boolean isExit = odersRepository.existsById(id);
		if (isExit)
		{
			odersRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
