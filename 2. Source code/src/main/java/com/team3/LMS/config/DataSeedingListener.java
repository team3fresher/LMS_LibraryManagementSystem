package com.team3.LMS.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.team3.LMS.dto.Role;
import com.team3.LMS.dto.UserInfo;
import com.team3.LMS.dao.RoleDao;
import com.team3.LMS.dao.UserInfoDao;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private UserInfoDao userRepository;
	
	@Autowired
	private RoleDao roleRepository;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// Roles
		if (roleRepository.findByRoleName("ROLE_ADMIN") == null) {
			roleRepository.save(new Role("ROLE_ADMIN"));
		}
		
		if (roleRepository.findByRoleName("ROLE_MEMBER") == null) {
			roleRepository.save(new Role("ROLE_MEMBER"));
		}
		
		// Admin account
		if (userRepository.findByEmail("admin@gmail.com") == null) {
			UserInfo admin = new UserInfo();
			admin.setRealName("Admin");
			admin.setAddress("District 3");
			admin.setSex("Male");
			admin.setPhoneNumber(12345678);
			admin.setValid((byte) 1);
			admin.setEmail("admin@gmail.com");
			admin.setPword(passwordEncoder.encode("123456"));
			List<Role> roles = new ArrayList<>();
			roles.add(roleRepository.findByRoleName("ROLE_ADMIN"));
			roles.add(roleRepository.findByRoleName("ROLE_MEMBER"));
			admin.setRoles(roles);
			userRepository.save(admin);
		}
		
		// Member account
		if (userRepository.findByEmail("member@gmail.com") == null) {
			UserInfo user = new UserInfo();
			user.setRealName("User");
			user.setAddress("District 9");
			user.setSex("Female");
			user.setPhoneNumber(87654321);
			user.setEmail("member@gmail.com");
			user.setValid((byte) 1);
			user.setPword(passwordEncoder.encode("123456"));
			List<Role> roles = new ArrayList<>();
			roles.add(roleRepository.findByRoleName("ROLE_MEMBER"));
			user.setRoles(roles);
			userRepository.save(user);
		}
	}

}
