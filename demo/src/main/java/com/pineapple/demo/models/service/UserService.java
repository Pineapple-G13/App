
package com.pineapple.demo.models.service;

import com.pineapple.demo.models.entity.Role;
import com.pineapple.demo.models.entity.Users;
import com.pineapple.demo.models.repository.UserRepository;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final String MENSAJE = "El usuario ingresado no existe";
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    public void create(Long dni, String username, String password, String email, String firstName, String lastName, Date fechaCreacion, Role role) {
        //falta validar que el correo ya exista.
        //String usernameValidate = username;
        //String emailValidate = email;

        Users user = new Users();

        user.setDni(dni);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        user.setRole(role);
        user.setFechaCreacion(fechaCreacion);
        userRepository.save(user);

    }

    public void modify(String username, String password, String email, String firstName, String lastName) {
        userRepository.modify(username, password, email, firstName, lastName);
    }

    public List<Users> searchAll() {
        return userRepository.findAll();
    }

    @Transactional
    public void delete(Integer id) {
        userRepository.deleteById(id);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.buscarUsuarioPorUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format(MENSAJE, username));

        }
//       User user=userRepository.findByUsername(username).
//               orElseThrow(()->new UsernameNotFoundException(String.format(MENSAJE, username))); 
//             
//    }
        return new User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }

    public void create(String username, Long dni, String password, String email, String firstName, String lastName, Role role, Date fechaCreacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

