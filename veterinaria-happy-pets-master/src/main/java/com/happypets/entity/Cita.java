package com.happypets.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
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

	private String fec_registro;

	private String fec_consulta;

	public Cita() {
	}

	public Cita(int id_consulta, int id_empleado, int id_mascota, int id_cliente, int id_detalleConsulta,
			String razon_consulta, double costo_consulta, String fec_registro, String fec_consulta) {
		this.id_consulta = id_consulta;
		this.id_empleado = id_empleado;
		this.id_mascota = id_mascota;
		this.id_cliente = id_cliente;
		this.id_detalleConsulta = id_detalleConsulta;
		this.razon_consulta = razon_consulta;
		this.costo_consulta = costo_consulta;
		this.fec_registro = fec_registro;
		this.fec_consulta = fec_consulta;
	}

	public int getId_consulta() {
		return id_consulta;
	}

	public void setId_consulta(int id_consulta) {
		this.id_consulta = id_consulta;
	}

	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

	public int getId_mascota() {
		return id_mascota;
	}

	public void setId_mascota(int id_mascota) {
		this.id_mascota = id_mascota;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getId_detalleConsulta() {
		return id_detalleConsulta;
	}

	public void setId_detalleConsulta(int id_detalleConsulta) {
		this.id_detalleConsulta = id_detalleConsulta;
	}

	public String getRazon_consulta() {
		return razon_consulta;
	}

	public void setRazon_consulta(String razon_consulta) {
		this.razon_consulta = razon_consulta;
	}

	public double getCosto_consulta() {
		return costo_consulta;
	}

	public void setCosto_consulta(double costo_consulta) {
		this.costo_consulta = costo_consulta;
	}

	public String getFec_registro() {
		return fec_registro;
	}

	public void setFec_registro(String fec_registro) {
		this.fec_registro = fec_registro;
	}

	public String getFec_consulta() {
		return fec_consulta;
	}

	public void setFec_consulta(String fec_consulta) {
		this.fec_consulta = fec_consulta;
	}

}
