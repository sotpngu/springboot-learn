package com.example.learn.pojo;

import com.example.learn.converter.SexConverter;
import com.example.learn.enumeration.SexEnum;

import javax.persistence.*;

// 标明是一个实体类
@Entity(name = "JpaUser")
// 定义映射的表
@Table(name = "t_user")
public class JpaUser {

    // 标明主键
    @Id
    // 主键策略，递增
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(name = "user_name")
    private String userName = null;

    @Column(name = "note")
    private String note = null;

    // 定义转换器
    @Convert(converter = SexConverter.class)
    private SexEnum sex = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }
}
