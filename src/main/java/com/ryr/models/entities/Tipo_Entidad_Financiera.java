package com.ryr.models.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipos_entidades_financieras")
public class Tipo_Entidad_Financiera {
	
	@Id
	private long id_tipo_entidad;
	
	private String descripcion;
	
	private boolean activo;

	public long getId_tipo_entidad() {
		return id_tipo_entidad;
	}

	public void setId_tipo_entidad(long id_tipo_entidad) {
		this.id_tipo_entidad = id_tipo_entidad;
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
