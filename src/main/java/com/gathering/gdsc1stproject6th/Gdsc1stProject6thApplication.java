package com.gathering.gdsc1stproject6th;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Gdsc1stProject6thApplication {

    public static void main(String[] args) {
        SpringApplication.run(Gdsc1stProject6thApplication.class, args);
    }

}
