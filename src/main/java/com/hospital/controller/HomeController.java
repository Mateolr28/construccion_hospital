/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.hospital.entity.User;
import com.hospital.repository.UserRepo;
import com.hospital.service.UserService;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepo userRepo;

	@ModelAttribute
	public void commonUser(Principal p, Model m) {

		if (p != null) {
			String email = p.getName();
			User user = userRepo.findByEmail(email);
			m.addAttribute("user", user);
		}
	}

	@GetMapping(path = { "/", "/index" })
	public String index() {

		return "index";
	}

	@GetMapping("/habitaciones")
    public String habitaciones() {
        return "habitaciones";
    }

    @GetMapping("/servicios")
    public String servicios() {
        return "servicios";
    }

    @GetMapping("/quienes-somos")
    public String quienesSomos() {
        return "quienes-somos";
    }
	@GetMapping("/empleado")
    public String empleado() {
        return "empleado";
    }
	

	@GetMapping("/register")
	public String register() {

		return "register";
	}

	@GetMapping("/signin")
	public String login() {

		return "login";
	}

	@GetMapping("/user/profile")
	public String profile(Principal p, Model m) {

		String email = p.getName();

		User user = userRepo.findByEmail(email);
		m.addAttribute("user", user);
		System.out.println("Successfully logged in.");
		return "profile";
	}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute User user, HttpSession session, Model m) {

		// System.out.println(user);

		User u = userService.CreateUser(user);

		if (u != null) {
			// System.out.println("save sucess");
			session.setAttribute("msg", "Register successfully");

		} else {
			// System.out.println("error in server");
			session.setAttribute("msg", "Something wrong server");
		}
		return "redirect:/register";
	}

}