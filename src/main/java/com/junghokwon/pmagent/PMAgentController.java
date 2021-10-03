package com.junghokwon.pmagent;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class PMAgentController {

    private final PMAgentService service;

    public PMAgentController(PMAgentService service) {
        this.service = service;
    }

    @GetMapping("/performance")
    public PMAgentMessage getPerfDetails() throws IOException, InterruptedException {
        return service.getPerfDetails();
    }

}
