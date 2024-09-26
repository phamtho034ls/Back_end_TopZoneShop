package com.example.first.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.first.dto.request.CreateOderDetailRequest;
import com.example.first.dto.response.OdersDetailDTO;
import com.example.first.dto.response.ProductDTO;
import com.example.first.entity.OderDetails;
import com.example.first.entity.Oders;
import com.example.first.entity.ProductEntity;
import com.example.first.repository.OderDetailRepository;
import com.example.first.repository.OdersRepository;
import com.example.first.repository.ProductRepository;

@Service
public class OderDetailService {
	private final OderDetailRepository oderDetailRepository;
	private final OdersRepository odersRepository;
	private final ProductRepository productRepository;

	public OderDetailService(OderDetailRepository oderDetailRepository, OdersRepository odersRepository,
			ProductRepository productRepository) {
		super();
		this.oderDetailRepository = oderDetailRepository;
		this.odersRepository = odersRepository;
		this.productRepository = productRepository;
	}

	public List<OdersDetailDTO> getListOderDetail()
		{
			List<OderDetails> listOders = oderDetailRepository.findAll();
			List <OdersDetailDTO> listOdetailDto = new ArrayList<OdersDetailDTO>();
			for (OderDetails  oDetail : listOders)
			{
				OdersDetailDTO dto = new OdersDetailDTO();
				dto.setQuantity(oDetail.getQuantity());
				dto.setColor(oDetail.getColor());
				dto.setMemory(oDetail.getMemory());
			
				listOdetailDto.add(dto);
			}
			return listOdetailDto;
		}
	// Phương thức để tạo chi tiết đơn hàng từ danh sách ProductDTO
    public List<OderDetails> orderDetailsfromProduct(List<ProductDTO> productDTOList, Long id) {
        List<OderDetails> oderDetailsList = new ArrayList<>();

        // Duyệt qua danh sách productDTOList để xử lý từng sản phẩm
        for (ProductDTO productDTO : productDTOList) {
            // Tạo đối tượng chi tiết đơn hàng từ ProductDTO
            OderDetails oderDetails = new OderDetails();
            oderDetails.setQuantity(productDTO.getQuantity());
            oderDetails.setColor(productDTO.getColors());
            oderDetails.setMemory(productDTO.getMemory());
            
            Oders or = new Oders();
            or.setId(id);
            oderDetails.setOders(or);
            ProductEntity prd = new ProductEntity();
            prd.setId(productDTO.getId());
            oderDetails.setProduct(prd);
            oderDetailRepository.save(oderDetails);
            oderDetailsList.add(oderDetails);
        }

        return oderDetailsList; // Trả về danh sách DTO
    }
	// Phương thức để tạo chi tiết đơn hàng từ danh sách ProductDTO
    public List<OderDetails> createOrderDetailsWishProduct(List<ProductDTO> productDTOList, Long id) {
        List<OderDetails> oderDetailsList = new ArrayList<>();

        // Duyệt qua danh sách productDTOList để xử lý từng sản phẩm
        for (ProductDTO productDTO : productDTOList) {
            // Tạo đối tượng chi tiết đơn hàng từ ProductDTO
            OderDetails oderDetails = new OderDetails();
            oderDetails.setQuantity(productDTO.getQuantity());
            oderDetails.setColor(productDTO.getColors());
            oderDetails.setMemory(productDTO.getMemory());
          
            
            // Lưu thông tin chi tiết đơn hàng vào cơ sở dữ liệu (giả sử bạn có một repository)
            OderDetails savedOderDetails = oderDetailRepository.save(oderDetails);

  
            oderDetailsList.add(savedOderDetails);
        }

        return oderDetailsList; // Trả về danh sách DTO
    }

	public boolean deleteOderDetail(Long id)
	{
		boolean isExist = oderDetailRepository.existsById(id);
		if (isExist)
		{
			productRepository.deleteById(id);
			return true;
		}
		return false;
	}
	

}
