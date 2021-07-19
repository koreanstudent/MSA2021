package kr.co.msa.msaconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MsaConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaConfigApplication.class, args);
    }

}
