
###spring boot validator
> bean validator jsr-303  
>版本：  boot 2.1.8  

```
  <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <version>2.1.8.RELEASE</version>
      </dependency>
```

`spring-boot-starter-web自动依赖 bean-validator的默认实现`：  

```
<dependency>
      <groupId>org.hibernate.validator</groupId>
      <artifactId>hibernate-validator</artifactId>
      <version>6.0.17.Final</version>
      <scope>compile</scope>
 </dependency>
```

添加自定义messageSource实现自定义消息模板：  

```
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
```