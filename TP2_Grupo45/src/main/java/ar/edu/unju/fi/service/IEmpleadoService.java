package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Empleado;


public interface IEmpleadoService {

	List<Empleado> getEmpleados();
    Empleado getEmpleadoById(Long id);
    void guardarEmpleado(Empleado empleado);
    void actualizarEmpleado(Empleado empleadoActualizado);
    void eliminarEmpleado(Empleado empleado);

    Empleado getEmpleado();
	List<Empleado> getEmpleadosPorDia(String dia);
	
}
