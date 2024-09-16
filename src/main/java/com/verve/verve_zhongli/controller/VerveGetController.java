package com.verve.verve_zhongli.controller;

import com.verve.verve_zhongli.service.FireEndpointService;
import com.verve.verve_zhongli.service.IdCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerveGetController {

    private final FireEndpointService fireEndpointService;

    private final IdCountService idCountService;

    @Autowired
    public VerveGetController(FireEndpointService fireEndpointService, IdCountService idCountService) {
        this.fireEndpointService = fireEndpointService;
        this.idCountService = idCountService;
    }

    @GetMapping("/api/verve/accept")
    public String verveAccept(@RequestParam("id") String id,
                              @RequestParam(value = "endpoint", required = false) String endpoint) {
        if (endpoint != null) {
            fireEndpointService.fire(endpoint);
        }
        idCountService.record(id);
        return "ok";
    }
}
