package ec.edu.uce.service;

import ec.edu.uce.modelo.jpa.Mesero;

public interface IMeseroService {

	void InsertarMeseroService(Mesero mes);
	
	Mesero buscarMeseroService(Integer id);
	
	void ActualizarMeseroService(Mesero mes);
	
	void borrarMeseroService(Integer id);
	
	Mesero buscarMeseroRestauranteService(String restaurante);
	
	Mesero buscarMeseroRestauranteListaService(String restaurante);
	
	Mesero buscarMeseroRestauranteTypeService(String restaurante);
	
	Mesero buscarMeseroRestauranteNamedService(String restaurante);
	
	Mesero buscarMeseroRestauranteNativeService(String restaurante);
}
