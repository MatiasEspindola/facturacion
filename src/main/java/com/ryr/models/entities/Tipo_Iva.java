package com.ryr.models.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipos_iva")
public class Tipo_Iva {
	
	@Id
	private int iva_codigo;
	
	private String descripcion;

	public int getIva_codigo() {
		return iva_codigo;
	}

	public void setIva_codigo(int iva_codigo) {
		this.iva_codigo = iva_codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
