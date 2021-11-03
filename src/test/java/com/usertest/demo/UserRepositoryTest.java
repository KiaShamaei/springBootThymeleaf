package com.usertest.demo;


import com.usertest.demo.users.User;
import com.usertest.demo.users.UserRepository;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
    @Autowired private UserRepository repo ;
    @Test
    public  void TestAddNew(){
        User user = new User();
        user.setEmail("kia@gmail.com");
        user.setPassword("1234");
        user.setFirstName("kia");
        user.setLastName("kiaeee");
        User savedUser = repo.save(user);
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }
    @Test
    public void testListAll() {
        Iterable<User> users = repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);
        for (User user: users) {
            System.out.println(users.toString());

        }
    }
    @Test
    public void testUpdate(){
        Integer userId = 1 ;
        Optional <User> optionalUser = repo.findById(userId);
        User user= optionalUser.get();
        user.setPassword("helll0world");
        repo.save(user) ;

        User updateUsesr = repo.findById(userId).get();
        Assertions.assertThat(updateUsesr.getPassword()).isEqualTo("helll0world");

    }
}
