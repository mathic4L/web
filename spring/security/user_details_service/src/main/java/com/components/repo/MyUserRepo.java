package com.components.repo;

import com.components.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepo extends JpaRepository<MyUser, Long> {
    MyUser findByUsername(String name);
}
