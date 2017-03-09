/*package com.team3.LMS.controller;

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
import com.team3.LMS.service.StaffInfoService;

@Controller
public class StaffInfoController {

	@Autowired
	StaffInfoService service;

	@RequestMapping(value = "/staffInfo/list", method = RequestMethod.GET)
	@ResponseBody
	public List<StaffInfo> getStaffInfoList() {
		return service.getStaffInfoList();
	}

	@RequestMapping(value = "/staffInfo/findAll", method = RequestMethod.GET)
	@ResponseBody
	public Page<StaffInfo> findAll(Pageable pageable) {
		Page<StaffInfo> staffInfos = service.findAll(pageable);
		return staffInfos;
	}

	@RequestMapping(value = "/staffInfo/add", method = RequestMethod.POST)
	public void addStaffInfo(@RequestBody StaffInfo staffInfo) {
		service.addStaffInfo(staffInfo);
	}
	
	@RequestMapping("/staffInfo/remove/{id}")
	public void removeStaffInfo(@PathVariable int id) {
		service.removeStaffInfo(id);
	}
	
	@RequestMapping(value = "/staffInfo/get/{id}", method = RequestMethod.GET)
	@ResponseBody
	public StaffInfo getStaffInfo(@PathVariable int id) {
		return service.getStaffInfo(id);
	}
}
*/