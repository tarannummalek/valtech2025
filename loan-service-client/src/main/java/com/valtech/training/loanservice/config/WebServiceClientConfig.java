package com.valtech.training.loanservice.config;

import javax.xml.namespace.QName;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valtech.training.loanserviceserver.webservices.LoanServiceWS;
@Configuration
public class WebServiceClientConfig {
	@Bean
	public LoanServiceWS createLoanService() {
		System.out.println("Create Loan Service ...");
		JaxWsProxyFactoryBean proxy=new JaxWsProxyFactoryBean();
		proxy.setServiceClass(LoanServiceWS.class);
		proxy.setServiceName(new QName("http://webservices.loanserviceserver.training.valtech.com","LoanServiceWSImplService"));
		proxy.setAddress("http://localhost:8081/services/loanService");
		return proxy.create(LoanServiceWS.class);

	}

}
