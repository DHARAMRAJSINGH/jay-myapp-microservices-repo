package com.mycom.vms.userdb.repo;


import com.mycom.vms.userdb.documents.VmsUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VmsUserRepository extends MongoRepository<VmsUser, String> {

    VmsUser findByUsername (String username);
}
