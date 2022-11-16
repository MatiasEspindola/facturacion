package com.ryr.models.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="facturas")
public class Factura {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_factura")
	private Long id_factura;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha")
	private Date fecha;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="factura_id")
	@JsonManagedReference
	@JsonIgnore
	private List<ItemFactura> items;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="id_factura")
	@JsonManagedReference
	@JsonIgnore
	private List<Pago> pagos;
	
	@JoinColumn(name = "fk_cuenta_corriente", referencedColumnName = "id_cuenta_corriente")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Cuenta_Corriente cuenta_corriente;
	
	@JoinColumn(name = "fk_tipo_factura", referencedColumnName = "id_tipo_factura")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Tipo_Factura tipo_factura;
	
	private double total;
	
	private double subtotal;
	
	private String descripcion;
	
	private String descripcion_importe;
	
	//private double recargo;
	
	public Factura() {
		this.items = new ArrayList<ItemFactura>();
	}
	
	

	public Long getId_factura() {
		return id_factura;
	}

	public void setId_factura(Long id_factura) {
		this.id_factura = id_factura;
	}

	


	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	

	public String getDescripcion_importe() {
		return descripcion_importe;
	}



	public void setDescripcion_importe(String descripcion_importe) {
		this.descripcion_importe = descripcion_importe;
	}



	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}
	
	public void addItemFactura(ItemFactura item) {
		this.items.add(item);
	}
	
	

	public List<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cuenta_Corriente getCuenta_corriente() {
		return cuenta_corriente;
	}

	public void setCuenta_corriente(Cuenta_Corriente cuenta_corriente) {
		this.cuenta_corriente = cuenta_corriente;
	}

	public Tipo_Factura getTipo_factura() {
		return tipo_factura;
	}

	public void setTipo_factura(Tipo_Factura tipo_factura) {
		this.tipo_factura = tipo_factura;
	}

	/*public double getRecargo() {
		return recargo;
	}

	public void setRecargo(double recargo) {
		this.recargo = recargo;
	}*/
	
	
	
	
	
}
