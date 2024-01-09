package com.mycom.vms.authorization.service;

import com.mycom.vms.userdb.documents.VmsUser;
import com.mycom.vms.userdb.repo.service.VmsUserRepoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class VmsUserDetailsService implements UserDetailsService {

    private final VmsUserRepoService vmsUserRepoService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        VmsUser vmsUser = vmsUserRepoService.getUserByUsername(username);
        User user;
        if (vmsUser != null) {
            log.info("{}", vmsUser);
            user = fromVmsUser(vmsUser);
            return user;
        }
        return null;
    }

    private User fromVmsUser (VmsUser vmsUser) {
        Collection<GrantedAuthority> authorities = vmsUser.getRoles().stream().map(role -> "ROLE_"+role).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return new User(vmsUser.getUsername(), vmsUser.getPassword(),
                true, true, true, true,
                authorities);
    }
}
