package com.optisure.insurancemanagement.service;

import com.optisure.insurancemanagement.model.Premium;
import com.optisure.insurancemanagement.repository.PremiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PremiumService {

    @Autowired
    private PremiumRepository premiumRepository;

    public List<Premium> findAll() {
        return premiumRepository.findAll();
    }

    public Optional<Premium> findById(Long id) {
        return premiumRepository.findById(id);
    }

    public Premium save(Premium premium) {
        return premiumRepository.save(premium);
    }

    public void deleteById(Long id) {
        premiumRepository.deleteById(id);
    }
}
