package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.entidad.Mascota;

public interface MascotaService {
	public abstract List<Mascota> listaMascota();
	public abstract Mascota insertaActualizaMascota(Mascota obj);
	public List<Mascota> listaMascotaConFiltro(String filtro);
	public abstract void eliminaMascota(int idMascota);
	public Optional<Mascota> buscaMascota(int id);

}
