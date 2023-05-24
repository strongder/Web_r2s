package com.r2s.demo.config.mapper;



import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import java.lang.reflect.Type;
import org.modelmapper.convention.NamingConventions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.r2s.demo.dto.CartLineItemDTO;
import com.r2s.demo.dto.OrderDTO;
import com.r2s.demo.dto.UserDTO;
import com.r2s.demo.entity.CartLineItem;
import com.r2s.demo.entity.Order;
import com.r2s.demo.entity.User;

@Configuration
public class ModelMapperConfig {

	
	@Bean
	public StringToSetRoleConverter stringToSetRoleConverter()
	{
		return new StringToSetRoleConverter();
	}
	
    @Bean
    public ModelMapper modelMapper() {
       ModelMapper modelMapper = new ModelMapper();
       modelMapper.getConfiguration()
       .setSourceNamingConvention(NamingConventions.NONE)
       .setDestinationNamingConvention(NamingConventions.NONE);
       
       //map entity to dto
       
       modelMapper.createTypeMap(CartLineItem.class, CartLineItemDTO.class)
       			.addMapping(src -> src.getVariantProduct().getId(), CartLineItemDTO::setVariantProductId)
       			.addMapping(src -> src.getVariantProduct().getName(), CartLineItemDTO::setVariantProductName);
       
       modelMapper.createTypeMap(Order.class, OrderDTO.class)
       			.addMapping(src-> src.getUser().getFullName(), OrderDTO::setRecipientName)
       			.addMapping(src-> src.getAddress().getAddress(), OrderDTO::setAddress);
       
     
      
       // map dto to entity
       modelMapper.createTypeMap(CartLineItemDTO.class, CartLineItem.class)
       			.addMapping(CartLineItemDTO::getVariantProductId, (dest, value) -> dest.getVariantProduct().setId(value !=null ? Long.valueOf(value.toString()): null))
       			.addMapping(CartLineItemDTO::getVariantProductName, (dest, value) -> dest.getVariantProduct().setName(value !=null ? value.toString(): null));
       
       modelMapper.createTypeMap(OrderDTO.class, Order.class)
			.addMapping(OrderDTO::getRecipientName, (dest, value) -> dest.getUser().setFullName(value !=null ? value.toString(): null))
			.addMapping(OrderDTO::getAddress, (dest, value) -> dest.getAddress().setAddress(value !=null ? value.toString(): null));
       
       modelMapper.createTypeMap(UserDTO.class, User.class)
       		.addMappings(m -> m.using(stringToSetRoleConverter()).map(UserDTO::getRoles, User::setRoles));
       return modelMapper;
    }
}
