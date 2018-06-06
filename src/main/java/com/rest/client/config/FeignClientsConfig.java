package com.rest.client.config;

import com.rest.client.config.resource.NaiveHostnameVerifier;
import com.rest.client.config.resource.NaiveSSLSocketFactory;
import com.rest.client.feign.RestApiBasic;
import feign.Client;
import feign.Logger;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by EGBoldyr on 22.05.18.
 */

@Configuration
@EnableFeignClients(clients = { RestApiBasic.class })
@ImportAutoConfiguration(FeignAutoConfiguration.class)
public class FeignClientsConfig {

    @Bean
    public Client client() throws NoSuchAlgorithmException, KeyManagementException {
        return new Client.Default(
                new NaiveSSLSocketFactory("https://localhost:15000"),
                new NaiveHostnameVerifier("https://localhost:15000")
        );
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
    
}
