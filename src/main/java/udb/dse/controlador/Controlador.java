package udb.dse.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import udb.dse.controlador.entity.Empleado;
import udb.dse.dao.EmpleadoDAO;

@Controller
@RequestMapping("/empleado")
public class Controlador {

	@RequestMapping("/lista")
	public String listaEmpleados(Model elModelo) {
		
		//Obtener empleados desde DAO
		List<Empleado> losEmpleados = empleadoDAO.getEmpleados();
		
		//Agregar clientes al modelo
		elModelo.addAttribute("empleados",losEmpleados);
		
		return "lista-empleados";
	}
	
	@RequestMapping("/Agregar")
	public String muestraFormularioAgregar(Model elModelo) {
		
		//Bind datos empleado
		Empleado elEmpleado = new Empleado();
		elModelo.addAttribute("empleado",elEmpleado);
		
		return "FormularioAgregar";
	}
	
	@PostMapping("/insertarEmpleado")
	public String insertarEmpleado(@ModelAttribute("empleado") Empleado elEmpleado) {
		
		//Insertar empleado en BBDD
		empleadoDAO.insertarEmpleado(elEmpleado);
		
		return "redirect:/empleado/lista";
	}
	
	@GetMapping("/Actualizar")
	public String actualizarEmpleado(@RequestParam("empleadoId") int id, Model elModelo) {
		
		//Obtener Empleado
		
		Empleado elEmpleado = empleadoDAO.getEmpleado(id);
		
		//Establecer cliente cmo atributo de modelo
		elModelo.addAttribute("empleado", elEmpleado);
		
		//Enviar al formulario
		
		return "FormularioAgregar";
	}
	
	@GetMapping("/Eliminar")
	public String eliminarEmpleado(@RequestParam("empleadoId") int id) {
		
		//Eliminar Empleado
		
		empleadoDAO.eliminarEmpleado(id);
		
		//Redireccionar a lista empleado
		
		return "redirect:/empleado/lista";
	}
	
	@Autowired
	private EmpleadoDAO empleadoDAO;
}
