package kr.co.msa.msauser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsaUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaUserApplication.class, args);
	}

}
