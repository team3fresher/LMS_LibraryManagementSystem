/*package com.team3.LMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.team3.LMS.dao.StaffInfoDao;
import com.team3.LMS.dto.StaffInfo;

@Service
public class StaffInfoService {
	@Autowired
	private StaffInfoDao staffInfoDao;

	public List<StaffInfo> getStaffInfoList() {
		return (List<StaffInfo>) staffInfoDao.findAll();
	}

	public Page<StaffInfo> findAll(Pageable pageable) {
		return staffInfoDao.findAll(pageable);
	}

	public void addStaffInfo(StaffInfo staffInfo) {
		staffInfoDao.save(staffInfo);
	}

	public void removeStaffInfo(int id) {
		staffInfoDao.delete(id);
	}

	public StaffInfo getStaffInfo(int id) {
		return staffInfoDao.findOne(id);
	}
}
*/