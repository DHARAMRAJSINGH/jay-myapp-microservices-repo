package com.mycom.vms.gateway.endpoints;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class GatewayTestController {

    @GetMapping("/api/employees")
    public String test () {
        return "gateway ";
    }

}
