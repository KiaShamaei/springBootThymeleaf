package com.usertest.demo.users;


import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length=45 , unique = true)
    private String email ;
    @Column(nullable = false , length = 15)
    private String password ;
    @Column(nullable = false, name="first_name" , length = 45)
    private String firstName ;
    @Column(nullable = false , name ="last_name" , length = 45)
    private  String lastName ;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}