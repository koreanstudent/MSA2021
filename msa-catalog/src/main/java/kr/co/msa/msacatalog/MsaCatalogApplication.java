package kr.co.msa.msacatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsaCatalogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaCatalogApplication.class, args);
    }

}
