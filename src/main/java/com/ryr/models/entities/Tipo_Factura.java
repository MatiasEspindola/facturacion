package com.ryr.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipos_facturas")
public class Tipo_Factura {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_tipo_factura;
	
	private String tipo_factura;
	
	private String cod_tipo_factura;

	public long getId_tipo_factura() {
		return id_tipo_factura;
	}

	public void setId_tipo_factura(long id_tipo_factura) {
		this.id_tipo_factura = id_tipo_factura;
	}

	public String getTipo_factura() {
		return tipo_factura;
	}

	public void setTipo_factura(String tipo_factura) {
		this.tipo_factura = tipo_factura;
	}

	public String getCod_tipo_factura() {
		return cod_tipo_factura;
	}

	public void setCod_tipo_factura(String cod_tipo_factura) {
		this.cod_tipo_factura = cod_tipo_factura;
	}

}
