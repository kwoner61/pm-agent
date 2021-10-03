package com.junghokwon.pmagent;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.junghokwon.pmagent.PMAgentConstants.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PMAgentServiceTest {

    private static PMAgentService service;

    @BeforeAll
    static void setUp() {
        service = new PMAgentService();
    }

    @Test
    void getPerfDetails() throws IOException, InterruptedException {
        PMAgentMessage result = service.getPerfDetails();
        assertNotNull(result);
        assertNotNull(result.getUuid());
        assertNotNull(result.getTimestamp());
    }

    @Test
    void execCommandOnHostForMaxMemory() throws IOException, InterruptedException {
        String result = service.execCommandOnHost(GET_MAX_MEM);
        assertTrue(result.contains("TotalPhysicalMemory"), result);
    }

    @Test
    void execCommandOnHostForFreeMemory() throws IOException, InterruptedException {
        String result = service.execCommandOnHost(GET_FREE_MEM);
        assertTrue(result.contains("FreePhysicalMemory"), result);
    }

    @Test
    void execCommandOnHostForCpu() throws IOException, InterruptedException {
        String result = service.execCommandOnHost(GET_CPU_LOAD);
        assertTrue(result.contains("LoadPercentage"), result);
    }

    @Test
    void getCpuUsage() throws IOException, InterruptedException {
        int result = service.getCpuUsage();
        assertTrue(result > -1);
    }

    @Test
    void getMemUsage() throws IOException, InterruptedException {
        int result = service.getMemUsage();
        assertTrue(result > -1);
    }
}
