package com.mycom.vms.authorization.endpoints;

import com.mycom.vms.authorization.service.SecurityContextService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Slf4j
@RequiredArgsConstructor
@RestController
public class TestController {

    private final SecurityContextService securityContextService;

    @GetMapping("admin")
    public String admin () {
        return "admin role";
    }

    @GetMapping("users")
    public String user () {
        log.info("authentication : {}", securityContextService.getAuthentication());
        return "user role";
    }

    @GetMapping("")
    public String defaultPage () {
        return "default page";
    }

}
