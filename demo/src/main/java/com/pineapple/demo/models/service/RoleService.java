/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pineapple.demo.models.service;

import com.pineapple.demo.models.entity.Product;
import com.pineapple.demo.models.entity.ProductCategory;
import com.pineapple.demo.models.entity.Role;
import com.pineapple.demo.models.repository.UserRepository;
import com.pineapple.demo.models.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Garcia, Valdés
 */
public class RoleService {

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void create(String roleName){
        Role role = new Role();
        role.setRoleName(roleName);
    }
    @Transactional
    public void modifyRole(String roleName){
        roleRepository.modify(roleName);
    }

    @Transactional(readOnly = true)
    public List<Role> searchall(){
        return roleRepository.findAll();
    }

    @Transactional
    public Role getById(Long idRole){
        Optional<Role> roleOptional = roleRepository.findById(idRole);
        return  roleOptional.orElse(null);
    }

    @Transactional
    public void delete(Long idRole){
        roleRepository.deleteById(idRole);
    }

}
