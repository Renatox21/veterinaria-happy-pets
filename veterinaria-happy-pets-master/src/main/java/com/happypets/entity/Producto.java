package com.happypets.entity;

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
	private int id_producto;
	
	private String desc_product;
	
	private int stock;
	
	private double pre_uni;
	
	private int id_categoria;	
	
}
