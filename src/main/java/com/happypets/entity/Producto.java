package com.happypets.entity;

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
@Table(name = "tb_producto")
public class Producto {

	@Id	
	@Column(name = "id_producto")
	private int id_producto;
	
	@Column(name = "desc_producto")
	private String desc_product;
	
	@Column(name = "stock")
	private int stock;
	
	@Column(name = "pre_uni")
	private double pre_uni;
	
	@Column(name = "id_categoria")
	private int id_categoria;	
	
}
