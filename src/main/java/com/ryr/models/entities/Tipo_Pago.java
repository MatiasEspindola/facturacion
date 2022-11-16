package com.ryr.models.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tipos_pagos")
public class Tipo_Pago {

	@Id
	private long id_tipo_pago;

	private String nombre;

	private double porcentaje;

	private boolean defecto;
	
	private int cuotas;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "fkidlistatipopago")
	@JsonIgnore
	private List<Tipo_Pago_Lista_Precio> tipos_pagos_listas;
	
	

	public long getId_tipo_pago() {
		return id_tipo_pago;
	}

	public void setId_tipo_pago(long id_tipo_pago) {
		this.id_tipo_pago = id_tipo_pago;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public boolean isDefecto() {
		return defecto;
	}

	public void setDefecto(boolean defecto) {
		this.defecto = defecto;
	}

	public List<Tipo_Pago_Lista_Precio> getTipos_pagos_listas() {
		return tipos_pagos_listas;
	}

	public void setTipos_pagos_listas(List<Tipo_Pago_Lista_Precio> tipos_pagos_listas) {
		this.tipos_pagos_listas = tipos_pagos_listas;
	}

	
	public int getCuotas() {
		return cuotas;
	}

	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}
	
	

}
