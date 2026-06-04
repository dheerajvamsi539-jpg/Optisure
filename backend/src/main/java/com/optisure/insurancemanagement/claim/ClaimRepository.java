package com.optisure.insurancemanagement.claim;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings({"null", "unchecked"})
public interface ClaimRepository extends JpaRepository<Claim, Long> {
}
