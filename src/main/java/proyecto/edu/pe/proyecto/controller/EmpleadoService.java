package proyecto.edu.pe.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.edu.pe.proyecto.DTO.DTOEmpleado;
import proyecto.edu.pe.proyecto.DTO.DTOLaboratorio;
import proyecto.edu.pe.proyecto.entity.Empleado;
import proyecto.edu.pe.proyecto.entity.Laboratorio;
import proyecto.edu.pe.proyecto.entity.Medicamento;
import proyecto.edu.pe.proyecto.repository.EmpleadoDAO;
import proyecto.edu.pe.proyecto.response.CreateEmpleadoResponse;
import proyecto.edu.pe.proyecto.response.CreateLaboratorioResponse;
import proyecto.edu.pe.proyecto.response.FindEmpleadoResponse;
import proyecto.edu.pe.proyecto.response.FindMedicamentosResponse;

import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoService {

    @Autowired
    EmpleadoDAO empleadoDAO;

    @GetMapping("/empleados")
    public FindEmpleadoResponse findMedicamentos(){
        Iterable<Empleado> empleados = empleadoDAO.findAll();

        return  new FindEmpleadoResponse("01",null, empleados);
    }

    @GetMapping("/find")
    public FindEmpleadoResponse findEmpleado(@RequestParam (value = "id", defaultValue= "0" )Integer id){

    Iterable<Empleado> empleados = null;

    if (id > 0){
        empleados = empleadoDAO.findAllById(List.of(id));
    }
        else {
    empleados = empleadoDAO.findAll();
    }
    return new FindEmpleadoResponse("01",null,empleados);

    }

    @PostMapping("add")
    public CreateEmpleadoResponse InsertarEmpleado(@RequestBody Empleado empleado)
    {
        if(empleado.getEmpleadoID() == 0) {
            Empleado emp = empleadoDAO.save(empleado);
            return new CreateEmpleadoResponse("01","Medicamento " + emp.getEmpleadoNombre() + " añadido");
        }
        else {
            return new CreateEmpleadoResponse("99","El parametro ID no esta permitido");
        }
    }

}
