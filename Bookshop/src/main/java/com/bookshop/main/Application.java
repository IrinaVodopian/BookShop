package com.bookshop.main;

import com.bookshop.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan
@EnableJpaRepositories
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackageClasses = {Config.class})

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
