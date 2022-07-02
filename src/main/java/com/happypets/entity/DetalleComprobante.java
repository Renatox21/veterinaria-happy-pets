package com.happypets.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_detalle_comprobante")
public class DetalleComprobante {

	@Column(name = "cantidad")
	private int cantidad;
	
	@Column(name = "pre_uni")
	private double pre_uni;
	
	@Column(name = "descuento")
	private double descuento;
	
}
