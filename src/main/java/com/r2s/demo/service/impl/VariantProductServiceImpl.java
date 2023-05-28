package com.r2s.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.r2s.demo.dto.ProductDTO;
import com.r2s.demo.dto.VariantProductDTO;
import com.r2s.demo.entity.Product;
import com.r2s.demo.entity.VariantProduct;
import com.r2s.demo.exception.ProductNotFoundException;
import com.r2s.demo.repository.ProductRepository;
import com.r2s.demo.repository.VariantProductRepository;
import com.r2s.demo.service.VariantProductService;

@Service
public class VariantProductServiceImpl implements VariantProductService {

	@Autowired
	private VariantProductRepository variantProductRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Transactional(readOnly = true)
	@Override
	public VariantProductDTO getById(Long key) {
		Optional<VariantProduct> variantProduct = variantProductRepository.findById(key);
		if (variantProduct.isPresent()) {
			return modelMapper.map(variantProduct,VariantProductDTO.class);
		}
		throw new ProductNotFoundException("product not found");
	}
	@Transactional(readOnly = true)
	@Override
	public List<VariantProductDTO> getByProduct(Long productId) {
		Optional<Product> existedProduct= productRepository.findById(productId);
		if(existedProduct.isPresent())
		{
			List<VariantProduct> variantProducts = variantProductRepository.findByProductId(productId);
			return variantProducts.stream().map(variantProduct -> modelMapper.map(variantProduct, VariantProductDTO.class)).toList();
		}
		else throw new ProductNotFoundException("product not found");
	}
	@Transactional
	@Override
	public VariantProductDTO create(VariantProductDTO variantProductDTO) {
		Optional<VariantProduct> existedVariantProduct = variantProductRepository.findById(variantProductDTO.getId());
		if (existedVariantProduct.isPresent())
		{
			throw new ProductNotFoundException("product not found");
		}
		else {
			VariantProduct variantProduct = modelMapper.map(variantProductDTO, VariantProduct.class);
			variantProductRepository.save(variantProduct);
			return modelMapper.map(variantProduct, VariantProductDTO.class);
		}
	}
	@Transactional
	@Override
	public VariantProductDTO update(VariantProductDTO variantProductDTO) {
		Optional<VariantProduct> existedVariantProduct = variantProductRepository.findById(variantProductDTO.getId());
		if (existedVariantProduct.isPresent())
		{
			VariantProduct variantProduct = modelMapper.map(variantProductDTO, VariantProduct.class);
			variantProductRepository.save(variantProduct);
			return modelMapper.map(variantProduct, VariantProductDTO.class);
		}
		else {
			throw new ProductNotFoundException("product not found");
		}
	}

	@Override
	public List<VariantProductDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
