package com.proje.web.mapper;

import com.proje.web.dto.UserDTO;
import com.proje.web.model.User;

public class UserMapper {
	
	public static User DTOtoModel(UserDTO model) {
	
		return  User.builder()
				.id(model.getId())
				.firstname(model.getFirstname())
				.lastname(model.getLastname())
				.username(model.getUsername())
				.password(model.getPassword())
				.email(model.getEmail())
				
				.build();
				
			
		
	}
	
	public static UserDTO ModeltoDto(User model) {
			
		return  UserDTO.builder()
				.id(model.getId())
				.firstname(model.getFirstname())
				.lastname(model.getLastname())
				.username(model.getUsername())
				.password(model.getPassword())
			
				.email(model.getEmail())
				.build();
				
			
		
	}
}
