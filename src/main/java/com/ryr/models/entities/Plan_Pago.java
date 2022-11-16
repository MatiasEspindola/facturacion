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
@Table(name="planes_pagos")
public class Plan_Pago {

	@Id
	private long id_plan_pago;
	
	private String descripcion;
	
	private int cuotas;
	
	private double interes;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date alta;
	
	private boolean activo;
	
	@JoinColumn(name = "tarjeta_fk", referencedColumnName = "id_tarjeta")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Tarjeta tarjeta;
	
	/*@JoinColumn(name = "gateway_fk", referencedColumnName = "id_gateway_pago")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Gateway_Pago gateway;*/
	
	@JoinColumn(name = "mediopago_fk", referencedColumnName = "id_medio_pago")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Medio_Pago medio_pago;

	public long getId_plan_pago() {
		return id_plan_pago;
	}

	public void setId_plan_pago(long id_plan_pago) {
		this.id_plan_pago = id_plan_pago;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCuotas() {
		return cuotas;
	}

	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
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

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	/*public Gateway_Pago getGateway() {
		return gateway;
	}

	public void setGateway(Gateway_Pago gateway) {
		this.gateway = gateway;
	}*/

	public Medio_Pago getMedio_pago() {
		return medio_pago;
	}

	public void setMedio_pago(Medio_Pago medio_pago) {
		this.medio_pago = medio_pago;
	}
	
	
}
