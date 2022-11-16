package com.ryr.models.repo;

import org.springframework.data.repository.CrudRepository;

import com.ryr.models.entities.ItemFactura;

public interface I_ItemFactura_Repo extends CrudRepository<ItemFactura, Long> {
	
}
