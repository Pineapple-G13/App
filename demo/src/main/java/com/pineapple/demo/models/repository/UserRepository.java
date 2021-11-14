
package com.pineapple.demo.models.repository;

import com.pineapple.demo.models.entity.Users;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    
    @Modifying
    @Query("UPDATE Users u SET u.username = :username, u.password =:password, u.email=:email, u.firstName =:firstName, u.lastName =:lastName")
    void modify(@Param ("username")String username,@Param ("password") String password,@Param ("email") String email,@Param ("firstName") String firstName,@Param ("lastName") String lastName);
    
    
    
    @Query("SELECT u FROM Users u WHERE u.username= :username")
    Users buscarUsuarioPorUsername(@Param ("username")String username);
   Optional<Users>findByUsername(String username);
}
