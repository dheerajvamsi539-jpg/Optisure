package com.optisure.insurancemanagement.policy;

import com.optisure.insurancemanagement.model.Policy;
import com.optisure.insurancemanagement.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @GetMapping
    public List<Policy> getPolicies() {
        return policyService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Policy> getPolicyById(@PathVariable Long id) {
        Optional<Policy> policy = policyService.findById(id);
        return policy.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Policy createPolicy(@RequestBody Policy policy) {
        return policyService.save(policy);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Policy> updatePolicy(@PathVariable Long id, @RequestBody Policy policyDetails) {
        Optional<Policy> optionalPolicy = policyService.findById(id);
        if (optionalPolicy.isPresent()) {
            Policy policy = optionalPolicy.get();
            policy.setPolicyNumber(policyDetails.getPolicyNumber());
            policy.setPolicyType(policyDetails.getPolicyType());
            policy.setStartDate(policyDetails.getStartDate());
            policy.setEndDate(policyDetails.getEndDate());
            policy.setPremiumAmount(policyDetails.getPremiumAmount());
            return ResponseEntity.ok(policyService.save(policy));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePolicy(@PathVariable Long id) {
        policyService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
