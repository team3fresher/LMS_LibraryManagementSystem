package com.team3.LMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.team3.LMS.dao.UserInfoDao;
import com.team3.LMS.dto.UserInfo;

@Service
public class UserInfoService {
	@Autowired
	private UserInfoDao userInfoDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	public List<UserInfo> getUserInfoList() {
		return (List<UserInfo>) userInfoDao.findAll();
	}

	public UserInfo findByEmail(String email) {
		return userInfoDao.findByEmail(email);
	}
	
	public Page<UserInfo> findAll(Pageable pageable) {
		return userInfoDao.findAll(pageable);
	}

	public void addUserInfo(UserInfo userInfo) {
		String password = userInfo.getPword();
		userInfo.setPword(passwordEncoder.encode(password));
		userInfoDao.save(userInfo);
	}

	public void removeUserInfo(int id) {
		userInfoDao.delete(id);
	}

	public UserInfo getUserInfo(int id) {
		return userInfoDao.findOne(id);
	}
	
	public int getTotalUser() {
		return ((List<UserInfo>) userInfoDao.findAll()).size();
	}
	
	public int getTotalMale() {
		return ((List<UserInfo>) userInfoDao.findBySex("Male")).size();
	}
	
	public int getTotalFemale() {
		return ((List<UserInfo>) userInfoDao.findBySex("Female")).size();
	}
}
