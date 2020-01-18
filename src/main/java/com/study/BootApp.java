package com.study;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class BootApp {
	
	public static void main(String[] args) {
		// LocalValidatorFactoryBean
		// ReloadableResourceBundleMessageSource

		ConfigurableApplicationContext context = SpringApplication.run(BootApp.class, args);
		Object source = context.getBeansOfType(LocaleResolver.class);
		// DelegatingMessageSource

		System.out.println(source);
	}

//	@Bean
//	public MessageSource messageSource() {
//		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//		messageSource.setBasenames("classpath:messages");
//		messageSource.setDefaultEncoding("UTF-8");
//		messageSource.setCacheSeconds(60);
//		return messageSource;
//	}
//
//	@Bean
//	public LocalValidatorFactoryBean defaultValidator() {
//		LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
//		factoryBean.setValidationMessageSource(messageSource());
//		return factoryBean;
//	}
	
	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localeResolver=new AcceptHeaderLocaleResolver();
		return localeResolver;
	}
}
