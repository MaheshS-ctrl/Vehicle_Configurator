package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtos.JwtResponse;
import com.example.dtos.LoginRequest;
import com.example.dtos.RegistrationRequest;
import com.example.repository.UserRepository;
import com.example.security.JwtUtil;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
		@Autowired
		private AuthenticationManager authManager;
		
		@Autowired
		private JwtUtil jwtutil;
		
		@Autowired
		private UserDetailsService userdetailservice;
		
		@Autowired
		private UserRepository userRepository;
		
		@Autowired
		private PasswordEncoder passwordEncoder;
		
		@PostMapping("/register")
		public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest request) {
		   
		    if (userRepository.findByUsername(request.getUsername()).isPresent()) {
		        return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
		    }

		    String encodedPassword = passwordEncoder.encode(request.getPassword());
		    com.example.entity.User newUser = new com.example.entity.User();
		    newUser.setUsername(request.getUsername());
		    newUser.setPassword(encodedPassword);
		    newUser.setRole(request.getRole() != null ? request.getRole() : "USER");
		    userRepository.save(newUser);

		    return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
		}
		
		@PostMapping("/login")
		public ResponseEntity<?> login(@RequestBody LoginRequest request, HttpServletResponse response){
			authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
			UserDetails user = userdetailservice.loadUserByUsername(request.getUsername());
			
			String accesstoken = jwtutil.generateAccessToken(user);
			String refreshtoken = jwtutil.generateRefreshToken(user);
			
			Cookie refreshCookie = new Cookie("refreshToken", refreshtoken);
		    refreshCookie.setHttpOnly(true);
		    refreshCookie.setSecure(true);
		    refreshCookie.setPath("/api/auth/refresh");
		    refreshCookie.setMaxAge(7 * 24 * 60 * 60);

		    response.addCookie(refreshCookie); 
			
			return ResponseEntity.ok(new JwtResponse(accesstoken, refreshtoken));
		}
		
		@PostMapping("/refresh")
		public ResponseEntity<?> refreshToken(HttpServletRequest request){
			Cookie[] cookies = request.getCookies();
		    if (cookies == null) {
		        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Refresh token missing");
		    }

		    String refreshToken = null;
		    for (Cookie cookie : cookies) {
		        if ("refreshToken".equals(cookie.getName())) {
		            refreshToken = cookie.getValue();
		            break;
		        }
		    }

		    if (refreshToken == null) {
		        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Refresh token missing");
		    }

		    String username = jwtutil.getUsernameFromToken(refreshToken);

		    if (username == null || !jwtutil.validateToken(refreshToken, userdetailservice.loadUserByUsername(username))) {
		        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid refresh token");
		    }

		    UserDetails user = userdetailservice.loadUserByUsername(username);
		    String newAccessToken = jwtutil.generateAccessToken(user);

		    return ResponseEntity.ok(new JwtResponse(newAccessToken, refreshToken));
		
		}
		
		@PostMapping("/logout")
		public ResponseEntity<?> logout(HttpServletResponse response) {
		    Cookie cookie = new Cookie("refreshToken", null);
		    cookie.setHttpOnly(true);
		    cookie.setSecure(true);
		    cookie.setPath("/api/auth/refresh");
		    cookie.setMaxAge(0);

		    response.addCookie(cookie);
		    return ResponseEntity.ok("Logged out successfully");
		}
		
}
