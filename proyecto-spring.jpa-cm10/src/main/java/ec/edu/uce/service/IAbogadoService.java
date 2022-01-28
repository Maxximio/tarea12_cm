package ec.edu.uce.service;

import ec.edu.uce.modelo.jpa.Abogado;

public interface IAbogadoService {

	void InsertarAbogadoService(Abogado abo);
	
	Abogado buscarAbogadoService(Integer id);
	
	void ActualizarAbogadoService(Abogado abo);
	
	void borrarAbogadoService(Integer id);
	
	Abogado buscarAbogadoFirmaService(String firma);
	
	Abogado buscarAbogadoFirmaListaService(String firma);
	
	Abogado buscarAbogadoFirmaTypeService(String firma);
	
	Abogado buscarAbogadoFirmaNamedService(String firma);
	
	Abogado buscarAbogadoFirmaNativeService(String firma);
	
	Abogado buscarAbogadoFirmaCriteriaService(String firma);
}
