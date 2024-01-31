package com.sist.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//<context:component-scan base-package="com.sist.*"/>
@ComponentScan(basePackages = "com.sist.*")
//<mybatis-spring:scan base-package="com.sist.mapper"
//factory-ref="ssf"
///>
@MapperScan(basePackages = {"com.sist.mapper"})
public class BoardConfig implements WebMvcConfigurer{

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();//HandlerMapping => load
	}
	/*
	 * <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver"
		p:prefix="/"
		p:suffix=".jsp"
	/>
	 * */
	
	/*
	 * <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
		p:driverClassName="#{db['driver']}"
		p:url="#{db['url']}"
		p:username="#{db['username']}"
		p:password="#{db['password']}"
		p:maxActive="#{db['maxActive']}"
		p:maxIdle="#{db['maxIdle']}"
		p:maxWait="#{db['maxWait']}"
	/>
	 * */
	
	/*
	 * <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
		p:dataSource-ref="ds"
	/>
	 * */
}
