package com.ryr.models.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "lista_precios_clientes")
public class Lista_Precio_Cliente {

	@Id
	private long id_lista_precio_cliente;

	
	
	private boolean defecto;
	
	

	public boolean isDefecto() {
		return defecto;
	}

	public void setDefecto(boolean defecto) {
		this.defecto = defecto;
	}

	public long getId_lista_precio_cliente() {
		return id_lista_precio_cliente;
	}

	public void setId_lista_precio_cliente(long id_lista_precio_cliente) {
		this.id_lista_precio_cliente = id_lista_precio_cliente;
	}

	

}
