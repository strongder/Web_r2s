package com.r2s.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.r2s.demo.dto.ProductDTO;
import com.r2s.demo.entity.Category;
import com.r2s.demo.entity.Product;
import com.r2s.demo.repository.CategoryRepository;
import com.r2s.demo.repository.ProductRepository;
import com.r2s.demo.service.ProductService;
import com.r2s.demo.util.PaginationSortingUtils;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Transactional(readOnly = true)
	@Override
	public ProductDTO getById(Long key) {
		Optional<Product> product = productRepository.findById(key);
		if (product.isPresent()) {
			return modelMapper.map(product, ProductDTO.class);
		}
		throw new RuntimeException("product not found");
	}

	@Transactional(readOnly = true)
	@Override
	public List<ProductDTO> getProductsByCategory(Long categoryId, int pageNo, int pageSize, String sortDir,
			String sortBy) {
		Pageable pageable = PaginationSortingUtils.getPageable(pageNo, pageSize, sortDir, sortBy);
		Optional<Category> category = categoryRepository.findById(categoryId);
		if (category.isPresent()) {
			Page<Product> productPage = productRepository.findByCategory(category, pageable);
			return productPage.map(product -> modelMapper.map(product, ProductDTO.class)).getContent();
		} else
			throw new RuntimeException("category not found");
	}

	@Override
	public List<ProductDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public ProductDTO create(ProductDTO productDTO) {
		Optional<Product> existedProduct = productRepository.findById(productDTO.getId());
		if (existedProduct.isPresent())
		{
			throw new RuntimeException("product is exist");
		}
		else {
			Product product = modelMapper.map(productDTO, Product.class);
			productRepository.save(product);
			return modelMapper.map(product, ProductDTO.class);
		}
	}
	@Transactional
	@Override
	public ProductDTO update(ProductDTO productDTO) {
		Optional<Product> existedProduct = productRepository.findById(productDTO.getId());
		if (existedProduct.isPresent())
		{
			Product product = modelMapper.map(productDTO, Product.class);
			productRepository.save(product);
			return modelMapper.map(product, ProductDTO.class);
		}
		else {
			throw new RuntimeException("product not found");
		}
	}

}
