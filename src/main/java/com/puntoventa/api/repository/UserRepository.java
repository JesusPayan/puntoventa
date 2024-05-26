package com.puntoventa.api.repository;

import com.puntoventa.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    public List<User> findAllUserByActiveTrueAndDeleteDateNull();
    public User findByuserID(String uuid);
}
