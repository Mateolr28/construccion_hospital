/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.service;

import com.hospital.entity.User;

public interface UserService {

	public User CreateUser(User user);

	public void removeSessionMessage();

}
