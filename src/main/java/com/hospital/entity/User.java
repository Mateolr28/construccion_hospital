/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;

	@NotNull(message = "user name should not be null")
	@NotBlank(message = "user name should not be blank")
	@NotEmpty(message = "user name should not be empty")
	@Column(name = "user_name")
	private String name;

	@NotNull(message = "user email should not be null")
	@NotBlank(message = "user email should not be blank")
	@NotEmpty(message = "user email should not be empty")
	@Column(name = "user_email")
	private String email;

	@NotNull(message = "user mobile should not be null")
	@NotBlank(message = "user mobile should not be blank")
	@NotEmpty(message = "user mobile should not be empty")
	@Column(name = "user_mobile")
	private String mobileNo;

	@NotNull(message = "user password should not be null")
	@NotBlank(message = "user password should not be blank")
	@NotEmpty(message = "user password should not be empty")
	@Column(name = "user_password")
	private String password;
	
	@Column(name = "user_role")
	private String role;

	public User() {
		super();

	}

	public User(int id, String name, String email, String mobileNo, String password) {

		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", mobileNo=" + mobileNo + ", password="
				+ password + "]";
	}

}