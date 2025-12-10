package com.optisure.insurancemanagement.service;

import com.optisure.insurancemanagement.model.Claim;
import com.optisure.insurancemanagement.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    public List<Claim> findAll() {
        return claimRepository.findAll();
    }

    public Optional<Claim> findById(Long id) {
        return claimRepository.findById(id);
    }

    public Claim save(Claim claim) {
        return claimRepository.save(claim);
    }

    public void deleteById(Long id) {
        claimRepository.deleteById(id);
    }
}
