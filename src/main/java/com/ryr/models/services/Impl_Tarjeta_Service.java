package com.ryr.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.Tarjeta;
import com.ryr.models.repo.I_Tarjeta_Repo;

@Service
public class Impl_Tarjeta_Service implements I_Tarjeta_Service {

	@Autowired
	private I_Tarjeta_Repo repo;
	
	@Override
	public List<Tarjeta> listar() {
		// TODO Auto-generated method stub
		return (List<Tarjeta>) repo.findAll();
	}

	@Override
	public Tarjeta buscarPorId(long id_tarjeta) {
		// TODO Auto-generated method stub
		return repo.findById(id_tarjeta).orElse(null);
	}

	@Override
	public List<Tarjeta> buscarTarjetasDebito() {
		// TODO Auto-generated method stub
		return repo.buscarTarjetasDebito();
	}

	@Override
	public List<Tarjeta> buscarTarjetasCredito() {
		// TODO Auto-generated method stub
		return repo.buscarTarjetasCredito();
	}

	@Override
	public List<Tarjeta> agruparTarjetas() {
		// TODO Auto-generated method stub
		return repo.agruparTarjetas();
	}

	@Override
	public void guardar(Tarjeta tarjeta) {
		// TODO Auto-generated method stub
		repo.save(tarjeta);
	}

}
