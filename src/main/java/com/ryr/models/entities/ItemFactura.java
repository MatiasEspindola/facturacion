package com.ryr.models.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="facturas_items")
public class ItemFactura {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Integer cantidad;
	
	private Double importe;
	

	private String tipo_iva;
	
	private Double total;
	
	@JoinColumn(name = "fkprocodigo", referencedColumnName = "id_lista_producto")
	@ManyToOne(fetch = FetchType.EAGER)
	private Producto_Lista fkprocodigo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public Long calcularImporte() {
		return cantidad.longValue();
	}

	

	public Producto_Lista getFkprocodigo() {
		return fkprocodigo;
	}

	public void setFkprocodigo(Producto_Lista fkprocodigo) {
		this.fkprocodigo = fkprocodigo;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}



	public String getTipo_iva() {
		return tipo_iva;
	}

	public void setTipo_iva(String tipo_iva) {
		this.tipo_iva = tipo_iva;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
}
