package com.optisure.insurancemanagement.claim;

import com.optisure.insurancemanagement.claim.ClaimService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ClaimsControllerTest {

    @MockBean
    @SuppressWarnings("unused")
    private ClaimService claimService;

    @Test
    public void contextLoads() {
    }
}
