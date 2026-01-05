package com.optisure.insurancemanagement.premium;

import com.optisure.insurancemanagement.premium.dto.PremiumDto;
import com.optisure.insurancemanagement.premium.dto.PremiumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/premiums")
public class PremiumController {

    @Autowired
    private PremiumService premiumService;

    @Autowired
    private PremiumMapper premiumMapper;

    @GetMapping
    public List<PremiumDto> getPremiums() {
        return premiumService.findAll().stream()
                .map(premiumMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PremiumDto> getPremiumById(@PathVariable Long id) {
        return premiumService.findById(id)
                .map(premiumMapper::toDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PremiumDto createPremium(@RequestBody PremiumDto premiumDto) {
        Premium premium = premiumMapper.toEntity(premiumDto);
        return premiumMapper.toDto(premiumService.save(premium));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PremiumDto> updatePremium(@PathVariable Long id, @RequestBody PremiumDto premiumDetails) {
        return premiumService.findById(id)
                .map(existingPremium -> {
                    Premium premiumToUpdate = premiumMapper.toEntity(premiumDetails);
                    premiumToUpdate.setId(existingPremium.getId());
                    return ResponseEntity.ok(premiumMapper.toDto(premiumService.save(premiumToUpdate)));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePremium(@PathVariable Long id) {
        premiumService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
