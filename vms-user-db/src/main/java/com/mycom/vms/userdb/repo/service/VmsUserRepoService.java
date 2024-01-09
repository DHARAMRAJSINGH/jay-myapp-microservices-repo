package com.mycom.vms.userdb.repo.service;

import com.mycom.vms.userdb.documents.VmsUser;

import java.util.List;

public interface VmsUserRepoService {

    public VmsUser createUser (VmsUser vmsUser);
    public List<VmsUser> getUsers ();
    public VmsUser getUser (String userId);
    public VmsUser getUserByUsername  (String username);
    public void deleteUser (String userId);

}
