package com.mycom.vms.authorization.endpoints;

import com.mycom.vms.authorization.model.LoginUserDto;
import com.mycom.vms.authorization.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.*;

@CrossOrigin({"http://localhost:4200/"})
@Slf4j
@RequiredArgsConstructor
@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("auth/login")
    public void authenticate (@RequestBody LoginUserDto userDto) {
        log.info("{}", userDto);
        authenticationService.authenticate(userDto);
    }

    @PostMapping("invalidate")
    public void invalidate () {
        authenticationService.invalidate();
    }

    @GetMapping("/users/current/user")
    public String currentUser (@CurrentSecurityContext SecurityContext securityContext) {
        return securityContext.getAuthentication().getName();
    }

    @GetMapping("auth/test")
    public String test () {
        return "inside auth";
    }
}
