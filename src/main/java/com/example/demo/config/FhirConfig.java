package com.example.demo.config;


import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.client.api.ServerValidationModeEnum;
import ca.uhn.fhir.rest.client.interceptor.LoggingInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FhirConfig {
    @Value("${fhir.serverBase}")
    private String fhirServerBase;

    @Bean
    public FhirContext fhirContext() {
        FhirContext newContext = FhirContext.forR4();
        newContext.getRestfulClientFactory().setServerValidationMode(ServerValidationModeEnum.NEVER);
        return newContext;
    }

    @Bean
    public IGenericClient iGenericClient() {
        FhirContext ctx = FhirContext.forR4();
        IGenericClient fhirClient = ctx.newRestfulGenericClient(this.fhirServerBase);
        fhirClient.registerInterceptor(new LoggingInterceptor(true));
        return fhirClient;
    }



}