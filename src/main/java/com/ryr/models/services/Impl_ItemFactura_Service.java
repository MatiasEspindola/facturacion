package com.ryr.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.ItemFactura;
import com.ryr.models.repo.I_ItemFactura_Repo;

@Service
public class Impl_ItemFactura_Service implements I_ItemFactura_Service {

	@Autowired
	private I_ItemFactura_Repo repo;
	
	@Override
	public List<ItemFactura> listarTodo() {
		// TODO Auto-generated method stub
		return (List<ItemFactura>) repo.findAll();
	}

	@Override
	public ItemFactura buscarPorId(long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

}
