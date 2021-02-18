package com.example.learn;

import com.example.learn.intercept.MyInterceptor;
import com.example.learn.intercept.ProxyBean;
import com.example.learn.service.HelloService;
import com.example.learn.service.impl.HelloServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.*")
@EnableMongoRepositories(basePackages = {"com.example.learn.repository"})
public class LearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnApplication.class, args);
		testProxy();
	}

	public static void testProxy() {
		HelloService helloService = new HelloServiceImpl();
		HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new MyInterceptor());
		proxy.sayHello("zhangsan");
	}

}
