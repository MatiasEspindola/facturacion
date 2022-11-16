package com.ryr.models.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="marcas_tarjetas")
public class Marca_Tarjeta {
	
	@Id
	private long id_marca;
	
	private String descripcion;

	public long getId_marca() {
		return id_marca;
	}

	public void setId_marca(long id_marca) {
		this.id_marca = id_marca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
