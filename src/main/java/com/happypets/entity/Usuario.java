package com.happypets.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_usuario")
public class Usuario {

	@Id
	private String user;
	
	private String password;
	
	private String cargo;
	
	
}
