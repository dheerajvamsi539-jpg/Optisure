package com.optisure.insurancemanagement.claims;

import com.optisure.insurancemanagement.model.Claim;
import com.optisure.insurancemanagement.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/claims")
public class ClaimsController {

    @Autowired
    private ClaimService claimService;

    @GetMapping
    public List<Claim> getClaims() {
        return claimService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Claim> getClaimById(@PathVariable Long id) {
        Optional<Claim> claim = claimService.findById(id);
        return claim.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Claim createClaim(@RequestBody Claim claim) {
        return claimService.save(claim);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Claim> updateClaim(@PathVariable Long id, @RequestBody Claim claimDetails) {
        Optional<Claim> optionalClaim = claimService.findById(id);
        if (optionalClaim.isPresent()) {
            Claim claim = optionalClaim.get();
            claim.setClaimNumber(claimDetails.getClaimNumber());
            claim.setPolicyNumber(claimDetails.getPolicyNumber());
            claim.setClaimDate(claimDetails.getClaimDate());
            claim.setClaimAmount(claimDetails.getClaimAmount());
            claim.setStatus(claimDetails.getStatus());
            return ResponseEntity.ok(claimService.save(claim));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClaim(@PathVariable Long id) {
        claimService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
