package com.happypets.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.SqlDateDeserializer;

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
	@Column(name = "id_mascota")
	private int id_mascota;
	
	@Column(name = "nombre_mascota")
	private String nombre_mascota;
	
	@Column(name = "tipo_mascota")
	private String tipo_mascota;
	
	@Column(name = "raza_mascota")
	private String raza_mascota;
	
	@Column(name = "id_vacunas")
	private int id_vacunas;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@JsonDeserialize(using = SqlDateDeserializer.class)
	@Temporal(TemporalType.DATE)
	@Column(name = "fec_mascota")
	private Date fec_mascota;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@JsonDeserialize(using = SqlDateDeserializer.class)
	@Temporal(TemporalType.DATE)
	@Column(name = "fec_nac")
	private Date fec_nac;

}
