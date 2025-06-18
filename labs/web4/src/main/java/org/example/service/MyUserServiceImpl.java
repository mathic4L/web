package org.example.service;

import org.example.entity.MyUser;
import org.example.repository.MyUserRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MyUserServiceImpl implements MyUserService {
    private final MyUserRepo myUserRepo;

    public MyUserServiceImpl(MyUserRepo myUserRepo) {
        this.myUserRepo = myUserRepo;
    }

    @Override
    public List<MyUser> getAllUsers() {
        return myUserRepo.findAll();
    }

    @Override
    public MyUser getUserById(Long id) {
        return myUserRepo.findById(id).orElse(null);
    }

    @Override
    public MyUser updateUser(MyUser myUser) {
        return myUserRepo.save(myUser);
    }

    @Override
    public MyUser createUser(MyUser myUser) {
        return myUserRepo.save(myUser);
    }

    @Override
    public void deleteUser(Long id) {
        myUserRepo.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return myUserRepo.findByUsername(username).orElseThrow(
                ()->new UsernameNotFoundException("User not found"));

    }
}
