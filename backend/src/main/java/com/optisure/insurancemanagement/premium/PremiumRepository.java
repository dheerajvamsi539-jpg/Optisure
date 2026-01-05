package com.optisure.insurancemanagement.premium;

import com.optisure.insurancemanagement.premium.Premium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremiumRepository extends JpaRepository<Premium, Long> {
}
