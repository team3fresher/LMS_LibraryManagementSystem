package com.team3.LMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.LMS.dto.StaffInfo;
import com.team3.LMS.dto.UserInfo;
import com.team3.LMS.service.StaffInfoService;

@Controller
@RequestMapping(value = "/staffInfo")
public class StaffInfoController {

	@Autowired
	StaffInfoService service;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<StaffInfo> getStaffInfoList() {
		return service.getStaffInfoList();
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	@ResponseBody
	public Page<StaffInfo> findAll(Pageable pageable) {
		Page<StaffInfo> staffInfos = service.findAll(pageable);
		return staffInfos;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addStaffInfo(@RequestBody StaffInfo staffInfo) {
		service.addStaffInfo(staffInfo);
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public void editStaffInfo(@RequestBody StaffInfo staffInfo, @PathVariable int id) {
		staffInfo.setStaffId(id);
		service.addStaffInfo(staffInfo);
	}
	
	@RequestMapping("/remove/{id}")
	public void removeStaffInfo(@PathVariable int id) {
		service.removeStaffInfo(id);
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	@ResponseBody
	public StaffInfo getStaffInfo(@PathVariable int id) {
		return service.getStaffInfo(id);
	}
}
