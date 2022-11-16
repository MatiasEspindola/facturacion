package com.ryr.models.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="medios_pagos")
public class Medio_Pago {
	
	@Id
	private long id_medio_pago;
	
	private String descripcion;
	
	private boolean activo;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "id_medio_pago")
	@JsonManagedReference
	@JsonIgnore
	private List<Gateway_Pago> gateways;
	

	public long getId_medio_pago() {
		return id_medio_pago;
	}

	public void setId_medio_pago(long id_medio_pago) {
		this.id_medio_pago = id_medio_pago;
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

	public List<Gateway_Pago> getGateways() {
		return gateways;
	}

	public void setGateways(List<Gateway_Pago> gateways) {
		this.gateways = gateways;
	}



}
