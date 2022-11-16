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
@Table(name="pagos_ventas")
public class Venta_Pago {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_pago_venta;
	
	@JoinColumn(name = "fk_pago", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Pago pago;
	
	@JoinColumn(name = "fk_venta", referencedColumnName = "id_venta")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Venta venta;

	public long getId_pago_venta() {
		return id_pago_venta;
	}

	public void setId_pago_venta(long id_pago_venta) {
		this.id_pago_venta = id_pago_venta;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

}
