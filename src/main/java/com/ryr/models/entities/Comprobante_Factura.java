package com.ryr.models.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="comprobantes_facturas")
public class Comprobante_Factura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_comprobante_factura;
	
	@JoinColumn(name = "fk_comprobante", referencedColumnName = "id_comprobante")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Comprobante comprobante;
	
	@JoinColumn(name = "fk_factura", referencedColumnName = "id_factura")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Factura factura;

	public long getId_comprobante_factura() {
		return id_comprobante_factura;
	}

	public void setId_comprobante_factura(long id_comprobante_factura) {
		this.id_comprobante_factura = id_comprobante_factura;
	}

	public Comprobante getComprobante() {
		return comprobante;
	}

	public void setComprobante(Comprobante comprobante) {
		this.comprobante = comprobante;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	

}
