package com.proje.web.service;

import org.springframework.stereotype.Service;

import com.proje.web.model.User;
import com.proje.web.model.VerifiticationToken;

@Service
public interface VerifiticationTokenService {

	VerifiticationToken getToken(String token);
	VerifiticationToken createToken(User user, String token);
}
