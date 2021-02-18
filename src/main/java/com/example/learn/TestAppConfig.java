package com.example.learn;


import com.example.learn.configuration.AppCofig;
import com.example.learn.configuration.UserBean;
import com.example.learn.pojo.BusinessPerson;
import com.example.learn.pojo.User;
import com.example.learn.pojo.definition.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class TestAppConfig {

    private static Logger log = Logger.getLogger(TestAppConfig.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCofig.class);
        User user = ctx.getBean(User.class);
        log.info(user.getId().toString());

        UserBean userBean = ctx.getBean(UserBean.class);
        UserBean userBean1 = ctx.getBean(UserBean.class);
        log.info(userBean.getId().toString());
        System.out.println(userBean == userBean1);

        Person person = ctx.getBean(BusinessPerson.class);
        person.service();


        //
        // // ctx.close(); // 测试销毁的声明周期

    }

}
