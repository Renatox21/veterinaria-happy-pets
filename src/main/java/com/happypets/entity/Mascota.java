package com.happypets.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_mascota")
public class Mascota {

	@Id
	private int id_mascota;
	
	private String nombre_mascota;
	
	private String tipo_mascota;
	
	private String raza_mascota;
	
	private int id_vacunas;
	
	private String fec_mascota;
	
	private String fec_nac;

	public Mascota() {
		
	}

	public Mascota(int id_mascota, String nombre_mascota, String tipo_mascota, String raza_mascota, int id_vacunas,
			String fec_mascota, String fec_nac) {
		super();
		this.id_mascota = id_mascota;
		this.nombre_mascota = nombre_mascota;
		this.tipo_mascota = tipo_mascota;
		this.raza_mascota = raza_mascota;
		this.id_vacunas = id_vacunas;
		this.fec_mascota = fec_mascota;
		this.fec_nac = fec_nac;
	}

	public int getId_mascota() {
		return id_mascota;
	}

	public void setId_mascota(int id_mascota) {
		this.id_mascota = id_mascota;
	}

	public String getNombre_mascota() {
		return nombre_mascota;
	}

	public void setNombre_mascota(String nombre_mascota) {
		this.nombre_mascota = nombre_mascota;
	}

	public String getTipo_mascota() {
		return tipo_mascota;
	}

	public void setTipo_mascota(String tipo_mascota) {
		this.tipo_mascota = tipo_mascota;
	}

	public String getRaza_mascota() {
		return raza_mascota;
	}

	public void setRaza_mascota(String raza_mascota) {
		this.raza_mascota = raza_mascota;
	}

	public int getId_vacunas() {
		return id_vacunas;
	}

	public void setId_vacunas(int id_vacunas) {
		this.id_vacunas = id_vacunas;
	}

	public String getFec_mascota() {
		return fec_mascota;
	}

	public void setFec_mascota(String fec_mascota) {
		this.fec_mascota = fec_mascota;
	}

	public String getFec_nac() {
		return fec_nac;
	}

	public void setFec_nac(String fec_nac) {
		this.fec_nac = fec_nac;
	}
	
	
}
