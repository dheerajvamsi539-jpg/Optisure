package com.optisure.insurancemanagement.service;

import com.optisure.insurancemanagement.model.Policy;
import com.optisure.insurancemanagement.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    public List<Policy> findAll() {
        return policyRepository.findAll();
    }

    public Optional<Policy> findById(Long id) {
        return policyRepository.findById(id);
    }

    public Policy save(Policy policy) {
        return policyRepository.save(policy);
    }

    public void deleteById(Long id) {
        policyRepository.deleteById(id);
    }
}
