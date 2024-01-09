package com.mycom.vms.authorization.service;

import org.springframework.security.core.Authentication;

public interface SecurityContextService {

    void setAuthentication (Authentication authentication);
    Authentication getAuthentication ();
    void clearSecurityContext ();
}
