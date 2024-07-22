package com.api.parkingcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ParkingControlApplication {
	private int maxUploadSizeInMb = 10 * 1024 * 1024; // 10 MB
	public static void main(String[] args) {
		SpringApplication.run(ParkingControlApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("@207204Sc"));
	}


	@GetMapping("/Geral")
	public String index(){
		return "Jesus TE AMA!, eu também Romanos 11.36";
	}
}
