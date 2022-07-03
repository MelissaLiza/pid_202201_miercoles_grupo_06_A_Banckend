package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entidad.Mascota;
import com.cibertec.repository.MascotaRepository;

@Service
public  class MascotaServiceImp  implements MascotaService{

	@Autowired
	private MascotaRepository repository;
	
	@Override
	public List<Mascota> listaMascota() {
		return repository.findAll();
	}

	@Override
	public Mascota insertaActualizaMascota(Mascota obj) {
		return repository.save(obj);
	}

	@Override
	public List<Mascota> listaMascotaConFiltro(String filtro) {
		return repository.listaMascotaConFiltro(filtro);
	}

	@Override
	public void eliminaMascota(int idMascota) {
		 repository.deleteById(idMascota);
	}

	@Override
	public Optional<Mascota> buscaMascota(int id) {
		return repository.findById(id);
	}

}
