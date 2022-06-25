package com.happypets.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	private int id_consulta;

	private int id_empleado;

	private int id_mascota;

	private int id_cliente;

	private int id_detalleConsulta;

	private String razon_consulta;

	private double costo_consulta;
	
	@Temporal(TemporalType.DATE)
	private Date fec_registro;
	
	@Temporal(TemporalType.DATE)
	private Date fec_consulta;
	
}
