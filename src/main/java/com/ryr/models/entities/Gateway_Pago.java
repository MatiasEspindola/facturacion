package com.ryr.models.entities;

import java.util.Date;

import javax.persistence.Column;
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
@Table(name="gateways_pagos")
public class Gateway_Pago {

	@Id
	private long id_gateway_pago;
	
	private String descripcion;
	
	private boolean activo;
	
	@Temporal(TemporalType.DATE)
	private Date alta;
	
	@JoinColumn(name = "id_medio_pago", referencedColumnName = "id_medio_pago")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Medio_Pago medio_pago;

	public long getId_gateway_pago() {
		return id_gateway_pago;
	}

	public void setId_gateway_pago(long id_gateway_pago) {
		this.id_gateway_pago = id_gateway_pago;
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

	public Date getAlta() {
		return alta;
	}

	public void setAlta(Date alta) {
		this.alta = alta;
	}

	public Medio_Pago getMedio_pago() {
		return medio_pago;
	}

	public void setMedio_pago(Medio_Pago medio_pago) {
		this.medio_pago = medio_pago;
	}
	
}
