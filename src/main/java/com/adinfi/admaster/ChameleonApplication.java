package com.adinfi.admaster;

import com.adinfi.admaster.config.JwtFilter;
import com.adinfi.admaster.util.SendMail;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.servlet.Filter;

@SpringBootApplication
public class ChameleonApplication {

/*	@Bean
	public FilterRegistrationBean jwtFilter(){
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/rest/*");
		return registrationBean;
	} */

	public static void main(String[] args) {

		SpringApplication.run(ChameleonApplication.class, args);
	}
}
