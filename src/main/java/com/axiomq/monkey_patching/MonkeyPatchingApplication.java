package com.axiomq.monkey_patching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MonkeyPatchingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonkeyPatchingApplication.class, args);
    }

}
