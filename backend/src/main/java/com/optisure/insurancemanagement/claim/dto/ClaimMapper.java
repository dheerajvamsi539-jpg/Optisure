package com.optisure.insurancemanagement.claim.dto;

import com.optisure.insurancemanagement.claim.Claim;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClaimMapper {

    ClaimMapper INSTANCE = Mappers.getMapper(ClaimMapper.class);

    ClaimDto toDto(Claim claim);

    Claim toEntity(ClaimDto claimDto);
}
