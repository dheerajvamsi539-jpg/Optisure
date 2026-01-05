package com.optisure.insurancemanagement.premium.dto;

import com.optisure.insurancemanagement.premium.Premium;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PremiumMapper {

    PremiumMapper INSTANCE = Mappers.getMapper(PremiumMapper.class);

    PremiumDto toDto(Premium premium);

    Premium toEntity(PremiumDto premiumDto);
}
