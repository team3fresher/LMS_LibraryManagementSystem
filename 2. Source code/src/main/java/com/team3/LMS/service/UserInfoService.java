/*package com.team3.LMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.team3.LMS.dao.UserInfoDao;
import com.team3.LMS.dto.UserInfo;

@Service
public class UserInfoService {
	@Autowired
	private UserInfoDao userInfoDao;

	public List<UserInfo> getUserInfoList() {
		return (List<UserInfo>) userInfoDao.findAll();
	}

	public Page<UserInfo> findAll(Pageable pageable) {
		return userInfoDao.findAll(pageable);
	}

	public void addUserInfo(UserInfo userInfo) {
		userInfoDao.save(userInfo);
	}

	public void removeUserInfo(int id) {
		userInfoDao.delete(id);
	}

	public UserInfo getUserInfo(int id) {
		return userInfoDao.findOne(id);
	}
}
*/