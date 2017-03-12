package com.team3.LMS.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.team3.LMS.dto.StaffInfo;

@Repository
public interface StaffInfoDao extends CrudRepository<StaffInfo, Integer> {
	Page<StaffInfo> findAll(Pageable pageable);
}
