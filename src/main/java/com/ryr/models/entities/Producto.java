package com.ryr.models.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.Transient;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "productos")
public class Producto {

	@Id
	private int pro_codigo;

	private String pro_cod_bar;

	private String descripcion;

	private int stock_actual;

	private String precio_costo;

	private String precio_neto;

	private String iva;


	private int baja;



	

	

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "fkidproductolista")
	@JsonIgnore
	private List<Producto_Lista> productos_lista;

	public int getPro_codigo() {
		return pro_codigo;
	}

	public void setPro_codigo(int pro_codigo) {
		this.pro_codigo = pro_codigo;
	}

	public String getPro_cod_bar() {
		return pro_cod_bar;
	}

	public void setPro_cod_bar(String pro_cod_bar) {
		this.pro_cod_bar = pro_cod_bar;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

	public int getStock_actual() {
		return stock_actual;
	}

	public void setStock_actual(int stock_actual) {
		this.stock_actual = stock_actual;
	}

	public String getPrecio_costo() {
		return precio_costo;
	}

	public void setPrecio_costo(String precio_costo) {
		this.precio_costo = precio_costo;
	}

	

	public String getPrecio_neto() {
		return precio_neto;
	}

	public void setPrecio_neto(String precio_neto) {
		this.precio_neto = precio_neto;
	}

	public String getIva() {
		return iva;
	}

	public void setIva(String iva) {
		this.iva = iva;
	}

	

	public int getBaja() {
		return baja;
	}

	public void setBaja(int baja) {
		this.baja = baja;
	}

	


	public List<Producto_Lista> getProductos_lista() {
		return productos_lista;
	}

	public void setProductos_lista(List<Producto_Lista> productos_lista) {
		this.productos_lista = productos_lista;
	}

}
