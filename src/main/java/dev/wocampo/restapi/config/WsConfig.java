package dev.wocampo.restapi.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import dev.wocampo.soap.client.WsProductsClient;

@Configuration
@AllArgsConstructor
public class WsConfig {

    @Bean
    public WsProductsClient wsCountryClient(WebServiceTemplate template,
            @Value("${products.webservice.url}") String url) {
        return new WsProductsClient(template, url, new SoapActionCallback(""));
    }

}
