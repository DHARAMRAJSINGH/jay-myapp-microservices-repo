package com.mycom.vms.authorization.service;

import com.mycom.vms.authorization.model.LoginUserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final SecurityContextService securityContextService;

    public void authenticate (@RequestBody LoginUserDto userDto) {
        log.info("{}", userDto);
        UsernamePasswordAuthenticationToken token =
                UsernamePasswordAuthenticationToken.unauthenticated(userDto.getUsername(), userDto.getPassword());
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(token);
            securityContextService.setAuthentication(authentication);
        } catch (AuthenticationException e) {
            log.error(e.getMessage());
            throw e;
        }
    }

    public void invalidate () {
        securityContextService.clearSecurityContext();
    }



}
