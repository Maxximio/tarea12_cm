package ec.edu.uce.service;

import ec.edu.uce.modelo.jpa.Doctor;

public interface IDoctorService {

	void InsertarDoctorService(Doctor doctor);
	
	Doctor buscarDoctorService(Integer id);
	
	void ActualizarDoctorService(Doctor doctor);
	
	void borrarDoctorService(Integer id);
	
	Doctor buscarDoctorEspecialidadService(String especial);
	
	Doctor buscarDoctorEspecialidadListaService(String especial);
	
	Doctor buscarDoctorEspecialidadTypeService(String especial);
	
	Doctor buscarDoctorEspecialidadNamedService(String especial);
	
	Doctor buscarDoctorEspecialidadNativeService(String especial);
	
	Doctor buscarDoctorEspecialidadCriteriaService(String especial);
}
