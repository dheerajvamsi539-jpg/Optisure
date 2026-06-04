package com.optisure.insurancemanagement.policy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyService {

    private static final Logger logger = LoggerFactory.getLogger(PolicyService.class);

    @Autowired
    private PolicyRepository policyRepository;

    public List<Policy> findAll() {
        logger.info("Finding all policies");
        return policyRepository.findAll();
    }

    public Optional<Policy> findById(Long id) {
        logger.info("Finding policy by id: {}", id);
        return policyRepository.findById(id);
    }

    public Policy save(Policy policy) {
        logger.info("Saving policy: {}", policy);
        return policyRepository.save(policy);
    }

    public void deleteById(Long id) {
        logger.info("Deleting policy by id: {}", id);
        policyRepository.deleteById(id);
    }
}
