package com.optisure.insurancemanagement.premium;

import com.optisure.insurancemanagement.model.Premium;
import com.optisure.insurancemanagement.service.PremiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/premiums")
public class PremiumController {

    @Autowired
    private PremiumService premiumService;

    @GetMapping
    public List<Premium> getPremiums() {
        return premiumService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Premium> getPremiumById(@PathVariable Long id) {
        Optional<Premium> premium = premiumService.findById(id);
        return premium.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Premium createPremium(@RequestBody Premium premium) {
        return premiumService.save(premium);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Premium> updatePremium(@PathVariable Long id, @RequestBody Premium premiumDetails) {
        Optional<Premium> optionalPremium = premiumService.findById(id);
        if (optionalPremium.isPresent()) {
            Premium premium = optionalPremium.get();
            premium.setPolicyNumber(premiumDetails.getPolicyNumber());
            premium.setPremiumAmount(premiumDetails.getPremiumAmount());
            premium.setDueDate(premiumDetails.getDueDate());
            premium.setPaymentDate(premiumDetails.getPaymentDate());
            return ResponseEntity.ok(premiumService.save(premium));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePremium(@PathVariable Long id) {
        premiumService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
