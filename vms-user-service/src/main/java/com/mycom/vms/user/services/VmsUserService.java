package com.mycom.vms.user.services;

import com.mycom.vms.userdb.documents.VmsUser;
import com.mycom.vms.userdb.repo.service.VmsUserRepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VmsUserService {

    private final VmsUserRepoService vmsUserRepoService;

    public VmsUser createUser (VmsUser vmsUser) {
        return vmsUserRepoService.createUser(vmsUser);
    }
    public List<VmsUser> getUsers () {
        return vmsUserRepoService.getUsers();
    }
    public VmsUser getUser (String userId) {
        return vmsUserRepoService.getUser(userId);
    }
    public VmsUser getUserByUsername (String username) {
        return vmsUserRepoService.getUserByUsername(username);
    }
    public void deleteUser (String userId) {
        vmsUserRepoService.deleteUser(userId);
    }

}
