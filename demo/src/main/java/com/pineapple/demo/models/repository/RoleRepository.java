
package com.pineapple.demo.models.repository;

import com.pineapple.demo.models.entity.ProductCategory;
import com.pineapple.demo.models.entity.Role;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    //@Modifying
    //@Query(Update Role r SET r.roleName = :roleName)
    @Modifying
    @Query("UPDATE Role r SET r.roleName = :roleName WHERE r.idRole = :idRole")
    void modify(@Param("roleName") String roleName, @Param("idRole") Long idRole);
    
}