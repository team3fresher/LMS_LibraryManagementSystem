package com.team3.LMS.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team3.LMS.dto.Role;
import com.team3.LMS.dto.UserInfo;
import com.team3.LMS.dao.UserInfoDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserInfoDao userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo user = userRepository.findByEmail(username);
		if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		List<Role> roles = user.getRoles();
		for (Role role : roles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		
		return new org.springframework.security.core.userdetails.User(
				user.getEmail(), user.getPword(), grantedAuthorities);
	}

}
