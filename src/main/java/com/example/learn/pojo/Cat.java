package com.example.learn.pojo;

import com.example.learn.pojo.definition.Animal;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Cat implements Animal {

    @Override
    public void use() {
        System.out.println("猫：" + Cat.class.getSimpleName() + "是抓老鼠的");
    }

}
