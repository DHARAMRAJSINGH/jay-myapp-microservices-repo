package com.mycom.vms.configserver;

import com.jvss.cnp.storage.NameStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class VmsConfigServer {
    public static void main(String[] args) {
        SpringApplication.run(VmsConfigServer.class, args);
        NameStorage.printName("Dharam");
    }
}
