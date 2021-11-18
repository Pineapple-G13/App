package com.pineapple.demo.models.service;

import com.pineapple.demo.models.entity.Users;
import com.pineapple.demo.models.enums.Role;
import com.pineapple.demo.models.repository.UserRepository;
import java.time.LocalDate;
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

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    private final String MENSAJE = "El usuario ingresado no existe";

    @Transactional
    public void create(Long dni, String username, String password, String email, String firstName, String lastName, LocalDate fechaCreacion, Role role) {
        //falta validar que el correo ya exite.
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

    @Transactional
    public void modify(String username, String password, String email, String firstName, String lastName) {
        userRepository.modify(username, password, email, firstName, lastName);
    }

    @Transactional
    public List<Users> searchAll() {
        return userRepository.findAll();
    }

    @Transactional
    public Users searchByDni(Integer dni) {
        return userRepository.findById(dni).orElse(null);
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
}
