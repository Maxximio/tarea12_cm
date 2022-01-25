package ec.edu.uce.repository.jpa;

import ec.edu.uce.modelo.jpa.Arquitecto;

public interface IArquitectoRepo {

	void InsertarArquitecto(Arquitecto arqui);
	
	Arquitecto buscarArquitecto(Integer id);
	
	void ActualizarArquitecto(Arquitecto arqui);
	
	void borrarArquitecto(Integer id);
	
	Arquitecto buscarArquitectoApellido(String apellido);
	
	Arquitecto buscarArquitectoApellidoLista(String apellido);
	
	Arquitecto buscarArquitectoApellidoType(String apellido);
	
	Arquitecto buscarArquitectoApellidoNamed(String apellido);
	
	Arquitecto buscarArquitectoApellidoNative(String apellido);
}
