package com.user.demo.users;



import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public User get(int id) throws UserNotFoundException{
        Optional <User> result = repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }else {
            throw new UserNotFoundException("User not found base on this Id !");
        }
    }
    public void deleteById(int id){  repo.deleteById(id);}
}
