package com.optisure.insurancemanagement.policy.dto;

import com.optisure.insurancemanagement.policy.Policy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PolicyMapper {

    PolicyMapper INSTANCE = Mappers.getMapper(PolicyMapper.class);

    PolicyDto toDto(Policy policy);

    Policy toEntity(PolicyDto policyDto);
}
