package com.ryr.models.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	private int cli_codigo;

	private String cpostal;

	private String email;

	private String razon_social;

	private String telefono_1;

	private String telefono_2;

	private String direccion;

	private String nro_documento;

	private String localidad;

	private String provincia;

	@JoinColumn(name = "fkidtipocliente", referencedColumnName = "id_tipo_cliente")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Tipo_Cliente fkidtipocliente;

	@JoinColumn(name = "fkidtipodocumento", referencedColumnName = "id_tipo_documento")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Tipo_Documento fkidtipodocumento;
	
	@JoinColumn(name = "id_lista_precio", referencedColumnName = "id_lista_precio")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Lista_Precio fkidlistaprecio;

	@JoinColumn(name = "iva_codigo", referencedColumnName = "iva_codigo")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Tipo_Iva fkivacodigo;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "fkidclicodigo")
	@JsonIgnore
	private List<Cuenta_Corriente> cuenta_corriente;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public Tipo_Cliente getFkidtipocliente() {
		return fkidtipocliente;
	}

	public void setFkidtipocliente(Tipo_Cliente fkidtipocliente) {
		this.fkidtipocliente = fkidtipocliente;
	}

	public String getTelefono_1() {
		return telefono_1;
	}

	public void setTelefono_1(String telefono_1) {
		this.telefono_1 = telefono_1;
	}

	public String getTelefono_2() {
		return telefono_2;
	}

	public void setTelefono_2(String telefono_2) {
		this.telefono_2 = telefono_2;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNro_documento() {
		return nro_documento;
	}

	public void setNro_documento(String nro_documento) {
		this.nro_documento = nro_documento;
	}

	public Tipo_Documento getFkidtipodocumento() {
		return fkidtipodocumento;
	}

	public void setFkidtipodocumento(Tipo_Documento fkidtipodocumento) {
		this.fkidtipodocumento = fkidtipodocumento;
	}

	public int getCli_codigo() {
		return cli_codigo;
	}

	public void setCli_codigo(int cli_codigo) {
		this.cli_codigo = cli_codigo;
	}

	

	

	public String getCpostal() {
		return cpostal;
	}

	public void setCpostal(String cpostal) {
		this.cpostal = cpostal;
	}

	

	public Tipo_Iva getFkivacodigo() {
		return fkivacodigo;
	}

	public void setFkivacodigo(Tipo_Iva fkivacodigo) {
		this.fkivacodigo = fkivacodigo;
	}

	public Lista_Precio getFkidlistaprecio() {
		return fkidlistaprecio;
	}

	public void setFkidlistaprecio(Lista_Precio fkidlistaprecio) {
		this.fkidlistaprecio = fkidlistaprecio;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public List<Cuenta_Corriente> getCuenta_corriente() {
		return cuenta_corriente;
	}

	public void setCuenta_corriente(List<Cuenta_Corriente> cuenta_corriente) {
		this.cuenta_corriente = cuenta_corriente;
	}
	
	

}
