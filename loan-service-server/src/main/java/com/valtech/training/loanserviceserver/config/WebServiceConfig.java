package com.valtech.training.loanserviceserver.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valtech.training.loanserviceserver.services.LoanService;
import com.valtech.training.loanserviceserver.webservices.LoanServiceWSImpl;


import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class WebServiceConfig {
    
    @Autowired
    private Bus bus; 

    @Bean
    public Endpoint loanServiceWS(LoanService loanService) {
        EndpointImpl endpoint = new EndpointImpl(bus, new LoanServiceWSImpl(loanService));
        endpoint.setAddress("/loanService");
        endpoint.publish();
        return endpoint;
        
    }
}