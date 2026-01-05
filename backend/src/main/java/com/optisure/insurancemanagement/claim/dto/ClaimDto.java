package com.optisure.insurancemanagement.claim.dto;

import java.util.Date;

public record ClaimDto(
    Long id,
    String claimNumber,
    String policyNumber,
    Date claimDate,
    Double claimAmount,
    String status
) {}
