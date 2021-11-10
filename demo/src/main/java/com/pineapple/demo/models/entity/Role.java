package com.pineapple.demo.models.entity;

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
	@Column (name= "id_role")
	private Long idRrole;
	@Column (name = "role_name")
	private String roleName;
	public Long getIdRrole() {
		return idRrole;
	}
	public void setIdRrole(Long idRrole) {
		this.idRrole = idRrole;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private static final long serialVersionUID = 1L;
	

}
