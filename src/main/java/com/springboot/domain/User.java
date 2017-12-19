package com.springboot.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class User {

    @NotEmpty(message = "用户名不能为空")
    @Id
    @GeneratedValue
    private String name;

    @Max(value = 100, message = "年龄不能大于 100 岁")
    @Min(value = 18, message = "必须年满 18 岁！")
    @Column(nullable = false, unique = true)
    private int age;

    @Transient
    @NotEmpty(message = "号码不能为空")
    @Length(min = 8, message = "手机号至少8位")
    @Column(nullable = false)
    private String phone;

    @NotEmpty(message = "密码不能为空")
    @Length(min = 6, message = "密码至少6位")
    @Column(nullable = false)
    private String pass;

    @Column(nullable = false)
    private String regTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

}
