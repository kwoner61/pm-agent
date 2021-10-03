package com.junghokwon.pmagent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PMAgentController.class)
class PMAgentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PMAgentService service;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getPerfDetailsShouldReturnHostPerformanceDetails() throws Exception {
        when(service.getPerfDetails()).thenReturn(new PMAgentMessage());
        mockMvc.perform(get("/performance")).andExpect(status().isOk());
    }
}
