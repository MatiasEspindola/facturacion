package com.ryr.models.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="tarjetas")
public class Tarjeta {
	
	@Id
	private long id_tarjeta;
	
	private String descripcion;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date alta;
	
	private boolean activo;
	
	@JoinColumn(name = "id_tipo_tarjeta", referencedColumnName = "id_tipo_tarjeta")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Tipo_Tarjeta tipo_tarjeta;
	
	@JoinColumn(name = "id_entidad_financiera", referencedColumnName = "id_entidad_financiera")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Entidad_Financiera entidad_financiera;
	
	@JoinColumn(name = "id_marca", referencedColumnName = "id_marca")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Marca_Tarjeta marca;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "tarjeta_fk")
	@JsonManagedReference
	@JsonIgnore
	private List<Plan_Pago> planes_pagos;
	

	private double arancel;

	public long getId_tarjeta() {
		return id_tarjeta;
	}

	public void setId_tarjeta(long id_tarjeta) {
		this.id_tarjeta = id_tarjeta;
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

	public Tipo_Tarjeta getTipo_tarjeta() {
		return tipo_tarjeta;
	}

	public void setTipo_tarjeta(Tipo_Tarjeta tipo_tarjeta) {
		this.tipo_tarjeta = tipo_tarjeta;
	}

	public Entidad_Financiera getEntidad_financiera() {
		return entidad_financiera;
	}

	public void setEntidad_financiera(Entidad_Financiera entidad_financiera) {
		this.entidad_financiera = entidad_financiera;
	}

	public double getArancel() {
		return arancel;
	}

	public void setArancel(double arancel) {
		this.arancel = arancel;
	}

	public List<Plan_Pago> getPlanes_pagos() {
		return planes_pagos;
	}

	public void setPlanes_pagos(List<Plan_Pago> planes_pagos) {
		this.planes_pagos = planes_pagos;
	}

	public Marca_Tarjeta getMarca() {
		return marca;
	}

	public void setMarca(Marca_Tarjeta marca) {
		this.marca = marca;
	}
	
	
	
	

}
