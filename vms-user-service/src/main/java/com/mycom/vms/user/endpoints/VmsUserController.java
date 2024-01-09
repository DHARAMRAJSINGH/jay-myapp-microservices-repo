package com.mycom.vms.user.endpoints;

import com.mycom.vms.user.services.VmsUserService;
import com.mycom.vms.userdb.documents.VmsUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RequestMapping("users")
@RequiredArgsConstructor
@RestController
public class VmsUserController {

    private final VmsUserService vmsUserService;

    @PostMapping("")
    public VmsUser createUser (@RequestBody VmsUser vmsUser) {
        return vmsUserService.createUser(vmsUser);
    }

    @GetMapping("")
    public List<VmsUser> getUsers () {
        return vmsUserService.getUsers();
    }

    @GetMapping("{userId}")
    public VmsUser getUser (@PathVariable String userId) {
        return vmsUserService.getUserByUsername(userId);
    }

    @GetMapping(params="username")
    public VmsUser getUserByUsername (@RequestParam("username") String username) {
        return vmsUserService.getUserByUsername(username);
    }

    @DeleteMapping("{userId}")
    public void deleteUser (@PathVariable String userId) {
        vmsUserService.deleteUser(userId);
    }


}
