package com.ryr.models.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="ventas")
public class Venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_venta;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	
	@JoinColumn(name = "id_comprobante", referencedColumnName = "id_comprobante")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Comprobante comprobante;

	public long getId_venta() {
		return id_venta;
	}

	public void setId_venta(long id_venta) {
		this.id_venta = id_venta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Comprobante getComprobante() {
		return comprobante;
	}

	public void setComprobante(Comprobante comprobante) {
		this.comprobante = comprobante;
	}
	
}
