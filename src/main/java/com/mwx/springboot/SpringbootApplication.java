package com.mwx.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@SpringBootApplication

//这个注解相当于 Configuration,EnableAutoConfiguration,ComponentSacn
public class SpringbootApplication {

//
//	@Bean
//	public RmiProxyFactoryBean rmiProxyFactoryBean(){
//		System.setSecurityManager(new java.rmi.RMISecurityManager());
//		RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
//		rmiProxyFactoryBean.setServiceUrl("rmi://localhost:1099/GroupPurchaseManagementSystem");
//		rmiProxyFactoryBean.setServiceInterface(GroupPurchaseManagementSystem.class);
//		return rmiProxyFactoryBean;
//
//	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
