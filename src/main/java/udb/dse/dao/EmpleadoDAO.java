package udb.dse.dao;

import java.util.List;

import udb.dse.controlador.entity.Empleado;

public interface EmpleadoDAO {

	public List<Empleado> getEmpleados();

	public void insertarEmpleado(Empleado elEmpleado);

	public Empleado getEmpleado(int id);

	public void eliminarEmpleado(int id);
}
