package com.mycom.vms.userdb.repo.service;

import com.mycom.vms.userdb.documents.VmsUser;
import com.mycom.vms.userdb.repo.VmsUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VmsUserRepoServiceImpl implements VmsUserRepoService {

    private final VmsUserRepository vmsUserRepository;

    @Override
    public VmsUser createUser (VmsUser vmsUser) {
        return vmsUserRepository.save(vmsUser);
    }

    @Override
    public List<VmsUser> getUsers() {
        return vmsUserRepository.findAll();
    }

    @Override
    public VmsUser getUser(String userId) {
        return vmsUserRepository.findById(userId).orElseThrow();
    }

    @Override
    public VmsUser getUserByUsername(String username) {
        return vmsUserRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(String userId) {
        vmsUserRepository.deleteById(userId);
    }
}
