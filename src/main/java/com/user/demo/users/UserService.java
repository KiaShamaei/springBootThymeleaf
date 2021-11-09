package com.user.demo.users;



import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repo ;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }
    public List<User> listAll(){
        return (List<User>) repo.findAll();
    }
    public void saveUser(User user){
        repo.save(user);
    }
    public void deleteById(int id){  repo.deleteById(id);}
}
