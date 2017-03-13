package com.team3.LMS.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.team3.LMS.dto.TicketBookUser;
import com.team3.LMS.dto.TicketBookUserPK;

@Repository
public interface TicketBookUserDao extends CrudRepository<TicketBookUser, TicketBookUserPK> {
}
