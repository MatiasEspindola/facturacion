package com.ryr.models.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipos_tarjetas")
public class Tipo_Tarjeta {
	
	@Id
	private long id_tipo_tarjeta; 
	
	private String descripcion;
	
	private boolean activo;

	public long getId_tipo_tarjeta() {
		return id_tipo_tarjeta;
	}

	public void setId_tipo_tarjeta(long id_tipo_tarjeta) {
		this.id_tipo_tarjeta = id_tipo_tarjeta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
