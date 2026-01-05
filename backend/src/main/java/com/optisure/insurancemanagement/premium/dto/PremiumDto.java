package com.optisure.insurancemanagement.premium.dto;

import java.util.Date;

public record PremiumDto(
    Long id,
    String policyNumber,
    Double premiumAmount,
    Date dueDate,
    Date paymentDate
) {}
