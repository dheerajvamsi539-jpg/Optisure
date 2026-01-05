package com.optisure.insurancemanagement.claim;

import com.optisure.insurancemanagement.claim.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
}
