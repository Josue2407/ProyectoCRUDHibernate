package udb.dse.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import udb.dse.controlador.entity.Empleado;

@Repository
public class EmpleadoDAOClase implements EmpleadoDAO{

	@Override
	@Transactional
	public List<Empleado> getEmpleados() {
		// TODO Auto-generated method stub
		
		//Obtener Sesion
		Session miSesion = sessionFactory.getCurrentSession();
		
		//Crear consulta
		Query<Empleado> miQuery = miSesion.createQuery("from Empleado", Empleado.class);
		
		//Ejecutar query
		List<Empleado> empleados = miQuery.getResultList();
		
		return empleados;
	}
	
	
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	@Transactional
	public void insertarEmpleado(Empleado elEmpleado) {
		// TODO Auto-generated method stub
		
		//Obtener Sesion
		Session miSesion = sessionFactory.getCurrentSession();
		
		//Insertar Empleado
		//miSesion.save(elEmpleado);
		miSesion.saveOrUpdate(elEmpleado);
	}


	@Override
	@Transactional
	public Empleado getEmpleado(int id) {
		// TODO Auto-generated method stub
		
		//Obtener Sesion
	    Session miSesion = sessionFactory.getCurrentSession();
	    
	    //Obtener informacion de empleado seleccionado
	    Empleado elEmpleado = miSesion.get(Empleado.class,id);
		
		return elEmpleado;
	}


	@Override
	@Transactional
	public void eliminarEmpleado(int id) {
		// TODO Auto-generated method stub
		
		//Obtener Sesion
	    Session miSesion = sessionFactory.getCurrentSession();
	    
	    //Borrar empleado
	    Query consulta = miSesion.createQuery("delete from Empleado where id=:IdEmpleado");
	    consulta.setParameter("IdEmpleado", id);
	    consulta.executeUpdate();
	}

}
