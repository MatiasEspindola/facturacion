package com.ryr.models.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="entidades_financieras")
public class Entidad_Financiera {
	
	@Id
	private long id_entidad_financiera;
	
	private String descripcion;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date alta;
	
	private boolean activo;
	
	private String cuit;
	
	@JoinColumn(name = "id_tipo_entidad", referencedColumnName = "id_tipo_entidad")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Tipo_Entidad_Financiera tipo_entidad;

	public long getId_entidad_financiera() {
		return id_entidad_financiera;
	}

	public void setId_entidad_financiera(long id_entidad_financiera) {
		this.id_entidad_financiera = id_entidad_financiera;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getAlta() {
		return alta;
	}

	public void setAlta(Date alta) {
		this.alta = alta;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public Tipo_Entidad_Financiera getTipo_entidad() {
		return tipo_entidad;
	}

	public void setTipo_entidad(Tipo_Entidad_Financiera tipo_entidad) {
		this.tipo_entidad = tipo_entidad;
	}

}
