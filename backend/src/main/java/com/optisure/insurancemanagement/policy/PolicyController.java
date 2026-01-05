package com.optisure.insurancemanagement.policy;

import com.optisure.insurancemanagement.policy.dto.PolicyDto;
import com.optisure.insurancemanagement.policy.dto.PolicyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @Autowired
    private PolicyMapper policyMapper;

    @GetMapping
    public List<PolicyDto> getPolicies() {
        return policyService.findAll().stream()
                .map(policyMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PolicyDto> getPolicyById(@PathVariable Long id) {
        return policyService.findById(id)
                .map(policyMapper::toDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PolicyDto createPolicy(@RequestBody PolicyDto policyDto) {
        Policy policy = policyMapper.toEntity(policyDto);
        return policyMapper.toDto(policyService.save(policy));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PolicyDto> updatePolicy(@PathVariable Long id, @RequestBody PolicyDto policyDetails) {
        return policyService.findById(id)
                .map(existingPolicy -> {
                    Policy policyToUpdate = policyMapper.toEntity(policyDetails);
                    policyToUpdate.setId(existingPolicy.getId());
                    return ResponseEntity.ok(policyMapper.toDto(policyService.save(policyToUpdate)));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePolicy(@PathVariable Long id) {
        policyService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
