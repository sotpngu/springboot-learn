package com.example.learn;

import com.example.learn.aspect.MyAspect;
import com.example.learn.aspect.MyAspect1;
import com.example.learn.aspect.MyAspect2;
import com.example.learn.aspect.MyAspect3;
import com.example.learn.intercept.MyInterceptor;
import com.example.learn.intercept.ProxyBean;
import com.example.learn.service.HelloService;
import com.example.learn.service.impl.HelloServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"com.example.*"})
//@ComponentScan(basePackages = "com.example.*")
@EnableMongoRepositories(basePackages = {"com.example.learn.repository"})
public class LearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnApplication.class, args);

		// 测试拦截器
		//testProxy();
	}

	// 测试拦截器
	//public static void testProxy() {
	//	HelloService helloService = new HelloServiceImpl();
	//	HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new MyInterceptor());
	//	proxy.sayHello("zhangsan");
	//}

	// 定义切面
	@Bean(name = "myAspect")
	public MyAspect initMyAspect() {
		return new MyAspect();
	}

	// 定义多个切面
	@Bean(name = "myAspect1")
	public MyAspect1 initMyAspect1() {
		return new MyAspect1();
	}
	@Bean(name = "myAspect2")
	public MyAspect2 initMyAspect2() {
		return new MyAspect2();
	}
	@Bean(name = "myAspect3")
	public MyAspect3 initMyAspect3() {
		return new MyAspect3();
	}

}
