package com.ryr.models.entities;

import java.util.Date;

import javax.persistence.Column;
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
@Table(name="comprobantes")
public class Comprobante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_comprobante;
	
	private String comprobante;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha")
	private Date fecha;
	
	@JoinColumn(name = "id_cuenta_corriente", referencedColumnName = "id_cuenta_corriente")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Cuenta_Corriente cuenta_corriente;

	public long getId_comprobante() {
		return id_comprobante;
	}

	public void setId_comprobante(long id_comprobante) {
		this.id_comprobante = id_comprobante;
	}

	public String getComprobante() {
		return comprobante;
	}

	public void setComprobante(String comprobante) {
		this.comprobante = comprobante;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cuenta_Corriente getCuenta_corriente() {
		return cuenta_corriente;
	}

	public void setCuenta_corriente(Cuenta_Corriente cuenta_corriente) {
		this.cuenta_corriente = cuenta_corriente;
	}
	
	
	

}
