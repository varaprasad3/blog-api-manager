package com.subhashree.payload;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
	@Getter
	@Setter
	public class UserDto {

		private int id;
		private String name;
		private String email;
		private String password;
		 private String about; 
		 private Date   date ;
		
	}


