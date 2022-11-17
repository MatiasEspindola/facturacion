package com.ryr.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipos_iva")
public class Tipo_Iva {
	
	@Id
	@Column(name="iva_codigo")
	private long id_tipo_iva;
	
	private String descripcion;

	


	public long getId_tipo_iva() {
		return id_tipo_iva;
	}

	public void setId_tipo_iva(long id_tipo_iva) {
		this.id_tipo_iva = id_tipo_iva;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
