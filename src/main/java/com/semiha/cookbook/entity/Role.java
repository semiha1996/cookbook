package com.semiha.cookbook.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.semiha.cookbook.enums.RoleType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "roles")
@EqualsAndHashCode
public class Role implements GrantedAuthority {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "role")
	private RoleType authority;

	@Override
	public String getAuthority() {

		return null;
	}

	public Role(long id, RoleType authority, List<User> users) {
		super();
		this.id = id;
		this.authority = authority;// ==role
	}

	@OneToMany(mappedBy = "userRole", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<User> users;

}
