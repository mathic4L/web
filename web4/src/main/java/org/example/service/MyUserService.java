package org.example.service;

import org.example.entity.MyUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface MyUserService extends UserDetailsService
//        extends UserDetailsService
{

    public List<MyUser> getAllUsers();
    public MyUser getUserById(Long id);
    public MyUser updateUser(MyUser myUser);
    public MyUser createUser(MyUser myUser);
    public void deleteUser(Long id);
}
