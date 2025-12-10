package com.optisure.insurancemanagement.repository;

import com.optisure.insurancemanagement.model.Premium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremiumRepository extends JpaRepository<Premium, Long> {
}
