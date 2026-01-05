package com.optisure.insurancemanagement.claim;

import com.optisure.insurancemanagement.claim.dto.ClaimDto;
import com.optisure.insurancemanagement.claim.dto.ClaimMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/claims")
public class ClaimsController {

    @Autowired
    private ClaimService claimService;

    @Autowired
    private ClaimMapper claimMapper;

    @GetMapping
    public List<ClaimDto> getClaims() {
        return claimService.findAll().stream()
                .map(claimMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClaimDto> getClaimById(@PathVariable Long id) {
        return claimService.findById(id)
                .map(claimMapper::toDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ClaimDto createClaim(@RequestBody ClaimDto claimDto) {
        Claim claim = claimMapper.toEntity(claimDto);
        return claimMapper.toDto(claimService.save(claim));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClaimDto> updateClaim(@PathVariable Long id, @RequestBody ClaimDto claimDetails) {
        return claimService.findById(id)
                .map(existingClaim -> {
                    Claim claimToUpdate = claimMapper.toEntity(claimDetails);
                    claimToUpdate.setId(existingClaim.getId());
                    return ResponseEntity.ok(claimMapper.toDto(claimService.save(claimToUpdate)));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClaim(@PathVariable Long id) {
        claimService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
