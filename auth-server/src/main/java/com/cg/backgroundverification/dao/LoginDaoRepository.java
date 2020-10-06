package com.cg.backgroundverification.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.backgroundverification.entity.LoginDto;

@Repository
public interface LoginDaoRepository extends JpaRepository<LoginDto, Integer> {
	@Query("select l from LoginDto l  where l.empId=?1 and l.password=?2 and l.roleId=?3")
	public LoginDto authentication(int empId, String password, int roleid);

}
