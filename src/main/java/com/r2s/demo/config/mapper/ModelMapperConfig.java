package com.r2s.demo.config.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

//    @Bean
//    public StringToRoleSetConverter stringToRoleSetConverter() {
//        return new StringToRoleSetConverter();
//    }

    @Bean
    public ModelMapper modelMapper() {
       
        return new ModelMapper();
    }
}
