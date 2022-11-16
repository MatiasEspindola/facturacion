package com.ryr.models.services;

import java.util.List;

import com.ryr.models.entities.ItemFactura;

public interface I_ItemFactura_Service {

	public List<ItemFactura> listarTodo();
	
	public ItemFactura buscarPorId(long id);
	
}
