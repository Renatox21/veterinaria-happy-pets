package com.happypets.entity;

import java.sql.Date;

import javax.persistence.Column;
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
@Table(name = "tb_consulta")
public class Cita {

	@Id
	@Column(name="id_consulta")
	private int id_consulta;

	@Column(name="id_empleado")
	private int id_empleado;

	@Column(name="id_mascota")
	private int id_mascota;

	@Column(name="id_cliente")
	private int id_cliente;

	@Column(name="id_detalleConsulta")
	private int id_detalleConsulta;

	@Column(name="razon_consulta")
	private String razon_consulta;

	@Column(name="costo_consulta")
	private double costo_consulta;
		
	@Column(name="fec_registro")
	private Date fec_registro;
	
	@Column(name="fec_consulta")
	private Date fec_consulta;
	
}