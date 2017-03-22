package com.team3.LMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.team3.LMS.WebApplication;
import com.team3.LMS.dao.RuleDao;
import com.team3.LMS.dto.Rule;

@Service
public class RuleService {
	@Autowired
	private RuleDao ruleDao;
	
	public List<Rule> getRuleList() {
		return (List<Rule>) ruleDao.findAll();
	}

	public Page<Rule> findAll(Pageable pageable) {
		return ruleDao.findAll(pageable);
	}

	public void addRule(Rule rule) {
		ruleDao.save(rule);
	}

	public void removeRule(Integer id) {
		ruleDao.delete(id);
	}

	public Rule getRule(Integer id) {
		return  ruleDao.findOne(id);
	}
	
	public int getLimit(){
		return WebApplication.LIMIT;
	}
	
	public void updateLimit(int newValue){
		WebApplication.LIMIT = newValue;
	}
}
