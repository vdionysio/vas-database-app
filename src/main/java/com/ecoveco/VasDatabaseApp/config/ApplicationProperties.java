package com.ecoveco.VasDatabaseApp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Value;

@Value
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {

    private String clientOriginUrl;

    private String audience;
}