package com.cg.backgroundverification.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.backgroundverification.entity.Verification;

/**
 * Verification Repository.
*/


@Repository
public interface VerificationRepo extends JpaRepository<Verification, Integer> {
	
	
}
