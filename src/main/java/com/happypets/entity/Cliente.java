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
@Table(name="tb_cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private int idCliente;
	
	@Column(name="dni_cliente")
	private String dni;
	
	@Column(name="nom_cliente")
	private String nombre;
	
	@Column(name="ape_cliente")
	private String apellido;
	
	@Column(name="correo_cliente") 
	private String correo;
	
	@Column(name="tef_cliente")
	private String telefono;
	
	@Column(name="dirc_cliente")
	private String direccion;
	
	@Column(name="sexo_cliente")
	private String sexo;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@JsonDeserialize(using = SqlDateDeserializer.class)
	@Temporal(TemporalType.DATE)
	@Column(name="fec_reg")
	private Date fRegistro;
	
}
