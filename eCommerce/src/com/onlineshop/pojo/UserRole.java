package com.onlineshop.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
public class UserRole implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_role_id")
	private Long userRoleId;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User roleUser;

	@Column(name = "role")
	private String role;

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public User getRoleUser() {
		return roleUser;
	}

	public void setRoleUser(User roleUser) {
		this.roleUser = roleUser;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
