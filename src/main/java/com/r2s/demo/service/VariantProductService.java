package com.r2s.demo.service;

import java.util.List;

import com.r2s.demo.dto.ProductDTO;
import com.r2s.demo.dto.VariantProductDTO;
import com.r2s.demo.entity.VariantProduct;

public interface VariantProductService extends BaseService<VariantProductDTO, Long>{

	List<VariantProductDTO> getByProduct(Long productId);

}
