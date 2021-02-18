package com.example.learn.pojo;

import com.example.learn.pojo.definition.Animal;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {

    @Override
    @Primary
    public void use() {
        System.out.println("狗：" + Dog.class.getSimpleName() + "是看门的");
    }

}
