package com.proje.web.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proje.web.model.VerifiticationToken;

@Repository
public interface VerifiticationTokenRepository extends JpaRepository<VerifiticationToken, Long>{

	
	VerifiticationToken findByToken(String token);
}
