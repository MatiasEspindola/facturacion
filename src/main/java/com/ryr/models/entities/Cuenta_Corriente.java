package com.ryr.models.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="cuentas_corrientes")
public class Cuenta_Corriente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_cuenta_corriente;
	
	private double saldo;
	
	private double haber;
	
	private double debe;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	
	

	
	@JoinColumn(name = "fkidclicodigo", referencedColumnName = "cli_codigo")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Cliente cliente;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="fk_cuenta_corriente")
	@JsonManagedReference
	@JsonIgnore
	private List<Factura> facturas;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="id_cuenta_corriente")
	@JsonManagedReference
	@JsonIgnore
	private List<Comprobante> comprobantes;
	
	

	public List<Comprobante> getComprobantes() {
		return comprobantes;
	}

	public void setComprobantes(List<Comprobante> comprobantes) {
		this.comprobantes = comprobantes;
	}

	public long getId_cuenta_corriente() {
		return id_cuenta_corriente;
	}

	public void setId_cuenta_corriente(long id_cuenta_corriente) {
		this.id_cuenta_corriente = id_cuenta_corriente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getHaber() {
		return haber;
	}

	public void setHaber(double haber) {
		this.haber = haber;
	}

	public double getDebe() {
		return debe;
	}

	public void setDebe(double debe) {
		this.debe = debe;
	}

	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
	
	
	

}
