package com.happypets.entity;

import javax.persistence.Column;
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
@Table(name = "tb_comprobante_pago")
public class Comprobante {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "num_comprobante_pago")
	private String num;
	
	@Column(name = "tipo_comprobante")
	private String tipo_comprobante;
	
	@Column(name = "ruc")
	private String ruc;
	
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "id_cliente")
	private int id_cliente;
	
	@Column(name = "id_empleado")
	private int id_empleado;
	
	
}
