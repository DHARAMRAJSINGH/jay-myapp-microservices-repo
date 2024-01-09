package com.mycom.vms.userdb.documents;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("user")
public class VmsUser {

    @Id
    private String userId;
    private String username;
    private String password;
    private List<String> roles;

}
