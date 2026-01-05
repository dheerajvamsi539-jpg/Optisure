package com.optisure.insurancemanagement.policy.dto;

import java.util.Date;

public record PolicyDto(
    Long id,
    String policyNumber,
    String policyType,
    Date startDate,
    Date endDate,
    Double premiumAmount
) {}
