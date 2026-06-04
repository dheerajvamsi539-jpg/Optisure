package com.optisure.insurancemanagement.premium;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings({"null", "unchecked"})
public interface PremiumRepository extends JpaRepository<Premium, Long> {
}
