package com.pineapple.demo.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="roles")
public class Role implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idRole;
    @Column(nullable = false, unique = true)
	private String roleName;


	//getters and setters
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Long getIdRole() {
		return idRole;
	}
	public void setIdRrole(Long idRole) {
		this.idRole = idRole;
	}
	public String getRoleName() {
		return roleName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

         //mi IDE me generó esta línea en automático, por eso la descomenté. A ver qué hace.
         private static final long serialVersionUID = 1L;


		 //constructor

	public Role() {
	}

	public Role(String roleName) {
		this.roleName = roleName;
	}
}
