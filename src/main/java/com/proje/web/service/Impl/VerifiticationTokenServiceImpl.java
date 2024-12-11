package com.proje.web.service.Impl;

import org.springframework.stereotype.Service;

import com.proje.web.exceptions.TokenNotFound;
import com.proje.web.model.User;
import com.proje.web.model.VerifiticationToken;
import com.proje.web.repository.VerifiticationTokenRepository;
import com.proje.web.service.VerifiticationTokenService;


@Service
public class VerifiticationTokenServiceImpl implements VerifiticationTokenService {

	private final VerifiticationTokenRepository repository;
	
	public VerifiticationTokenServiceImpl(VerifiticationTokenRepository repository) {
		
		this.repository = repository;
	}
	
	
	@Override
	public VerifiticationToken getToken(String token) {
		
		
		
		try {
			return repository.findByToken(token);
		}catch(TokenNotFound e)  {
			return null;
		}
		
	}

	@Override
	public VerifiticationToken createToken(User user, String token) {
		VerifiticationToken t = new VerifiticationToken();
		
		t.setUser(user);
		t.setToken(token);
		repository.save(t);
		return t;
		
	}

	
}
