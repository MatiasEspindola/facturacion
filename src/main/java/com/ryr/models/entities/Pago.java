package com.ryr.models.entities;

import java.sql.Time;
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
@Table(name="pagos")
public class Pago {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@JoinColumn(name = "id_factura", referencedColumnName = "id_factura")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Factura id_factura;
	
	@JoinColumn(name = "fk_medio_pago", referencedColumnName = "id_medio_pago")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Medio_Pago medio_pago;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	private double subtotal;
	
	private long descuento;
	
	private boolean aprobado;
	
	private double total;
	
	private String descripcion;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Factura getId_factura() {
		return id_factura;
	}

	public void setId_factura(Factura id_factura) {
		this.id_factura = id_factura;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public long getDescuento() {
		return descuento;
	}

	public void setDescuento(long descuento) {
		this.descuento = descuento;
	}

	public boolean isAprobado() {
		return aprobado;
	}

	public void setAprobado(boolean aprobado) {
		this.aprobado = aprobado;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Medio_Pago getMedio_pago() {
		return medio_pago;
	}

	public void setMedio_pago(Medio_Pago medio_pago) {
		this.medio_pago = medio_pago;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
		
}
