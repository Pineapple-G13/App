package com.pineapple.demo.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long dni;
    @JoinColumn(nullable = false)
    private String username;
    @JoinColumn(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(name = "user_firstname")
    private String firstName;
    @Column(name = "user_lastname")
    private String lastName;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Role role;

    public User() {
    }

    public User(Long dni, String username, String password, String email, String firstName, String lastName, Role role) {
        this.dni = dni;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    
    
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

   
    
    private static final long serialVersionUID = 1L;

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
