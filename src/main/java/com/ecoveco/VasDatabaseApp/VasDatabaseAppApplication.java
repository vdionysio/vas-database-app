package com.ecoveco.VasDatabaseApp;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import static java.util.Arrays.stream;


@Log4j2
@SpringBootApplication
@ConfigurationPropertiesScan
public class VasDatabaseAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(VasDatabaseAppApplication.class, args);
    }
}
