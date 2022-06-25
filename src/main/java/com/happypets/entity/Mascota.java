package com.happypets.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_mascota")
public class Mascota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_mascota;
	
	private String nombre_mascota;
	
	private String tipo_mascota;
	
	private String raza_mascota;
	
	private int id_vacunas;
	
	private Date fec_mascota;
	
	private Date fec_nac;

}
