package com.sist.config;

import java.io.Reader;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
//<context:component-scan base-package="com.sist.*"/>
@ComponentScan(basePackages = "com.sist.*")
//<mybatis-spring:scan base-package="com.sist.mapper"
//factory-ref="ssf"
///>
@MapperScan(basePackages = {"com.sist.mapper"})
/*
 * 		세팅 => 인식 (DispatcherServlet)
 * 		주문 ========> 서빙(DispatcherServlet) ========> 주방(Model)
 *      배달(ViewResolver) <======= 음     식<======== HandlerMapping
 *               |직접 => JSP 생성 없이 처리
 *               |간접 => 새로운 JSP 생성 
 *      ===================================================
 *      JSP : Front / Back => 매칭이 어렵다. => HTML / SQL(JPA)
 *      @Table(name="board")
 *      class Board{
 *      	@Id
 *      	private int no;
 *      }
 *      
 *      Mobx => React (Spring)
 * */
@EnableAspectJAutoProxy
@PropertySource("/WEB-INF/config/db.properties")
public class BoardConfig implements WebMvcConfigurer{
	@Value("${driver}")
	private String drivername;
	@Value("${url}")
	private String url;
	@Value("${name}")
	private String username;
	@Value("${password}")
	private String pwd;
	
	
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
	@Bean("viewResolver")
	
	public ViewResolver viewResolver() {
		InternalResourceViewResolver ir = new InternalResourceViewResolver();
		
		ir.setPrefix("/");
		ir.setSuffix(".jsp");
		
		return ir;
	}
	@Bean("multipartResolver")//다중 파일 업로드
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		
		multipartResolver.setDefaultEncoding("UTF-8");
		multipartResolver.setMaxUploadSizePerFile(100*1024*1024);//100Mb 파일 크기 변경
		
		return multipartResolver;
	}
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
	
	@Bean("ds")
	public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(drivername);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(pwd);
		ds.setMaxActive(50);
		ds.setMaxIdle(20);
		ds.setMaxWait(-1);
		return ds;
	}
	/*
	 * <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
		p:dataSource-ref="ds"
	/>
	 * */
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Throwable{
		SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		
		return ssf.getObject();
	}
}
