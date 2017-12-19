package com.springboot.repository;

import com.springboot.domain.User;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;

import java.util.List;

public interface UserRepository extends JpaEntityInformation<User, Long> {

    User findByName(String name);

    List<User> findByNameOrPhone(String name, String phone);
}
