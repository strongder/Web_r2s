package com.r2s.demo.config.mapper;



import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import java.lang.reflect.Type;
import org.modelmapper.convention.NamingConventions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.r2s.demo.dto.AddressDTO;
import com.r2s.demo.dto.CartLineItemDTO;
import com.r2s.demo.dto.OrderResponse;
import com.r2s.demo.dto.UserDTO;
import com.r2s.demo.entity.Address;
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
       
       
//       modelMapper.createTypeMap(Order.class, OrderResponse.class)
//       			.addMapping(src-> src.getUser().getFullName(), OrderResponse::setRecipientName);
//       			
//       			//.addMapping(src-> modelMapper.map(src.getCartLineItems(), new TypeToken<Set<CartLineItem>>() {}.getType()), OrderDTO::setCartLineItems);
       modelMapper.createTypeMap(CartLineItem.class, CartLineItemDTO.class)
			.addMapping(src-> src.getVariantProduct().getId(), CartLineItemDTO::setVariantProductId);
     
      
       // map dto to entity
       modelMapper.createTypeMap(Address.class, AddressDTO.class);
//       
//       modelMapper.createTypeMap(OrderResponse.class, Order.class)
//			.addMapping(OrderResponse::getRecipientName, (dest, value) -> dest.getUser().setFullName(value !=null ? value.toString(): null));
//			//.addMapping(src -> modelMapper.map(src.getCartLineItems(), new TypeToken<Set<CartLineItem>>() {}.getType()), Order::setCartLineItems);
       
       modelMapper.createTypeMap(CartLineItemDTO.class, CartLineItem.class)
		.addMapping(CartLineItemDTO::getVariantProductId,  (dest, value) -> dest.getVariantProduct().setId(value !=null ?Long.valueOf(value.toString()): null));
       
       modelMapper.createTypeMap(UserDTO.class, User.class)
       		.addMappings(m -> m.using(stringToSetRoleConverter()).map(UserDTO::getRoles, User::setRoles));
       return modelMapper;
    }
}
