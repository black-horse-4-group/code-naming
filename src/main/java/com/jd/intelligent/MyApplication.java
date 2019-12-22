package com.jd.intelligent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @author zhengzheng.qiao
 */
@SpringBootApplication
@ComponentScan("com.jd.intelligent")
@PropertySource(value = {"classpath:config.properties"}, ignoreResourceNotFound = true, encoding = "utf-8")
public class MyApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MyApplication.class);
	}

}
