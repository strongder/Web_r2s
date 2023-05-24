package com.r2s.demo.service;

import java.util.List;

import com.r2s.demo.dto.ProductDTO;

public interface ProductService extends BaseService<ProductDTO, Long>{
	List<ProductDTO> getProductsByCategory(Long categoryId, int pageNo, int pageSize, String sortDir, String sortBy);

}
