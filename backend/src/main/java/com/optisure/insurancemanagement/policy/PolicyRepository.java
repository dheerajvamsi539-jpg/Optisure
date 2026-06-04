package com.optisure.insurancemanagement.policy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings({"null", "unchecked"})
public interface PolicyRepository extends JpaRepository<Policy, Long> {
}
